package ua.epam.spring.hometask.discounts;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.Year;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
public class BirthdayStrategy implements DiscountStrategy {

    public final byte PERCENT_DISCOUNT = 5;
    public final int DAYS_SHIFT = 5;

    public BirthdayStrategy() {}

    @Override
    public double calculateDiscount(@Nullable User user, @Nonnull Event event,
                                    @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        int birthDay = user.getBirthday().getDayOfYear();
        int eventDay = airDateTime.getDayOfYear();

        int daysInYear = Year.of(airDateTime.getYear()).length();

        int daysDifference = Math.abs(eventDay - birthDay);
        if ((daysDifference <= DAYS_SHIFT) || (daysInYear - daysDifference <= DAYS_SHIFT)) {
            return PERCENT_DISCOUNT;
        }

        return 0;
    }
}
