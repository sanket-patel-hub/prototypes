package org.sanket.hotel.reservation.system.repository;

import org.sanket.hotel.reservation.system.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest,Long> {
}
