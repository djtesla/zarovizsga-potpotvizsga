package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aquarium {

    List<Fish> fishes = new ArrayList<>();


    public void addFish(Fish fish) {
        fishes.add(fish);
    }


    public void feed() {
        for (Fish fish : fishes) {
            fish.feed();
        }
    }


    public void removeFish() {
        Iterator<Fish> fishIterator = fishes.iterator();
        while (fishIterator.hasNext()) {
            if (fishIterator.next().getWeight() >= 11) {
                fishIterator.remove();
            }
        }
    }


    public List<String> getStatus() {
        List<String> statuses = new ArrayList<>();
        for (Fish fish : fishes) {
            statuses.add(fish.status());
        }
        return statuses;
    }


}
