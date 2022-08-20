package org.aibles.worker2.service.impl;

import com.sun.jdi.InternalException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.dto.SearchSpecificationBuilder;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.exeption.ResourceNotFoundException;
import org.aibles.worker2.mapper.WorkerMapper;
import org.aibles.worker2.repository.WorkerRepository;
import org.aibles.worker2.service.WorkerService;

import javax.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class WorkerServiceImpl implements WorkerService {
  private final WorkerRepository workerRepository;
  private final WorkerMapper modelMapper;

  public WorkerServiceImpl(WorkerRepository workerRepository, WorkerMapper modelMapper) {
    this.workerRepository = workerRepository;
    this.modelMapper = modelMapper;
  }
    /**
     * created worker
     *
     * @param workerDto
     * @return
     */
    @Override
    @Transactional
    public WorkerDto created(WorkerDto workerDto) {
      log.info("(Create) Create dto");
      Worker worker = new Worker();
      worker = modelMapper.mapToEntity(worker, workerDto);
      Worker create = workerRepository.save(worker);
      Optional.ofNullable(create)
          .orElseThrow(
              () -> {
                throw new InternalException("404_Not_Found");
              });
      WorkerDto workerDtoCreate = modelMapper.mapToDto(create);
      return workerDtoCreate;
    }

  /**
   * delete worker
   *
   * @param id
   * @return
   */
  @Override
  @Transactional
  public void delete(int id) {
    workerRepository.deleteById(id);
    log.info("Delete");
  }

  @Override
  //@Transactional
  public List<WorkerDto> list(Map<String, String> params) {
    SearchSpecificationBuilder builder = new SearchSpecificationBuilder();
    for (String fidd : params.keySet()) {
      builder.with(fidd, params.get(fidd));
    }
    Specification<Worker> specification = builder.build();

    return workerRepository.findAll(specification).stream()
        .map(modelMapper::mapToDto)
        .collect(Collectors.toList());
  }


  /**
   * update worker
   *
   * @param id
   * @param workerDto
   * @return
   */
    @Override
    @Transactional
    public WorkerDto update(int id, WorkerDto workerDto) {
      log.info("(Update) Update worker by id");
      Worker workerCheck =
          workerRepository
              .findById(id)
              .orElseThrow(
                  () -> {
                    throw new ResourceNotFoundException("Worker not found! ");
                  });
      Worker worker = new Worker();
      worker = modelMapper.mapToEntity(worker, workerDto);
      worker.setId(workerCheck.getId());
      Worker update = workerRepository.save(worker);
      Optional.of(update)
          .orElseThrow(
              () -> {
                throw new InternalException("Update found, update again!!");
              });
      WorkerDto workerDtoUpdated = modelMapper.mapToDto(update);
      return workerDtoUpdated;
    }
}
