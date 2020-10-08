package apap.tutorial.traveloke.controller;
import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    // Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotel(
            // Request parameter yang ingin dibawa
            @RequestParam(value = "idHotel", required = true) String idHotel,
            @RequestParam(value = "namaHotel", required = true) String namaHotel,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ) {
        // Membuat objek HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        // Memanggil service addHotel
        hotelService.addHotel(hotel);

        // Add variabel id hotel ke 'idHotel' untuk dirender pada thymelead
        model.addAttribute("idHotel", idHotel);

        // Return view template yang digunakan
        return "add-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String listhotel(Model model) {

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variabel semua HotelModel ke 'listhotel' untuk dirender pada thymeleaf
        model.addAttribute("listHotel", listHotel);

        // Return view template yang diinginkan
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/view")
    public String detailHotel(@RequestParam(value = "idHotel") String idHotel, Model model) {

        // Mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        // Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "view-hotel";
    }

    @GetMapping(value = "/hotel/view/id-hotel/{idHotel}")
    public String GetIdwithPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ) {
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if (hotel == null) {
            return "hotel-null";
        }
        model.addAttribute("hotel", hotel);
        return "view-hotel";
    }

    @GetMapping(value = "/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    public String GantiNomorPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            @PathVariable(value = "noTelepon") String noTelepon,
            Model model
    ){
        HotelModel hotel = hotelService.updateHotel(idHotel, noTelepon);
        if (hotel == null) {
            return "hotel-null";
        }
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping(value = "/hotel/delete/id-hotel/{idHotel}")
    public String DeletePathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ) {
        HotelModel hotel = hotelService.deleteHotel(idHotel);
        if (hotel == null) {
            return "hotel-null";
        }
        model.addAttribute("hotel", hotel);
        return "delete-hotel";
    }
}
