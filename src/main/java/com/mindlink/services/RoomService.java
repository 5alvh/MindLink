/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.services;

import com.mindlink.models.Appointment;
import com.mindlink.models.Room;
import com.mindlink.models.dtos.roomdtos.RoomDTO;

/**
 *
 * @author madtore
 */
public interface RoomService {

    Room createRoom(Appointment appointment);

    boolean isOpenJointToRoom(Long idAppointment);

    RoomDTO findByAppointmentId(Long appointmentID);

}
