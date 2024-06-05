package com.example.gestioninventaireserveur.models.borrows;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "borrowed_items_list",
            joinColumns = @JoinColumn(name = "borrowing_id"),
            inverseJoinColumns = @JoinColumn(name = "borrowed_item_id")
    )
    private List<BorrowedItems> borrowedItems;

    private LocalDateTime borrowingDate;
    private boolean toBeReturned;

}
