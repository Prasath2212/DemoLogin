package com.assettracking.demo.service;

import com.assettracking.demo.dto.AssetRequest;
import com.assettracking.demo.entity.AssetEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class AssetService {

    private static final List<AssetEntity> assets = new ArrayList<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    // Static sample data
    static {
        assets.add(new AssetEntity(1L, "Dell Laptop", "Electronics", "DL-1001"));
        assets.add(new AssetEntity(2L, "HP Printer", "Electronics", "HP-2002"));
        assets.add(new AssetEntity(3L, "Office Chair", "Furniture", "CH-3003"));
        ID_GENERATOR.set(4);
    }

    public AssetEntity create(AssetRequest request) {
        AssetEntity asset = new AssetEntity(
                ID_GENERATOR.getAndIncrement(),
                request.getAssetName(),
                request.getAssetType(),
                request.getSerialNumber()
        );
        assets.add(asset);
        return asset;
    }

    public List<AssetEntity> getAll() {
        return assets.stream()
                .filter(asset -> !asset.isDeleted())
                .collect(Collectors.toList());
    }

    public AssetEntity getById(Long id) {
        return assets.stream()
                .filter(asset -> asset.getId().equals(id) && !asset.isDeleted())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

    public AssetEntity update(Long id, AssetRequest request) {
        AssetEntity asset = getById(id);
        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setSerialNumber(request.getSerialNumber());
        return asset;
    }

    public void softDelete(Long id) {
        AssetEntity asset = getById(id);
        asset.setDeleted(true);
    }
}
