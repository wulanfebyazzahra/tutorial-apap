package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class KamarController{
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{id}")
    private String addKamarFormPage(
            @PathVariable Long id,
            Model model
    ){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(id);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);

        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    public String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }
}