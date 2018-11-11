package com.dlocal.merchant.datastore.models;

import org.springframework.data.annotation.Id;

public class Merchant {

    @Id
    public String id;

    public String name;

    public Merchant() {}

    public Merchant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Merchant[id=%s, name='%s']", id, name);
    }
}
