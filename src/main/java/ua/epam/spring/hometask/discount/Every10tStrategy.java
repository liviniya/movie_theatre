package ua.epam.spring.hometask.discount;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
public class Every10tStrategy extends DiscountStrategy {

    public static final Integer DISCOUNT_TICKET_NUMBER = 10;

    public static final Integer PERCENT_DISCOUNT = 50;

    @Override
    public double calculateDiscount(@Nullable User user, @Nonnull Event event,
                                    @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        int userTickets = user != null ? user.getTicketsSize() : 0;

        double discount = 0;
        for (long i = userTickets + 1; i <= userTickets + numberOfTickets; i++) {
            if (i % DISCOUNT_TICKET_NUMBER == 0) {
                discount += calculateDiscountForEvent(PERCENT_DISCOUNT, event);
            }
        }

        return discount;
    }
}
