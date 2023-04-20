package org.sanket.hotel.reservation.system.repository;

import org.sanket.hotel.reservation.system.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
