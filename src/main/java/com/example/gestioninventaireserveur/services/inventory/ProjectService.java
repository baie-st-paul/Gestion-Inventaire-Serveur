package com.example.gestioninventaireserveur.services.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ListStringPost;
import com.example.gestioninventaireserveur.models.inventory.Project;
import com.example.gestioninventaireserveur.repositories.inventory.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project findByName(String name) {
        return projectRepository.findByName(name);
    }

    public Project save(ListStringPost listStringPost) {
        return projectRepository.save(Project.builder().name(listStringPost.getName()).build());
    }

    public List<String> findAll() {
        return projectRepository.findAll().stream().map(Project::getName).collect(Collectors.toList());
    }
}
