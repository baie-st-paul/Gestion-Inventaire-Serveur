package com.example.gestioninventaireserveur.repositories.inventory;

import com.example.gestioninventaireserveur.models.inventory.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
