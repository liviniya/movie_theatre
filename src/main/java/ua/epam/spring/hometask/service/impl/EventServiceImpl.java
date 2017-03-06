package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.repository.EventRepository;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Oksana_Moroz on 3/1/2017.
 */
public class EventServiceImpl extends AbstractDomainObjectServiceImpl<Event> implements EventService {

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return ((EventRepository) domainObjectRepository).getByName(name);
    }

    @Nonnull
    @Override
    public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
        return ((EventRepository) domainObjectRepository).getForDateRange(from, to);
    }

    @Nonnull
    @Override
    public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
        return ((EventRepository) domainObjectRepository). getNextEvents(to);
    }
}
