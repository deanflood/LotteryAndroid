package com.example.adminibm.lottonumbers.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by ADMINIBM on 01/04/2017.
 */

public class QuickPickService {

    public static String quickPick(int number, int maximum) {
        Random random = new Random();
        Set<Integer> numberSet = new HashSet<>();
        String returnValue = "";

        if (maximum < number) {
            returnValue = "Number too small!";
        } else {
            while (numberSet.size() < number) {
                numberSet.add(random.nextInt(maximum) + 1);
            }

            List<Integer> sortedList = new ArrayList(numberSet);
            Collections.sort(sortedList);

            for (int i : sortedList) {
                returnValue += " " + i;
            }
        }
        return returnValue;
    }
}
