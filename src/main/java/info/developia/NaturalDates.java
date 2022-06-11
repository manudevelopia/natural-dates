package info.developia;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NaturalDates {
    private final LocalDateTime naturalDateTime;

    public NaturalDates(String dateTimeDescription) {
        this.naturalDateTime = parse(dateTimeDescription);
    }

    public LocalDateTime parse(String dateDescription) {
        String[] naturalDateTimeParts = getParts(dateDescription);
        String howOfter = naturalDateTimeParts[0].strip();
        String[] time = naturalDateTimeParts[1].strip().split(":");

        return (switch (howOfter) {
            case "daily" -> LocalDateTime.now().withHour(Integer.parseInt(time[0])).withMinute(Integer.parseInt(time[1]));
            default -> throw new NaturalDatesException("Date description '%s' cannot be parsed".formatted(dateDescription));
        }).truncatedTo(ChronoUnit.MINUTES);
    }

    private String[] getParts(String dateDescription) {
        String[] parts = dateDescription.toLowerCase().split("at");
        if (parts.length < 2) {
            throw new NaturalDatesException("Date description '%s' cannot be parsed".formatted(dateDescription));
        }
        return parts;
    }

    public boolean isNow() {
        return is(LocalDateTime.now());
    }

    public boolean isNot(LocalDateTime dateTime) {
        return !isSameTime(dateTime.truncatedTo(ChronoUnit.MINUTES));
    }

    public boolean is(LocalDateTime dateTime) {
        return isSameTime(dateTime.truncatedTo(ChronoUnit.MINUTES));
    }

    private boolean isSameTime(LocalDateTime dateTime) {
        return naturalDateTime.toLocalTime().equals(dateTime.toLocalTime());
    }
}
