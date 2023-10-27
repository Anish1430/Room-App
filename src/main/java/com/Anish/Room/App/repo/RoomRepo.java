package com.Anish.Room.App.repo;

import com.Anish.Room.App.model.Room;
import com.Anish.Room.App.model.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends CrudRepository<Room,Integer> {


    List<Room> findByRoomPrice(double price);

    List<Room> findByRoomPriceLessThanEqualAndRoomAvailable(double price, boolean b);


    List<Room> findByRoomPriceLessThanEqualOrRoomAvailable(double price, boolean b);

    List<Room> findByRoomTypeOrRoomAvailableOrderByRoomPrice(Type type, boolean b);

    List<Room> findByRoomPriceGreaterThanEqualAndRoomAvailable(double price, boolean b);


//
//    List<Room> findByRoomPriceGreaterThanEqualAndAvailable(Integer price, boolean b);
}
