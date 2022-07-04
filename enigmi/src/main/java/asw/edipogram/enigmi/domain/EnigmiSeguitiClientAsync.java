package asw.edipogram.enigmi.domain;

import asw.edipogram.common.dto.EnigmaCreatedDTO;

import java.util.concurrent.CompletableFuture;

public interface EnigmiSeguitiClientAsync {

    void createEnigma(EnigmaCreatedDTO enigmaCreatedDTO);

}
