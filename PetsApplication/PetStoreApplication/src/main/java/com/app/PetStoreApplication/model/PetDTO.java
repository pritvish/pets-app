package com.app.PetStoreApplication.model;

public class PetDTO {

    private Integer petId;
    private String type;
    private String name;
    private String status;
    private int price;

    public PetDTO(Integer petId, String type, String name, String status, int price) {
        this.petId = petId;
        this.type = type;
        this.name = name;
        this.status = status;
        this.price = price;
    }

    public PetDTO() {

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
        return "PetDTO{" +
                "petId=" + petId +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
