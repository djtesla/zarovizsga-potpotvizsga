package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.*;

public class UniqueFinder {

    public List<Character> uniqueChars(String text) {
        if (text == null) {
            throw new IllegalArgumentException(" Text parameter is null");
        }
        Set<Character> uniqueChars = new LinkedHashSet<>();
        for (char c : text.toCharArray()) {
            uniqueChars.add(c);
        }
        return new ArrayList<>(uniqueChars);
    }


}


/*
    Hozd létre a UniqueFinder osztályt, és abban a uniqueChars metódust, ami paraméternek kap egy String-et,
        és térjen vissza az abban levő karakterek listájával. Minden karakter csak egyszer szerepeljen a listában,
        az inputban nézett első előfordulásának megfelelő helyen.

        Ha a metódus null-t kap paraméterben, akkor dobj IllegalArgumentException-t!*/
