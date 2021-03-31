package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class DaVinciCode {


    public int encode(String file, char searchedChar) {
        if (!chekSearchedCharIfValid(searchedChar)) {
            throw new IllegalArgumentException("Invalid char");
        }
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            int counter = 0;
            String line;
            while ((line =reader.readLine()) != null) {
                counter += processLineAndGetHits(line, searchedChar);
            }
            return counter;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }



    private int processLineAndGetHits(String line, char searchedChar) {
        int counter = 0;
        for (char c: line.toCharArray()) {
            if (c == searchedChar) {
                counter++;
            }
        }
        return  counter;
    }


    private boolean chekSearchedCharIfValid(char searchedChar) {
        List<Character> charsAccepted = Arrays.asList('0', '1', 'x');
        return charsAccepted.contains(searchedChar);
    }


}
