package com.example.gestioninventaireserveur.repositories.inventory;

import com.example.gestioninventaireserveur.models.inventory.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
    Local findByName(String name);
}
