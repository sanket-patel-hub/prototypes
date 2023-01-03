package org.sanket.hotel.reservation.system.service;

import org.sanket.hotel.reservation.system.entity.Guest;
import org.sanket.hotel.reservation.system.entity.Reservation;
import org.sanket.hotel.reservation.system.entity.Room;
import org.sanket.hotel.reservation.system.dto.RoomReservation;
import org.sanket.hotel.reservation.system.repository.GuestRepository;
import org.sanket.hotel.reservation.system.repository.ReservationRepository;
import org.sanket.hotel.reservation.system.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private  RoomRepository repository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomReservation> getRoomReservationForDate(Date date) {
        Iterable<Room> rooms = this.repository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomNumber(room.getRoomNo());
            roomReservationMap.put(room.getId(),roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByResDate(new java.sql.Date(date.getTime()));

        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });

        return roomReservationMap.values().stream().sorted(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if(o1.getRoomName().equals(o2.getRoomName())) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomNumber().compareTo(o2.getRoomNumber());
            }
        }).collect(Collectors.toList());
    }

    public RoomReservation getRoomReservationById(long roomId) {
        Room room = this.repository.findById(roomId).get();
        RoomReservation roomReservation = new RoomReservation();
        if(null != room) {
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomNumber(room.getRoomNo());
        }
        return roomReservation;
    }


    public List<Guest> getAllHotelGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        for (Guest guest : guests) {
            guestList.add(guest);
        }
        return guestList;
    }

    public List<Room> getAllHotelRooms() {
        Iterable<Room> rooms = this.roomRepository.findAll();
        List<Room> roomList = new ArrayList<>();
        for (Room room : rooms) {
            roomList.add(room);
        }
        return roomList;
    }

    public void addGuest(Guest guest) {
        if(null == guest) {
            throw new RuntimeException("Not able to add Guest!");
        }
        this.guestRepository.save(guest);
    }
}
