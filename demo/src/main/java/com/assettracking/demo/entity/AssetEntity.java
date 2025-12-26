package com.assettracking.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "assets")
public class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetName;
    private String assetType;
    private String serialNumber;

    @Column(nullable = false)
    private boolean deleted = false;

    public AssetEntity() {}

    public AssetEntity(String assetName, String assetType, String serialNumber) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.serialNumber = serialNumber;
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
