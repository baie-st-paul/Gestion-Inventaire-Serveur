package com.example.gestioninventaireserveur.DTOs.inventoryDTOs;

import com.example.gestioninventaireserveur.models.inventory.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetDTO {
        private Long id;
        private String name;
        private String description;
        private String category;
        private ImageDataDTO image;
        private int totalQuantity;
        private int currentQuantity;
        private String location;
        private String ressourceType;
        private String local;
        private String status;
        private boolean consumable;
        private String state;
        private String project;

        public static ItemGetDTO fromInventory(Item item){
                return new ItemGetDTO(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getCategory(),
                        new ImageDataDTO(item.getImage().getData()),
                        item.getTotalQuantity(),
                        item.getCurrentQuantity(),
                        item.getLocation(),
                        item.getRessourceType().getName(),
                        item.getLocal().getName(),
                        item.getStatus().name(),
                        item.isConsumable(),
                        item.getState().name(),
                        item.getProject().getName()
                );
        }
}
