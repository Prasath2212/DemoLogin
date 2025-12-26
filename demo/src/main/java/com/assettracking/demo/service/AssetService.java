package com.assettracking.demo.service;

import com.assettracking.demo.dto.AssetRequest;
import com.assettracking.demo.entity.AssetEntity;
import com.assettracking.demo.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public AssetEntity create(AssetRequest request) {
        AssetEntity asset = new AssetEntity(
                request.getAssetName(),
                request.getAssetType(),
                request.getSerialNumber()
        );
        return assetRepository.save(asset);
    }

    public List<AssetEntity> getAll() {
        return assetRepository.findByDeletedFalse();
    }

    public AssetEntity getById(Long id) {
        return assetRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

    public AssetEntity update(Long id, AssetRequest request) {
        AssetEntity asset = getById(id);
        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setSerialNumber(request.getSerialNumber());
        return assetRepository.save(asset);
    }

    public void softDelete(Long id) {
        AssetEntity asset = getById(id);
        asset.setDeleted(true);
        assetRepository.save(asset);
    }
}
