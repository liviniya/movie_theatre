package ua.epam.spring.hometask.discount;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
abstract public class DiscountStrategy {

    abstract public double calculateDiscount(@Nullable User user, @Nonnull Event event,
                                             @Nonnull LocalDateTime airDateTime, long numberOfTickets);

    protected double calculateDiscountForEvent(int percentDiscount, Event event) {
        return event.getBasePrice() * (percentDiscount / 100.0);
    }

    protected double calculateDiscountForEvent(int percentDiscount, Event event, long numberOfTickets) {
        return numberOfTickets * event.getBasePrice() * (percentDiscount / 100.0);
    }
}
