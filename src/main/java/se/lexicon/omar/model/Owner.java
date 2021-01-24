package se.lexicon.omar.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Owner implements Serializable {
    @JsonFormat
    private int ownerID;
    @JsonFormat
    private String name;
    @JsonFormat
    private LocalDate birthdate;

    private static int counter;

    public Owner(int ownerID, String name, LocalDate birthdate) {
        this.ownerID = ++counter;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Owner() {

    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
