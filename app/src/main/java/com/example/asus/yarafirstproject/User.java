package com.example.asus.yarafirstproject;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class User {

    String name;
    String family;
    String email;

    @ParcelConstructor
    User(String name, String family, String email) {
        this.name = name;
        this.family = family;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getEmail() {
        return email;
    }
}