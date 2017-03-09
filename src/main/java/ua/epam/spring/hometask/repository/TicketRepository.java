package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Oksana_Moroz on 3/9/2017.
 */
public interface TicketRepository extends AbstractDomainObjectRepository<Ticket>{

    Set<Ticket> getByEventAndDate(@Nonnull Event event, @Nonnull LocalDateTime dateTime);
}
