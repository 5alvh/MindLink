package com.mindlink.mappers;

import com.mindlink.models.Room;
import com.mindlink.models.dtos.roomdtos.RoomDTO;

public class RoomMapper {

    public static RoomDTO roomToDTo(Room room) {
        return new RoomDTO("https://meet.jit.si/mindlink-appointment-" +
                room.getRoomUrl());
    }
}
