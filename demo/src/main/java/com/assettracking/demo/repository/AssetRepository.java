package com.assettracking.demo.repository;

import com.assettracking.demo.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssetRepository extends JpaRepository<AssetEntity, Long> {

    List<AssetEntity> findByDeletedFalse();

    Optional<AssetEntity> findByIdAndDeletedFalse(Long id);
}
