package org.aibles.worker2.controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.dto.SearchSpecification;
import org.aibles.worker2.dto.SearchSpecificationBuilder;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/workers")
@Slf4j
public class WorkerController {

  private final WorkerService workerService;

  @Autowired
  public WorkerController(WorkerService workerService) {
    this.workerService = workerService;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@PathVariable("id") int workerId) {

    workerService.delete(workerId);
    return "Successful delete";
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WorkerDto created(@RequestBody @Validated() WorkerDto workerDto) {
    return workerService.created(workerDto);
  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<WorkerDto> list(@RequestParam(required = false) Map<String, String> params) {
    return workerService.list(params);
  }



  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public WorkerDto update(@PathVariable("id") int workerId, @RequestBody @Valid WorkerDto workerDto) {
    return workerService.update(workerId, workerDto);
  }

}

