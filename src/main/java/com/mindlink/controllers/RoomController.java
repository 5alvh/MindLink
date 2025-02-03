package com.mindlink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.models.dtos.roomdtos.RoomDTO;
import com.mindlink.services.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/url")
    public ResponseEntity<?> getUrlRoom(@RequestParam Long appointmentID) {
        RoomDTO room = null;
        try {
            if (roomService.isOpenJointToRoom(appointmentID)) {
                room = roomService.findByAppointmentId(appointmentID);
            }
            return ResponseEntity.ok(room);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
