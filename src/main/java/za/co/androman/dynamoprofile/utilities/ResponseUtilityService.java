package za.co.androman.dynamoprofile.utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.stereotype.Service;
import za.co.androman.dynamoprofile.services.controller.integration.User;

import java.util.Locale;


@Service
public class ResponseUtilityService {
    private static
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    private static Faker faker = new Faker();

}
