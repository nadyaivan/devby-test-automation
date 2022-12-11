package by.bsu.test.devby;

import java.util.Random;

/**
 * утилитарные методы для генерации тестовых данных: имен пользователей, паролей
 */
public class Util {

    private static Random r = new Random();

    public static void wait(final int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("The thread was interrupted");
        }
    }

    public static String generatePassword() {
        final StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            password.append((char) (r.nextInt(26) + 'a'));
        }
        return password.toString();
    }

    public static String generateEmail() {
        final StringBuilder email = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            email.append((char) (r.nextInt(26) + 'a'));
        }
        return email.append("@email.com")
                .toString();
    }
}
