package dsr.example.ivan.data;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {

    public static String generateFirstNameLat() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateLastNameLat() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static Long generateValidPhoneNumber() {
        // valid ph num length: min = 7, max = 13
        return (long) ThreadLocalRandom.current().nextDouble(1_000_000, 999_999_999_999L);
    }
}
