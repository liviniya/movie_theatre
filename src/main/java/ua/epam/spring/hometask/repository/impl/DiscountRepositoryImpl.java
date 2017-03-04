package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.DiscountRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public class DiscountRepositoryImpl implements DiscountRepository {
    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        return 0;
    }
}
