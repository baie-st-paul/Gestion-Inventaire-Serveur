package com.example.gestioninventaireserveur.services.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ListStringPost;
import com.example.gestioninventaireserveur.models.inventory.RessourceType;
import com.example.gestioninventaireserveur.repositories.inventory.RessourceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RessourceTypeService {
    private final RessourceTypeRepository ressourceTypeRepository;

    public RessourceTypeService(RessourceTypeRepository ressourceTypeRepository) {
        this.ressourceTypeRepository = ressourceTypeRepository;
    }

    public RessourceType findByName(String name) {
        return ressourceTypeRepository.findByName(name);
    }

    public RessourceType save(ListStringPost listStringPost) {
        return ressourceTypeRepository.save(RessourceType.builder().name(listStringPost.getName()).build());
    }

    public List<String> findAll() {
        return ressourceTypeRepository.findAll().stream().map(RessourceType::getName).collect(Collectors.toList());
    }
}
