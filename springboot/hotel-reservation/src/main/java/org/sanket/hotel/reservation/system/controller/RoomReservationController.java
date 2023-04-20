package org.sanket.hotel.reservation.system.controller;

import org.sanket.hotel.reservation.system.dto.RoomReservation;
import org.sanket.hotel.reservation.system.service.ReservationService;
import org.sanket.hotel.reservation.system.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
    private final DateUtil dateUtil;
    private final ReservationService reservationService;

    private RoomReservationController(DateUtil dateUtil,ReservationService reservationService) {
        this.dateUtil = dateUtil;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(@RequestParam(value = "date",required = false) String dateString, Model model) {
        Date date = this.dateUtil.createDateFromDateString(dateString);
        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationForDate(date);
        model.addAttribute("roomReservations",roomReservationList);
        return "roomres";
    }
}
