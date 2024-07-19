package za.co.androman.dynamoprofile.utilities;

import java.time.*;
import java.util.Date;
import java.util.Objects;

public class DateUtility {

    public static Date getDate(int year, int month, int day, int hour, int min, int sec, ZoneId zoneId) {
        LocalDateTime date = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, min, sec));
        if (Objects.nonNull(zoneId)) {
            ;
            return Date.from(date.toInstant(zoneId.getRules().getOffset(date)));
        }
        return Date.from(date.toInstant(ZoneId.systemDefault().getRules().getOffset(date)));
    }

    public static Date getDate(int year, int month, int day, int hour, int min, int sec, ZoneOffset zoneOffset) {
        LocalDateTime date = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, min, sec));
        if (Objects.nonNull(zoneOffset)) {
            ;
            return Date.from(date.toInstant(zoneOffset));
        }
        return Date.from(date.toInstant(ZoneId.systemDefault().getRules().getOffset(date)));
    }

    public static LocalDateTime toLocalDate(Date date, ZoneId zoneId) {
        if (Objects.isNull(zoneId)) {
            zoneId = ZoneId.systemDefault();
        }
        Instant instant = date.toInstant();
        return LocalDateTime.of(LocalDate.ofInstant(instant, zoneId), LocalTime.ofInstant(instant, zoneId));
    }


    public static Date toDate(LocalDateTime date, ZoneId zoneId) {
        if (Objects.isNull(zoneId)) {
            zoneId = ZoneId.systemDefault();
        }
        return Date.from(date.toInstant(zoneId.getRules().getOffset(date)));
    }
}
