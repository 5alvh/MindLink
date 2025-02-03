package com.mindlink.services.servicesImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.models.Appointment;
import com.mindlink.models.Room;
import com.mindlink.models.dtos.roomdtos.RoomDTO;
import com.mindlink.repositories.RoomRepository;
import com.mindlink.services.RoomService;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

    @Override
    public Room createRoom(Appointment appointment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRoom'");
    }

    @Override
    public boolean isOpenJointToRoom(Long idAppointment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOpenJointToRoom'");
    }

    @Override
    public RoomDTO findByAppointmentId(Long appointmentID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAppointmentId'");
    }

    // @Autowired
    // private RoomRepository roomRepository;

    // @Transactional
    // @Override
    // public Room createRoom(Appointment appointment) {
    // Room room = new Room();
    // // room.setRoomUrl(UUID.randomUUID().toString().substring(0, 20));
    // // room.setAppointment(appointment);
    // // room.setCreatedAt(LocalDate.now());
    // return roomRepository.save(room);
    // }

    // @Override
    // public boolean isOpenJointToRoom(Long idAppointment) {
    // Room room = roomRepository.findByAppointmentId(idAppointment)
    // .orElseThrow(() -> new RuntimeException("Room not found"));

    // LocalDateTime now = LocalDateTime.now();
    // LocalDateTime appointmentDateTime =
    // room.getAppointment().getAppointmentDate();

    // return now.isAfter(appointmentDateTime) &&
    // // now.isBefore(appointmentDateTime.plusHours(1));
    // }

    // @Override
    // public RoomDTO findByAppointmentId(Long appointmentID) {
    // return
    // roomRepository.findByAppointmentId(appointmentID).map(RoomMapper::roomToDTo)
    // .orElseThrow(() -> new RuntimeException("Room not found"));
    // }

}
