package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);
    List<KamarModel> findAllKamarByIdHotel(Long id);
    KamarModel updateKamar(KamarModel kamar);
    KamarModel getNomorkamar(Long noKamar);
    void deleteKamar(KamarModel kamar);
}