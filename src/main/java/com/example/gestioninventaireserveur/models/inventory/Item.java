package com.example.gestioninventaireserveur.models.inventory;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Image image;
}
