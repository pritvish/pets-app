package com.app.PetStoreApplication.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PetEntity {

    @Id
    private Integer petId;
    private String type;
    @NotNull
    private String name;
    private String status;
    @Min(2000)
    @Max(20000)
    private int price;

    public PetEntity(Integer petId, String type, @NotNull String name, String status, @Min(2000) @Max(20000) int price) {
        this.petId = petId;
        this.type = type;
        this.name = name;
        this.status = status;
        this.price = price;
    }

    public PetEntity() {

    }


    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "petId=" + petId +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
