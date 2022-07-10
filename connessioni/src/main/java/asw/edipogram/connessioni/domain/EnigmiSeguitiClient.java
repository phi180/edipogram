package asw.edipogram.connessioni.domain;

import asw.edipogram.common.rest.CreateConnessioneRequest;

public interface EnigmiSeguitiClient {

    void connessioneCreated(CreateConnessioneRequest createConnessioneRequest);

}