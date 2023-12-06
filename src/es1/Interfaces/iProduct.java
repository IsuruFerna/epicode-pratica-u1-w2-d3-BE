package es1.Interfaces;

import java.util.Random;

public interface iProduct {
    default long generateid() {
        Random rnd = new Random();
        return rnd.nextInt(1, 100000);
    }
}
