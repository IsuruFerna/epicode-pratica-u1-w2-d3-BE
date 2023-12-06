package es1;

import es1.Interfaces.iProduct;

import java.util.StringJoiner;

public class Customer implements iProduct {
    private long id;
    private String name;
    private int tier;

    public Customer() {
        long id = generateid();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("tier=" + tier)
                .toString();
    }
}
