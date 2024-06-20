package com.example.gestioninventaireserveur.controllers.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ListStringPost;
import com.example.gestioninventaireserveur.services.inventory.LocalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/local")
@RequiredArgsConstructor
public class LocalController {
    private final LocalService localService;

    @GetMapping("/getAll")
    public ResponseEntity<List<String>> getAllLocals() {
        try {
            return ResponseEntity.ok(localService.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLocal(@Valid @RequestBody ListStringPost listStringPost) {
        try {
            localService.save(listStringPost);
            return ResponseEntity.ok("Local created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
