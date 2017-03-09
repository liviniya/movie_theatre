package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.*;
import ua.epam.spring.hometask.repository.TicketRepository;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static ua.epam.spring.hometask.domain.EventRating.*;

/**
 * Created by Oksana_Moroz on 3/1/2017.
 */
public class BookingServiceImpl implements BookingService {

    public static final Double HIGH_RATE_COEFFICIENT = 1.2d;
    public static final Double MID_RATE_COEFFICIENT = 1d;
    public static final Double LOW_RATE_COEFFICIENT = 0.8d;

    public static final Integer VIP_SEAT_COEFFICIENT = 2;

    public static final Map<EventRating, Double> movieRatingCoefficients = new HashMap<>();

    static {
        movieRatingCoefficients.put(HIGH, HIGH_RATE_COEFFICIENT);
        movieRatingCoefficients.put(MID, MID_RATE_COEFFICIENT);
        movieRatingCoefficients.put(LOW, LOW_RATE_COEFFICIENT);
    }

    private DiscountService discountService;

    private TicketRepository ticketRepository;

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime,
                                  @Nullable User user, @Nonnull Set<Long> seats) {
        int numberOfTickets = seats.size();

        Auditorium auditorium = event.getAuditoriums().get(dateTime);

        if (auditorium != null) {
            long numberOfVips = auditorium.countVipSeats(seats);
            long numberOfNotVips = numberOfTickets - numberOfVips;

            double priceWithoutDiscount = movieRatingCoefficients.get(event.getRating())
                    * event.getBasePrice() * (numberOfNotVips + VIP_SEAT_COEFFICIENT * numberOfVips);

            double discountPercent = discountService.getDiscount(user, event, dateTime, numberOfTickets);
            double discountPrice = priceWithoutDiscount * discountPercent / 100;

            return priceWithoutDiscount - discountPrice;
        }

        throw new IllegalArgumentException("There is no assigned auditorium for specified date and time");
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            ticketRepository.save(ticket);
        }
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return ticketRepository.getByEventAndDate(event, dateTime);
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}
