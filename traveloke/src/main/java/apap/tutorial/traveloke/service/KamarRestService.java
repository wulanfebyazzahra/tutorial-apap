package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarRestService {
    // Create Kamar
    KamarModel createKamar(KamarModel kamar);

    // Read Kamar
    List<KamarModel> retrieveListKamar();
    KamarModel getKamarByIdKamar(Long noKamar);

    // Update Kamar
    KamarModel changeKamar(Long noKamar, KamarModel kamar);

    // Delete Kamar
    void deleteKamar(Long noKamar);
}
