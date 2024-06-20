package com.example.gestioninventaireserveur.controllers.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ListStringPost;
import com.example.gestioninventaireserveur.services.inventory.RessourceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/ressourcetype")
@RequiredArgsConstructor
public class RessourceTypeController {
    private final RessourceTypeService ressourceTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<String>> getAllRessourceTypes() {
        try {
            return ResponseEntity.ok(ressourceTypeService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRessourceType(@RequestBody ListStringPost listStringPost) {
        try {
            ressourceTypeService.save(listStringPost);
            return ResponseEntity.ok("Ressource type created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
