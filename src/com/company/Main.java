package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanText = new Scanner(System.in);
        String text = scanText.nextLine();
        ArrayList<String> textArrayList = new ArrayList<>(Arrays.asList(text.split("\\s*(\\s|,|!|\\.)\\s*")));
        Map<String, Long> wordsQuantity = new HashMap<>();
        textArrayList.forEach(word -> wordsQuantity.put(word.toLowerCase(), textArrayList.stream().filter(word::equalsIgnoreCase).count()));
        Set<Long> mapValues = new HashSet<>();
        wordsQuantity.forEach((key, value) -> mapValues.add(value));
        Set<Long> sortMapValues = new TreeSet<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return -o1.compareTo(o2);
            }
        });
        mapValues.forEach(value -> {sortMapValues.add(value);});
        sortMapValues.forEach(value -> {
            System.out.println(value + " раз(а) встречаются слова:");
            wordsQuantity.forEach((key, valueWord) -> {
                if(value.equals(valueWord)){
                    System.out.println(key);
                }
            });});
    }
}
