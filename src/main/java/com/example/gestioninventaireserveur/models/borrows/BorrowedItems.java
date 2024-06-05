package com.example.gestioninventaireserveur.models.borrows;

import com.example.gestioninventaireserveur.models.inventory.Inventory;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowedItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Inventory inventory;
    private int quantity;
}
