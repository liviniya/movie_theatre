package ua.epam.spring.hometask.discount;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.Year;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
public class BirthdayStrategy extends DiscountStrategy {

    public static final Integer PERCENT_DISCOUNT = 5;
    public static final Integer DAYS_SHIFT = 5;

    @Override
    public double calculateDiscount(@Nullable User user, @Nonnull Event event,
                                    @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        int birthDay = user.getBirthday().getDayOfYear();
        int eventDay = airDateTime.getDayOfYear();

        int daysInYear = Year.of(airDateTime.getYear()).length();

        int daysDifference = Math.abs(eventDay - birthDay);
        if ((daysDifference <= DAYS_SHIFT) || (daysInYear - daysDifference <= DAYS_SHIFT)) {
            return calculateDiscountForEvent(PERCENT_DISCOUNT, event, numberOfTickets);
        }

        return 0;
    }
}
