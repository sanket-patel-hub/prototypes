package org.sanket.hotel.reservation.system.repository;

import org.sanket.hotel.reservation.system.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findReservationByResDate(Date date);
}
