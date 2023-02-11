package util;

import java.util.Random;

public class GenerateData {
    public static String generateId() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char letter = (char) (random.nextInt(26) + 'a');
            sb.append(letter);
        }
        return sb.toString();
    }

    public static String generateCompany() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            char letter = (char) (random.nextInt(26) + 'a');
            sb.append(letter);
        }
        return sb.toString();
    }
}
