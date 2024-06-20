package com.example.gestioninventaireserveur.controllers.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ItemGetDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ItemPostDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ItemPutDTO;
import com.example.gestioninventaireserveur.services.inventory.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<ItemGetDTO> createInventory(@Valid @RequestBody ItemPostDTO itemPostDTO) {
        try {
            return ResponseEntity.ok(itemService.createInventory(itemPostDTO));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ItemGetDTO> getInventory(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(itemService.getInventory(id));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ItemGetDTO>> getAllInventoryItems() {
        try {
            return ResponseEntity.ok(itemService.getAllInventoryItems());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id) {
        try {
            itemService.deleteInventory(id);
            return ResponseEntity.ok("Inventory deleted successfully");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ItemGetDTO> updateInventory(@PathVariable Long id, @Valid @RequestBody ItemPutDTO itemPutDTO) {
        try {
            return ResponseEntity.ok(itemService.updateInventory(id, itemPutDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
