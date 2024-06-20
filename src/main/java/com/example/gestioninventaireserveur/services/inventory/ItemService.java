package com.example.gestioninventaireserveur.services.inventory;

import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ItemGetDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ItemPostDTO;
import com.example.gestioninventaireserveur.DTOs.inventoryDTOs.ItemPutDTO;
import com.example.gestioninventaireserveur.models.inventory.*;
import com.example.gestioninventaireserveur.repositories.inventory.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final RessourceTypeService ressourceTypeService;
    private final LocalService localService;
    private final ProjectService projectService;

    public ItemService(ItemRepository itemRepository, RessourceTypeService ressourceTypeService, LocalService localService, ProjectService projectService) {
        this.itemRepository = itemRepository;
        this.ressourceTypeService = ressourceTypeService;
        this.localService = localService;
        this.projectService = projectService;
    }

    public ItemGetDTO createInventory(ItemPostDTO itemPostDTO) {
        System.out.println(itemPostDTO);
        return ItemGetDTO.fromInventory(itemRepository.save(Item.builder()
                .name(itemPostDTO.getName())
                .description(itemPostDTO.getDescription())
                .category(itemPostDTO.getCategory())
                .image(Image.builder()
                        .data(itemPostDTO.getImage().getData())
                        .build())
                .currentQuantity(itemPostDTO.getQuantity())
                .location(itemPostDTO.getLocation())
                .totalQuantity(itemPostDTO.getQuantity())
                .ressourceType(ressourceTypeService.findByName(itemPostDTO.getRessourceType()))
                .local(localService.findByName(itemPostDTO.getLocal()))
                .state(State.valueOf(itemPostDTO.getState()))
                .consumable(itemPostDTO.isConsumable())
                .status(Status.valueOf(itemPostDTO.getStatus()))
                .project(projectService.findByName(itemPostDTO.getProject()))
                .build()));
    }

    public ItemGetDTO getInventory(Long id) {
        return ItemGetDTO.fromInventory(itemRepository.findById(id).orElseThrow());
    }

    public List<ItemGetDTO> getAllInventoryItems() {
        return itemRepository.findAll().stream().map(ItemGetDTO::fromInventory).collect(Collectors.toList());
    }

    public void deleteInventory(Long id) {
        itemRepository.deleteById(id);
    }

    public ItemGetDTO updateInventory(Long id, ItemPutDTO itemPutDTO) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setName(itemPutDTO.getName());
        item.setDescription(itemPutDTO.getDescription());
        item.setCategory(itemPutDTO.getCategory());
        item.setCurrentQuantity(itemPutDTO.getCurrentQuantity());
        item.setTotalQuantity(itemPutDTO.getTotalQuantity());
        item.setLocation(itemPutDTO.getLocation());
        item.setRessourceType(ressourceTypeService.findByName(itemPutDTO.getRessourceType()));
        item.setLocal(localService.findByName(itemPutDTO.getLocal()));
        item.setState(State.valueOf(itemPutDTO.getState()));
        item.setConsumable(itemPutDTO.isConsumable());
        item.setStatus(Status.valueOf(itemPutDTO.getStatus()));
        item.setProject(projectService.findByName(itemPutDTO.getProject()));
        return ItemGetDTO.fromInventory(itemRepository.save(item));
    }
}
