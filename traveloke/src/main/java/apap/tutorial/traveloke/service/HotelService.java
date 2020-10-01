package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import java.util.List;

public interface HotelService {

    // Method untuk menambah Hotel
    void addHotel(HotelModel hotel);

    //Method untuk mendapatkan daftar Hotek yang telah tersimpan
    List<HotelModel> getHotelList();

    //Method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(String idHotel);

    // Method untuk mendapatkan data nomor telepon
    HotelModel updateHotel(String idHotel, String noTelepon);

    // Method untuk menghapus data
    HotelModel deleteHotel(String idHotel);
}
