package es1;

import es1.Interfaces.iProduct;

import java.util.StringJoiner;

public class Customer implements iProduct {
    private long id;
    private String name;
    private int tier;

    public Customer(String name, int tier) {
        this.id = generateid();
        this.name = name;
        this.tier = tier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getTier() {
        return tier;
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
