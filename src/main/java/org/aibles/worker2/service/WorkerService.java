package org.aibles.worker2.service;

import java.util.List;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.validation.SearchCriteria;
import org.aibles.worker2.validation.SearchList;
import org.springframework.data.jpa.domain.Specification;

public interface WorkerService {
    WorkerDto created (WorkerDto workerDto);
    void delete(int id);

     List<Worker> list();
     List<WorkerDto> listSearch(SearchList searchList);

     WorkerDto update (int id, WorkerDto workerDto);
}
