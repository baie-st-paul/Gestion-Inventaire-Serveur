package com.example.gestioninventaireserveur.controllers.inventory;

import com.example.gestioninventaireserveur.models.inventory.State;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("/api/v1/state")
@RequiredArgsConstructor
public class StateController {

    @GetMapping("/getAll")
    public ResponseEntity<List<String>> getAllStates() {
        try {
            return ResponseEntity.ok(Stream.of(State.values()).map(State::name).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
