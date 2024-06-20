package com.example.gestioninventaireserveur.services.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ListStringPost;
import com.example.gestioninventaireserveur.models.inventory.Local;
import com.example.gestioninventaireserveur.repositories.inventory.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalService {
    private final LocalRepository localRepository;

    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public Local findByName(String name) {
        return localRepository.findByName(name);
    }

    public void save(ListStringPost listStringPost) {
        localRepository.save(Local.builder().name(listStringPost.getName()).build());
    }

    public List<String> findAll() {
        return localRepository.findAll().stream().map(Local::getName).collect(Collectors.toList());
    }
}
