package com.example.gestioninventaireserveur.DTOs.inventoryDTOs;

import com.example.gestioninventaireserveur.models.inventory.Image;
import com.example.gestioninventaireserveur.models.inventory.Inventory;
import com.example.gestioninventaireserveur.models.inventory.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryPostDTO {

    private String name;
    private String description;
    private String category;
    private ImageDataDTO image;
    private int quantity;
    private String location;

}
