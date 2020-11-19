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
                .defaultHeader("x-rapidapi-key", "a1fac913b6msh6dd7fc748095b76p153a4bjsnef6f01c14584")
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
