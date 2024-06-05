package com.example.gestioninventaireserveur.models.inventory;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalQuantity;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Item item;
    private String location;
    private int currentQuantity;
}
