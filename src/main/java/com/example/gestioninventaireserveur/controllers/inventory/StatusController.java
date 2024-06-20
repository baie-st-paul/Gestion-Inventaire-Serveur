package com.example.gestioninventaireserveur.controllers.inventory;

import com.example.gestioninventaireserveur.models.inventory.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("/api/v1/status")
@RequiredArgsConstructor
public class StatusController {

    @GetMapping("/getAll")
    public ResponseEntity<List<String>> getAllStatus() {
        try {
            return ResponseEntity.ok(Stream.of(Status.values()).map(Status::name).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
