package com.Anish.Room.App.controller;

import com.Anish.Room.App.model.Room;
import com.Anish.Room.App.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

        @Autowired
    RoomService roomService;
    //Post Api
    @PostMapping("room")
    public String addRoom(@RequestBody  Room newRoom){
        return roomService.addRoom(newRoom);
    }

    //Add multiple rooms at once....

    @PostMapping("rooms")
    public String addRooms(@RequestBody List<Room> newRooms) {
        return roomService.addRooms(newRooms);
    }

    //Get Api

   @GetMapping("rooms")
     public List<Room>  getRooms() {
        return roomService.getRooms();
   }

   @GetMapping("rooms/id/{id}")

    public Room getRoomById(@PathVariable Integer id){
        return roomService.getRoomById(id);
   }
  ///get all the value with price Name....

    @GetMapping("name/price/{price}")
     public List<Room> getPriceById(@PathVariable double price) {
        return roomService.getPriceById(price);
    }

   //Delete All by ids.....
   @DeleteMapping("rooms/ids")
     public String removeRoomsByIds(@RequestBody List<Integer> ids){
       return roomService.removeRoomsByIds(ids);
   }

   //Get all rooms less than or equal to
   //  -> Available =true;
    // -> Price <=10000;

    @GetMapping("name/price/{price}/and/available")
      public List<Room> getAvailableRoomsBelowPrice(@PathVariable double price){
        return roomService.getAvailableRoomsBelowPrice(price);
    }

    @GetMapping("name/price/{price}/or/available")
    public List<Room> getAvailableRoomsOrBelowRoomsPrice(@PathVariable double price) {
        return roomService.getAvailableRoomsOrBelowRoomsPrice(price);
    }

    @GetMapping("name/price/{price}/available")
    public List<Room> getAvailableRoomsMoreRoomsPrice(@PathVariable double price) {
        return roomService.getAvailableRoomsMoreRoomsPrice(price);
    }

     //Greater Than or Equal to in rooms....
    @GetMapping("name/AC/or/available")
    public List<Room> getAvailableRoomsOrAcSortedByPrice() {
        return roomService.getAvailableRoomsOrAcSortedByPrice();
    }
}
