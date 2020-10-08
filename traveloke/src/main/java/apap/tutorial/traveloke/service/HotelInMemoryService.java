//package apap.tutorial.traveloke.service;
//import java.util.List;
//import java.util.ArrayList;
//import org.springframework.stereotype.Service;
//import apap.tutorial.traveloke.model.HotelModel;
//
//@Service
//public class HotelInMemoryService implements HotelService {
//
//    private List<HotelModel> listHotel;
//    private HotelModel hotel;
//
//    // Constructor
//    public HotelInMemoryService (){
//        listHotel = new ArrayList<>();
//    }
//
//    @Override
//    public void addHotel(HotelModel hotel) {
//        listHotel.add(hotel);
//    }
//
//    @Override
//    public List<HotelModel> getHotelList() {
//        return listHotel;
//    }
//
//    // Method untuk menambahkan hotel menggunakan path variable
//    @Override
//    public HotelModel getHotelByIdHotel(Long idHotel) {
//        HotelModel tmp = null;
//        for (HotelModel hotel : listHotel){
//            if (hotel.getIdHotel().equals(idHotel)){
//                tmp = hotel;
//            }
//        }return tmp;
//    }
//
//    // Method untuk update
//    @Override
//    public HotelModel updateHotel(Long idHotel) {
//        HotelModel tmp = null;
//        for (HotelModel hotel : listHotel){
//            if (hotel.getIdHotel().equals(idHotel)){
////                hotel.setNomorTelepon(noTelepon);
//                tmp = hotel;
//            }
//        }return null;
//    }
//
//    // Method untuk delete
////    @Override
////    public HotelModel deleteHotel(String idHotel) {
////        HotelModel tmp = null;
////        for (int i=0; i<listHotel.size(); i++){
////            HotelModel hotel = listHotel.get(i);
////            if (hotel.getIdHotel().equals(idHotel)){
////                listHotel.remove(i);
////                hotel = tmp;
////            }
////        }return tmp;
////    }
//}
