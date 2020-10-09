package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;

import java.util.List;

public interface HotelService {

    // Method untuk menambah Hotel
    void addHotel(HotelModel hotel);

    //Method untuk mendapatkan daftar Hotel yang telah tersimpan
    List<HotelModel> getHotelList();

    //Method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(Long id);

    // Method untuk mengupdate suatu data hotel
    HotelModel updateHotel(HotelModel hotel);

    // Method untuk order hotel by descending
     List<HotelModel> getIdOrderDesc();

    // Method untuk menghapus data hotel
    List<HotelModel> deleteHotel(Long id);
}

