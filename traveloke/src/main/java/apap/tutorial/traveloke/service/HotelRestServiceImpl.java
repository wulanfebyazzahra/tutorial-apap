package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class HotelRestServiceImpl implements HotelRestService {
    private final WebClient webClient;

    @Autowired
    private HotelDb hotelDb;

    @Override
    public HotelModel createHotel(HotelModel hotel){return hotelDb.save(hotel);}

    @Override
    public HotelModel getHotelByIdHotel(Long id) {
        Optional<HotelModel> hotel = hotelDb.findById(id);
        if(hotel.isPresent()){
            return hotel.get();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteHotel(Long id) {
        HotelModel hotel = getHotelByIdHotel(id);
        if(hotel.getListKamar().size()==0){
            hotelDb.delete(hotel);
        }else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public HotelModel changeHotel(Long id, HotelModel hotelUpdate) {
        HotelModel hotel = getHotelByIdHotel(id);
        hotel.setNamaHotel(hotelUpdate.getNamaHotel());
        hotel.setAlamat(hotelUpdate.getAlamat());
        hotel.setNomorTelepon(hotelUpdate.getNomorTelepon());
        return hotelDb.save(hotel);
    }

    @Override
    public List<HotelModel> retrieveListHotel() {
        return hotelDb.findAll();
    }


    public HotelRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.hotelUrl).build();
    }
    @Override
    public Mono<String> getStatus(Long id) {
        return this.webClient.get().uri("/rest/hotel/"+id+"/status/").retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<HotelDetail> postStatus() {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("alamat","Jl. X");
        data.add("nomorTelepon", "08111112");
        return this.webClient.post().uri("/rest/hotel/full")
                .syncBody(data)
                .retrieve()
                .bodyToMono(HotelDetail.class);
    }
}