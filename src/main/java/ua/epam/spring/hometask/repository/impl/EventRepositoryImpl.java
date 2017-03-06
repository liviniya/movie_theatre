package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.repository.EventRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public class EventRepositoryImpl extends AbstractDomainObjectRepositoryImpl<Event> implements EventRepository {

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return objects.stream()
                .filter(e -> Objects.equals(e.getName(), name))
                .findAny()
                .orElse(null);
    }

    @Nonnull
    @Override
    public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
        return objects.stream()
                .filter(e -> e.airsOnDates(from, to))
                .collect(Collectors.toSet());
    }

    @Nonnull
    @Override
    public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
        LocalDateTime now = LocalDateTime.now();
        return objects.stream()
                .filter(e -> e.airsOnDates(now, to))
                .collect(Collectors.toSet());
    }

    @Override
    protected void updateExistedObject(Event existed, Event object) {
        existed.setName(object.getName());
        existed.setAirDates(object.getAirDates());
        existed.setBasePrice(object.getBasePrice());
        existed.setRating(object.getRating());
        existed.setAuditoriums(object.getAuditoriums());
    }
}
