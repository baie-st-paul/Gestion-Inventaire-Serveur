package com.example.gestioninventaireserveur.repositories.inventory;

import com.example.gestioninventaireserveur.models.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
