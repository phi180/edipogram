package asw.edipogram.connessioni.domain;

import asw.edipogram.common.dto.ConnessioneCreatedDTO;

import java.util.concurrent.CompletableFuture;

public interface EnigmiSeguitiClientAsync {

    void connessioneCreated(ConnessioneCreatedDTO connessioneCreatedDTO);

}
