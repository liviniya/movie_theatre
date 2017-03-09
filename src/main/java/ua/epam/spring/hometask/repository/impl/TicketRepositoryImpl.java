package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.repository.TicketRepository;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Oksana_Moroz on 3/9/2017.
 */
public class TicketRepositoryImpl extends AbstractDomainObjectRepositoryImpl<Ticket> implements TicketRepository {

    @Override
    protected void updateExistedObject(Ticket existed, Ticket object) {
        existed.setEvent(object.getEvent());
        existed.setDateTime(object.getDateTime());
        existed.setSeat(object.getSeat());
        existed.setUser(object.getUser());
    }

    @Override
    public Set<Ticket> getByEventAndDate(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return objects.stream()
                .filter(t -> Objects.equals(t.getEvent(), event) && Objects.equals(t.getDateTime(), dateTime))
                .collect(Collectors.toSet());
    }
}
