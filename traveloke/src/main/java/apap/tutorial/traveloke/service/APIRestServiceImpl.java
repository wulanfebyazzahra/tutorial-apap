package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import javax.transaction.Transactional;

@Service
@Transactional
public class APIRestServiceImpl implements APIRestService {
    private final WebClient webClient;

    @Autowired
    private HotelDb hotelDb;

    public APIRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .defaultHeader("x-rapidapi-key", "27038e76e3msh6a4d7b163c4be78p1e8c00jsn27e2c93975be")
                .defaultHeader("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .defaultHeader("useQueryString", "true")
                .baseUrl(Setting.cityUrl).build();
    }

    @Override
    public Mono<String> findCity(String cityName) {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("query", cityName);
        data.add("locale", "en_us");
        return this.webClient.get().uri(uriBuilder -> uriBuilder.queryParams(data).build()).retrieve().bodyToMono(String.class);
    }
}
