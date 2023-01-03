package org.sanket.hotel.reservation.system.controller;

import org.sanket.hotel.reservation.system.entity.Guest;
import org.sanket.hotel.reservation.system.entity.Room;
import org.sanket.hotel.reservation.system.dto.RoomReservation;
import org.sanket.hotel.reservation.system.service.ReservationService;
import org.sanket.hotel.reservation.system.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomReservationRestController {

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private ReservationService reservationService;


    @GetMapping(path = "reservations")
    public List<RoomReservation> getReservations(@RequestParam(value = "date",required = false) String dateString) {

        Date date = this.dateUtil.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }
    @GetMapping(path = "reservations/{roomId}")
    public RoomReservation getReservations(@PathVariable("roomId") long roomId) {

        return this.reservationService.getRoomReservationById(roomId);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests() {
        return this.reservationService.getAllHotelGuests();
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return this.reservationService.getAllHotelRooms();
    }


    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        this.reservationService.addGuest(guest);
    }
}
