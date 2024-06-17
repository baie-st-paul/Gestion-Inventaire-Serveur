package com.example.gestioninventaireserveur.controllers.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.InventoryGetDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.InventoryPostDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.InventoryPutDTO;
import com.example.gestioninventaireserveur.services.inventory.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/create")
    public ResponseEntity<InventoryGetDTO> createInventory(@Valid @RequestBody InventoryPostDTO inventoryPostDTO) {
        try {
            return ResponseEntity.ok(inventoryService.createInventory(inventoryPostDTO));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<InventoryGetDTO> getInventory(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inventoryService.getInventory(id));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<InventoryGetDTO>> getAllInventoryItems() {
        try {
            return ResponseEntity.ok(inventoryService.getAllInventoryItems());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id) {
        try {
            inventoryService.deleteInventory(id);
            return ResponseEntity.ok("Inventory deleted successfully");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InventoryGetDTO> updateInventory(@PathVariable Long id, @Valid @RequestBody InventoryPutDTO inventoryPutDTO) {
        try {
            return ResponseEntity.ok(inventoryService.updateInventory(id, inventoryPutDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
