package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.repository.AuditoriumRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public class AuditoriumRepositoryImpl implements AuditoriumRepository {

    private Properties properties;

    private Set<Auditorium> auditoriums = new HashSet<>();

    private void init() {
        int quantity = Integer.valueOf(properties.getProperty("quantity"));
        for (int i = 1; i <= quantity; i++) {
            Auditorium auditorium = new Auditorium();
            auditorium.setName(properties.getProperty("name" + i));
            auditorium.setNumberOfSeats(Long.valueOf(properties.getProperty("numberOfSeats" + i)));
            auditorium.setVipSeats(parseVipSeats(properties.getProperty("vipSeats" + i)));
            auditoriums.add(auditorium);
        }
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriums.stream()
                .filter(a -> Objects.equals(a.getName(), name))
                .findAny()
                .orElse(null);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    void setAuditoriums(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    private Set<Long> parseVipSeats(String vipSeatsStr) {
        Set<Long> vipSeats = Arrays.stream(vipSeatsStr.split(","))
                .filter(s -> !s.isEmpty())
                .map(s -> Long.valueOf(s))
                .collect(Collectors.toSet());
        return vipSeats;
    }
}
