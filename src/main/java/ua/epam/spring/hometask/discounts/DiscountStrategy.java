package ua.epam.spring.hometask.discounts;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
public interface DiscountStrategy {

    double calculateDiscount(@Nullable User user, @Nonnull Event event,
                                    @Nonnull LocalDateTime airDateTime, long numberOfTickets);
}