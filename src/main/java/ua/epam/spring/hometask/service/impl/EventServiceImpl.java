package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
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
public class EventServiceImpl implements EventService {
    @Override
    public Event save(@Nonnull Event object) {
        return null;
    }

    @Override
    public void remove(@Nonnull Event object) {

    }

    @Override
    public Event getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return null;
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return null;
    }

    @Nonnull
    @Override
    public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
        return null;
    }

    @Nonnull
    @Override
    public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
        return null;
    }
}
