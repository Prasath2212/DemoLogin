package com.assettracking.demo.controller;

import com.assettracking.demo.dto.AssetRequest;
import com.assettracking.demo.entity.AssetEntity;
import com.assettracking.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // (A) Create Asset
    @PostMapping
    public AssetEntity create(@RequestBody AssetRequest request) {
        return assetService.create(request);
    }

    // (B) Get All Assets (excluding deleted)
    @GetMapping
    public List<AssetEntity> getAll() {
        return assetService.getAll();
    }

    // (C) Get Asset By ID
    @GetMapping("/{id}")
    public AssetEntity getById(@PathVariable Long id) {
        return assetService.getById(id);
    }

    // (D) Update Asset
    @PatchMapping("/{id}")
    public AssetEntity update(
            @PathVariable Long id,
            @RequestBody AssetRequest request) {
        return assetService.update(id, request);
    }

    // (E) Soft Delete Asset
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        assetService.softDelete(id);
        return "Asset soft deleted successfully";
    }
}
