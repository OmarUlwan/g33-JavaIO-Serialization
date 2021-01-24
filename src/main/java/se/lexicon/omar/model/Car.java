package se.lexicon.omar.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/* create a class called Car with properties like reg number, brand and model etc...
The Car class must implement Serializable. To also fulfil the contract make a default constructor.*/

public class Car implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private UUID carID;
    @JsonFormat (shape = JsonFormat.Shape.STRING)
    private String regNumber;
    @JsonFormat (shape = JsonFormat.Shape.STRING)
    private String brand;
    @JsonFormat (shape = JsonFormat.Shape.STRING)
    private String model;
    @JsonFormat (shape = JsonFormat.Shape.STRING)
    private LocalDate regDate;
    @JsonFormat (shape = JsonFormat.Shape.STRING)
    private String owner;

    public Car(String regNumber, String brand, String model, LocalDate regDate, String owner) {
        this.carID = UUID.randomUUID();
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.regDate = regDate;
        this.owner = owner;
    }

    public Car(){

    }

    public UUID getCarID() {
        return carID;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
