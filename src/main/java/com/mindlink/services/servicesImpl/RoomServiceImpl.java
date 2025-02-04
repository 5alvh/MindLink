package com.mindlink.services.servicesImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.mappers.RoomMapper;
import com.mindlink.models.Appointment;
import com.mindlink.models.Room;
import com.mindlink.models.dtos.roomdtos.RoomDTO;
import com.mindlink.repositories.RoomRepository;
import com.mindlink.services.RoomService;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    @Override
    public Room createRoom(Appointment appointment) {
        Room room = new Room();
        room.setRoomUrl(UUID.randomUUID().toString().substring(0, 20));
        room.setAppointment(appointment);
        room.setCreatedAt(LocalDate.now());
        return roomRepository.save(room);

    }

    @Override
    public boolean isOpenJointToRoom(Long idAppointment) {
        Room room = roomRepository.findByAppointmentId(idAppointment)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentDateTime = room.getAppointment().getAppointmentDate();

        return now.isAfter(appointmentDateTime) &&
                now.isBefore(appointmentDateTime.plusHours(1));
    }

    @Override
    public RoomDTO findByAppointmentId(Long appointmentID) {
        return roomRepository.findByAppointmentId(appointmentID).map(RoomMapper::roomToDTo)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

}
