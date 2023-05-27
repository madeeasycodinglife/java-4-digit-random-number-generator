package com.madeeasy;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        String verificationCode = generateCode();
        System.out.println("verificationCode = " + verificationCode);
        Scanner scanner = new Scanner(System.in);
        int inputFromConsole = scanner.nextInt();
        if (inputFromConsole == Integer.valueOf(verificationCode)) {
            System.out.println("correct!");
        } else {
            System.out.println("incorrect!");
        }
        scanner.close();
    }

    public static String generateCode() {
        String code;
        try {
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            int number = secureRandom.nextInt(9000) + 1000;
            code = String.valueOf(number);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return code;
    }
}