package com.example.gestioninventaireserveur.DTOs.inventoryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPutDTO {
    private String name;
    private String description;
    private String category;
    private int currentQuantity;
    private int totalQuantity;
    private String location;
    private String ressourceType;
    private String local;
    private String status;
    private boolean consumable;
    private String state;
    private String project;

}
