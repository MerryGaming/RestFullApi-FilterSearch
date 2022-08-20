package org.aibles.worker2.mapper;

import static com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.instance;

import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.modelmapper.ModelMapper;

public class WorkerMapper {
  private final ModelMapper modelMapper;

  public WorkerMapper(ModelMapper modelMapper, WorkerMapper instant) {
    this.modelMapper = modelMapper;
    this.instant = instant;
  }
  private final WorkerMapper instant ;

//  private static OptionalHandlerFactory getInstance(){
//    if(instance == null){
//      instance = new WorkerMapper();
//    }
//    return instance;
//  }

  public WorkerDto mapToDto(Worker worker) {
    return modelMapper.map(worker, WorkerDto.class);
  }

  public Worker mapToEntity(Worker worker, WorkerDto workerDto) {
    modelMapper.map(worker, worker);
    return worker;
  }
}
