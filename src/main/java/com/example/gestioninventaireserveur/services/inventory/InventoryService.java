package com.example.gestioninventaireserveur.services.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.InventoryGetDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.InventoryPostDTO;
import com.example.gestioninventaireserveur.models.inventory.Image;
import com.example.gestioninventaireserveur.models.inventory.Inventory;
import com.example.gestioninventaireserveur.models.inventory.Item;
import com.example.gestioninventaireserveur.repositories.inventory.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryGetDTO createInventory(InventoryPostDTO inventoryPostDTO) {
        return InventoryGetDTO.fromInventory(inventoryRepository.save(Inventory.builder()
                .item(Item.builder()
                        .name(inventoryPostDTO.getName())
                        .description(inventoryPostDTO.getDescription())
                        .category(inventoryPostDTO.getCategory())
                        .image(Image.builder()
                                .data(inventoryPostDTO.getImage().getData())
                                .build())
                        .build())
                .currentQuantity(inventoryPostDTO.getQuantity())
                .location(inventoryPostDTO.getLocation())
                .totalQuantity(inventoryPostDTO.getQuantity())
                .build()));
    }

}