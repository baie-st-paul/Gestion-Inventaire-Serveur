package com.example.gestioninventaireserveur.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    private Long id;
}
