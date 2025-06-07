package helpers;

import models.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class UserGenerator {

    private static final Random random = new Random();

    public static User generateValidUserFullData(){
        String gender = random.nextBoolean() ? "Male" : "Female";
        String firstName = RandomStringUtils.randomAlphabetic(10);
        String lastName = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "testDom.com";
        String password = RandomStringUtils.randomAlphabetic(6);
        String confirmPassword = password;
        return new User(gender, firstName, lastName, email, password, confirmPassword);
    }
    public static User generateValidUserOnlyRequiredData(){
        String firstName = RandomStringUtils.randomAlphabetic(10);
        String lastName = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "testDom.com";
        String password = RandomStringUtils.randomAlphabetic(6);
        String confirmPassword = password;
        return new User(firstName, lastName, email, password, confirmPassword);
    }
}
