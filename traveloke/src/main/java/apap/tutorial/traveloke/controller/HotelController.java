package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class HotelController{
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @RequestMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        hotelService.addHotel(hotel);
        model.addAttribute("id", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{id}")
    public String changeHotelFormPage(
            @PathVariable Long id,
            Model model){
        try{
            HotelModel hotel = hotelService.getHotelByIdHotel(id);
            model.addAttribute("hotel", hotel);
            return "form-update-hotel";
        }
        catch (Exception e){
            return "hotel-null";
        }
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "id") Long id,
            Model model){
        try {
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(id);
            HotelModel hotel = hotelService.getHotelByIdHotel(id);
            model.addAttribute("hotel", hotel);
            model.addAttribute("listKamar", listKamar);
            return "view-hotel";
        }
        catch (Exception e){
            return "hotel-null";
        }
    }

    @GetMapping("/hotel/viewall")
    public String viewAllHotel(Model model){
        List<HotelModel> hotel = hotelService.getIdOrderDesc();
        model.addAttribute("hotel", hotel);
        return "viewall-hotel";
    }

    @GetMapping(value = "/hotel/delete/{id}")
    public String DeletePathVariable(
            @PathVariable(value = "id") Long id,
            Model model){
        try{
            HotelModel hotel = hotelService.getHotelByIdHotel(id);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(id);
            if (listKamar.isEmpty()) {
                List<HotelModel> hotel1 = hotelService.deleteHotel(id);
                model.addAttribute("hotel", hotel1);
                return "delete-hotel";
            }
            else{
                return "warning";
            }
        }
        catch (Exception e){
            return "hotel-null";
        }
    }
}