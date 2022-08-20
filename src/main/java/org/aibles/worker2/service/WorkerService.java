package org.aibles.worker2.service;

import java.util.List;
import java.util.Map;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.domain.Specification;

public interface WorkerService {
    WorkerDto created (WorkerDto workerDto);
    //Worker created(Worker worker);
    void delete(int id);

    //List<Worker> search (WorkerDto workerDto, SearchSpecification searchSpecification);

    // List<Worker> list(Specification<Worker> spec);
     List<WorkerDto> list(Map<String, String> params);

     WorkerDto update (int id, WorkerDto workerDto);
}
