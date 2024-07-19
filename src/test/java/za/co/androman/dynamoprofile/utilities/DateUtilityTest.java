package za.co.androman.dynamoprofile.utilities;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateUtilityTest {
    @Test
    public void testGetDate(){
        Date date = DateUtility.getDate(2024, 30, 14, 10, 0, 0, null);

    }
}
