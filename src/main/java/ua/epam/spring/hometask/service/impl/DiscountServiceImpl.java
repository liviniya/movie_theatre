package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.discounts.DiscountStrategy;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Oksana_Moroz on 3/1/2017.
 */
public class DiscountServiceImpl implements DiscountService {

    private List<DiscountStrategy> discountStrategies;

    @Override
    public double getDiscount(@Nullable User user, @Nonnull Event event,
                            @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        double discount = 0;

        for (DiscountStrategy discountStrategy : discountStrategies) {
            double discountPercent = discountStrategy.calculateDiscount(user, event, airDateTime, numberOfTickets);
            if (discountPercent > discount) {
                discount = discountPercent;
            }
        }

        return discount;
    }

    public void setDiscountStrategies(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }
}
