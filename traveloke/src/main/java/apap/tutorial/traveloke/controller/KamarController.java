package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

//    @GetMapping("/kamar/add/{id}")
//    private String addKamarFormPage(@PathVariable Long id, Model model){
//        KamarModel kamar = new KamarModel();
//        HotelModel hotel = hotelService.getHotelByIdHotel(id);
//        kamar.setHotel(hotel);
//        model.addAttribute("kamar", kamar);
//        return "form-add-kamar";
//    }

//    @PostMapping("/kamar/add")
//    private String addKamarSubmit(@ModelAttribute KamarModel kamar, Model model){
//        kamarService.addKamar(kamar);
//        model.addAttribute("kamar", kamar);
//        return "add-kamar";
//    }

    @GetMapping("/kamar/change/{noKamar}")
    public String updateKamarFormPage(
            @PathVariable Long noKamar, Model model){
        KamarModel kamar = kamarService.getNomorkamar(noKamar);
        model.addAttribute("kamar", kamar);
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar, Model model){
        KamarModel kamarUpdated = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "update-kamar";
    }

    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());

        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }

        return "delete-kamar";
    }

    @GetMapping({"/kamar/add/{id}"})
    private String addRow(@PathVariable Optional<Long> id, Model model) {
        HotelModel hotel;
        hotel = hotelService.getHotelByIdHotel(id.get());
        ArrayList<KamarModel> temp = new ArrayList<KamarModel>();
        temp.add(new KamarModel());
        hotel.setListKamar(temp);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value = "/kamar/add", params = {"simpan"})
    private String postAddRow(@ModelAttribute HotelModel hotel, Model model) {

        for (KamarModel kamar : hotel.getListKamar()) {
            kamar.setHotel(hotel);
            kamarService.addKamar(kamar);
        }
        int jumlahKamar = hotel.getListKamar().size();
        model.addAttribute("jumlahKamar", jumlahKamar);
        return "add-kamar";
    }

    @PostMapping(value="/kamar/add", params = {"add"})
    private String AddRowSubmit(@ModelAttribute HotelModel hotel, Model model){
        if(hotel.getListKamar() == null || hotel.getListKamar().size() == 0){
            hotel.setListKamar(new ArrayList<KamarModel>());
        }
        hotel.getListKamar().add(new KamarModel());
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value = "/kamar/add", params = {"delete"})
    private String deleteRow(@ModelAttribute HotelModel hotel, final HttpServletRequest req,
                                             Model model) {
        int row = Integer.valueOf(req.getParameter("delete"));
        hotel.getListKamar().remove(row);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }
}