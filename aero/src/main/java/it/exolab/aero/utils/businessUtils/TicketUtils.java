package it.exolab.aero.utils.businessUtils;

import java.util.Random;

public class TicketUtils {
    private final static int CODE_LENGTH = 10;
    private final static char[] caratteriPossibili = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private static Random random = new Random();

    public static String generateCode() {
        StringBuilder sb = new StringBuilder();
        for (int counter = 0; counter < CODE_LENGTH; counter++) {
            int estratto = random.nextInt(caratteriPossibili.length - 1);
            sb.append(estratto);
        }
        return sb.toString();
    }
}
