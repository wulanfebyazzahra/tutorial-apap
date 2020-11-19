package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarRestService {
    KamarModel createKamar(KamarModel kamar);

    List<KamarModel> retrieveListKamar();

    KamarModel getKamarByIdKamar(Long noKamar);

    KamarModel changeKamar(Long noKamar, KamarModel kamar);

    void deleteKamar(Long noKamar);
}
