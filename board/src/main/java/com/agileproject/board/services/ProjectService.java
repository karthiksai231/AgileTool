package com.agileproject.board.services;

import com.agileproject.board.domain.Project;
import com.agileproject.board.exceptions.InvalidProjectIdentifierException;
import com.agileproject.board.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception ex) {
            throw new InvalidProjectIdentifierException(MessageFormat.format("Project Identifier {0} already exists", project.getProjectIdentifier().toUpperCase()));
        }
    }

    public  Project findProjectByIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());

        if (project == null) {
            throw new InvalidProjectIdentifierException(MessageFormat.format("Project Identifier {0} does not exists", projectIdentifier.toUpperCase()));
        }
        return project;
    }
}
