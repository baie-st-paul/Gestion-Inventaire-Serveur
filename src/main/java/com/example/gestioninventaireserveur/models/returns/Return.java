package com.example.gestioninventaireserveur.models.returns;

import com.example.gestioninventaireserveur.models.borrows.Borrowing;
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
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "borrowing_id")
    private Borrowing borrowing;
    private LocalDateTime returnDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "returned_items_list",
            joinColumns = @JoinColumn(name = "return_id"),
            inverseJoinColumns = @JoinColumn(name = "returned_item_id")
    )
    private List<ReturnedItems> returnedItems;

}
