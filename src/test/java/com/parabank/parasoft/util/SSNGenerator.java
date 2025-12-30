package com.parabank.parasoft.util;

import java.util.Random;

public class SSNGenerator {
    public static String generateRandomSSN() {
        Random rand = new Random();

        // Generate the area number (AAA)
        int area = rand.nextInt(899) + 1; // Generates a number between 1 and 899
        while (area == 666 || area >= 900) {
            area = rand.nextInt(899) + 1; // Re-generate if the area number is 666 or >= 900
        }

        // Generate the group number (GG)
        int group = rand.nextInt(99) + 1; // Generates a number between 1 and 99

        // Generate the serial number (SSSS)
        int serial = rand.nextInt(9999) + 1; // Generates a number between 1 and 9999

        // Format the SSN as AAA-GG-SSSS
        return String.format("%03d-%02d-%04d", area, group, serial);
    }
}
