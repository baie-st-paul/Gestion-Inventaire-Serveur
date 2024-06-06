package com.example.gestioninventaireserveur.DTOs.inventoryDTOs;

import com.example.gestioninventaireserveur.models.inventory.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryGetDTO {
        private Long id;
        private String name;
        private String description;
        private String category;
        private ImageDataDTO image;
        private int totalQuantity;
        private int currentQuantity;
        private String location;

        public static InventoryGetDTO fromInventory(Inventory inventory){
                return new InventoryGetDTO(
                        inventory.getId(),
                        inventory.getItem().getName(),
                        inventory.getItem().getDescription(),
                        inventory.getItem().getCategory(),
                        new ImageDataDTO(inventory.getItem().getImage().getData()),
                        inventory.getTotalQuantity(),
                        inventory.getCurrentQuantity(),
                        inventory.getLocation()
                );
        }
}
