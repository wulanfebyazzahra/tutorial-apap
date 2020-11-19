package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController {
    @Autowired
    private KamarRestService kamarRestService;
    @Autowired
    private HotelService hotelService;
    
    @PostMapping(value = "/kamar")
    private ResponseEntity<String> createKamar(@Valid @RequestBody KamarModel kamar, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else{
            kamarRestService.createKamar(kamar);
            return ResponseEntity.ok("Add kamar success!");
        }
    }

    @GetMapping(value = "/kamar/{noKamar}")
    private KamarModel retrieveKamar(@PathVariable("noKamar") Long noKamar){
        try{
            return kamarRestService.getKamarByIdKamar(noKamar);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Kamar"+String.valueOf(noKamar)+" Not Found"
            );
        }
    }

    @DeleteMapping(value = "/kamar/{noKamar}")
    private ResponseEntity<String> deleteKamar(@PathVariable("noKamar") Long noKamar){
        try{
            kamarRestService.deleteKamar(noKamar);
            return ResponseEntity.ok("Kamar with ID" + String.valueOf(noKamar)+ " Deleted!");
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID "+ String.valueOf(noKamar)+ "Not Found!");
        }
    }

    @PutMapping(value = "/kamar/{noKamar}")
    private ResponseEntity<String> updateKamar(
            @PathVariable(value = "noKamar") Long noKamar,
            @RequestBody KamarModel kamar
    ){
        try{
            kamarRestService.changeKamar(noKamar, kamar);
            return ResponseEntity.ok("Update kamar success");
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID "+ String.valueOf(noKamar)+ "Not Found!"
            );
        }
    }

    @GetMapping(value = "/kamar-all")
    private List<KamarModel> retrieveListKamar(){return kamarRestService.retrieveListKamar();}

}
