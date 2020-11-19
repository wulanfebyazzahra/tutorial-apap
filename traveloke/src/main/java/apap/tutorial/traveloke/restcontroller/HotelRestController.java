package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.service.APIRestService;
import apap.tutorial.traveloke.service.HotelRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class HotelRestController {

    @Autowired
    private HotelRestService hotelRestService;

    @Autowired
    private APIRestService apiRestService;

    @PostMapping(value = "/hotel")
    private HotelModel createHotel(@Valid  @RequestBody HotelModel hotel, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else {
            return hotelRestService.createHotel(hotel);
        }
    }

    @GetMapping(value = "/hotel/{id}")
    private HotelModel retrieveHotel(@PathVariable("id") Long id){
        try{
            return hotelRestService.getHotelByIdHotel(id);

        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Hotel"+ String.valueOf(id)+ " Not found"
            );
        }
    }

    @DeleteMapping(value = "/hotel/{id}")
    private ResponseEntity<String> deleteHotel(@PathVariable("id") Long id){
        try{
            hotelRestService.deleteHotel(id);
            return ResponseEntity.ok("Hotel with ID " + String.valueOf(id)+ " Deleted!");

        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Hotel wit ID "+ String.valueOf(id)+ " Not found"
            );
        }catch (UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, " Hotel still has kamar, please delete the kamar first");
        }
    }

    @PutMapping(value = "/hotel/{id}")
    private HotelModel updateHotel(
            @PathVariable(value = "id") Long id,
            @RequestBody HotelModel hotel
    ){
        try{
            return hotelRestService.changeHotel(id, hotel);

        }catch ( NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Hotel wit ID "+ String.valueOf(id)+ " Not found"
            );
        }
    }

    @GetMapping(value = "/hotels")
    private List<HotelModel> retrieveListHotel() {
        return hotelRestService.retrieveListHotel();}

    @GetMapping(value = "/hotel/{id}/status")
    private Mono<String> getStatus(@PathVariable Long id){
        return hotelRestService.getStatus(id);
    }

    @GetMapping(value = "/full")
    private Mono<HotelDetail> postStatus() {
        return hotelRestService.postStatus();
    }

    @GetMapping(value="/hotel/find")
    private Mono<String> findCity(@RequestParam String cityName){
        return apiRestService.findCity(cityName);
    }
}