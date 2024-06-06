package com.example.gestioninventaireserveur.controllers.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.InventoryGetDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.InventoryPostDTO;
import com.example.gestioninventaireserveur.services.inventory.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @RequestMapping("/create")
    public ResponseEntity<InventoryGetDTO> createInventory(@Valid @RequestBody InventoryPostDTO inventoryPostDTO) {
        try {
            return ResponseEntity.ok(inventoryService.createInventory(inventoryPostDTO));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<InventoryGetDTO> getInventory(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inventoryService.getInventory(id));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
