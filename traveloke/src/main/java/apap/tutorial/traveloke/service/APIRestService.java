package apap.tutorial.traveloke.service;
import reactor.core.publisher.Mono;

public interface APIRestService {
    Mono<String> findCity(String cityName);
}
