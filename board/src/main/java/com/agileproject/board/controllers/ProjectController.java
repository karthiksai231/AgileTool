package com.agileproject.board.controllers;

import com.agileproject.board.domain.Project;
import com.agileproject.board.services.ProjectService;
import com.agileproject.board.services.RequestValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private RequestValidationService requestValidationService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Project project, BindingResult result) {
        ResponseEntity<?> validationRequest = requestValidationService.requestValidation(result);

        if (validationRequest != null) {
            return validationRequest;
        }

        Project createdProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectIdentifier) {
        Project project = projectService.findProjectByIdentifier(projectIdentifier);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

}
