package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.DomainObject;
import ua.epam.spring.hometask.repository.AbstractDomainObjectRepository;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
abstract public class AbstractDomainObjectServiceImpl<T extends DomainObject>
        implements ua.epam.spring.hometask.service.AbstractDomainObjectService<T> {

    private Set<T> objects = new HashSet<T>();

    protected AbstractDomainObjectRepository<T> domainObjectRepository;

    @Override
    public T save(@Nonnull T object) {
        return domainObjectRepository.save(object);
    }

    @Override
    public void remove(@Nonnull T object) {
        domainObjectRepository.remove(object);
    }

    @Override
    public T getById(@Nonnull Long id) {
        return domainObjectRepository.getById(id);
    }

    @Nonnull
    @Override
    public Collection<T> getAll() {
        return domainObjectRepository.getAll();
    }

    public void setDomainObjectRepository(AbstractDomainObjectRepository<T> domainObjectRepository) {
        this.domainObjectRepository = domainObjectRepository;
    }
}
