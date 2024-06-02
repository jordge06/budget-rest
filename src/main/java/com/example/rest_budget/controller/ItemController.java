package com.example.rest_budget.controller;

import com.example.rest_budget.entity.Item;
import com.example.rest_budget.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/budget")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAllSampleEntities() {
        return itemRepository.findAll();
    }

    // GET endpoint to retrieve a SampleEntity by id
    @GetMapping("/{id}")
    public ResponseEntity<Item> getSampleEntityById(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST endpoint to create a new SampleEntity
    @PostMapping
    public Item createSampleEntity(@RequestBody Item sampleEntity) {
        return itemRepository.save(sampleEntity);
    }
}
