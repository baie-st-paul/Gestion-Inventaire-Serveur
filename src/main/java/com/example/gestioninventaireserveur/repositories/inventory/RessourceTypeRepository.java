package com.example.gestioninventaireserveur.repositories.inventory;

import com.example.gestioninventaireserveur.models.inventory.RessourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceTypeRepository extends JpaRepository<RessourceType, Long> {
    RessourceType findByName(String name);
}
