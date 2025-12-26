
package com.assettracking.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assettracking.demo.entity.AssetEntity;

public interface AssetRepository extends JpaRepository<AssetEntity, Long> {

    List<AssetEntity> findByDeletedFalse();

    Optional<AssetEntity> findByIdAndDeletedFalse(Long id);
}
