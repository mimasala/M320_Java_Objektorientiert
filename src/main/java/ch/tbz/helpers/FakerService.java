package ch.tbz.helpers;

import ch.tbz.entities.user.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FakerService {
    public static ArrayList<User> createUserDataBase(int amount) {
        Faker faker = new Faker(new Locale("en-US"));
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            users.add(new User(
                    (int) faker.number().randomNumber(),
                    faker.name().username(),
                    faker.internet().password(),
                    faker.internet().emailAddress(),
                    faker.country().name(),
                    faker.number().digits(2),
                    faker.date().birthday().toString(),
                    faker.number().digits(4),
                    faker.number().digits(8)
            ));
        }
        return users;
    }
}
