package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface HotelRestService {
    HotelModel createHotel(HotelModel hotel);

    List<HotelModel> retrieveListHotel();

    HotelModel getHotelByIdHotel(Long id);

    HotelModel changeHotel(Long id, HotelModel hotelUpdate);

    void deleteHotel(Long id);

    Mono<String> getStatus(Long id);

    Mono<HotelDetail> postStatus();

}