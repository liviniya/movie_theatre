package ua.epam.spring.hometask.discounts;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
public class Every10tStrategy implements DiscountStrategy {

    public final int DISCOUNT_TICKET_NUMBER = 10;
    public final byte PERCENT_DISCOUNT = 50;

    public Every10tStrategy() {}

    @Override
    public double calculateDiscount(@Nullable User user, @Nonnull Event event,
                                    @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        int userTickets = user != null ? user.getTicketsSize() : 0;
        long bonusTickets = 0;

        for (long i = userTickets + 1; i <= userTickets + numberOfTickets; i++) {
            if (i % DISCOUNT_TICKET_NUMBER == 0) {
                bonusTickets++;
            }
        }

        return (double) (PERCENT_DISCOUNT * bonusTickets) / numberOfTickets;
    }
}
