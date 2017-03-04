package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.repository.AuditoriumRepository;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

/**
 * Created by Oksana_Moroz on 3/1/2017.
 */
public class AuditoriumServiceImpl implements AuditoriumService {

    private AuditoriumRepository auditoriumRepository;

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriumRepository.getAll();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumRepository.getByName(name);
    }

    public void setAuditoriumRepository(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }
}
