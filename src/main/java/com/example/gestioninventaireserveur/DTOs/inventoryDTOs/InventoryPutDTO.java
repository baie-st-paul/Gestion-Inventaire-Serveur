package com.example.gestioninventaireserveur.DTOs.inventoryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryPutDTO {
    private String name;
    private String description;
    private String category;
    private int currentQuantity;
    private int totalQuantity;
    private String location;
}
