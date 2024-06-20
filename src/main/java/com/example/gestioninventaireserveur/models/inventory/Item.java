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
    private String location;
    private int currentQuantity;
    private int totalQuantity;
    @OneToOne
    @JoinColumn(name = "ressource_type_id")
    private RessourceType ressourceType;
    @OneToOne
    @JoinColumn(name = "local_id")
    private Local local;
    @Enumerated(EnumType.STRING)
    private State state;
    private boolean consumable;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

}

