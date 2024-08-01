package org.example.UserService;

public class InputService {

    public boolean onlyDigits(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean onlyAlphabets(String str, int n) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                System.out.println("ONLY ALPHABETS! NO WHITESPACES!");
                return false;
            }
        }
        return true;
    }


}
