package asw.edipogram.connessioni.domain;

import asw.edipogram.common.rest.CreateConnessioneRequest;

public interface EnigmiSeguitiClientAsync {

    void connessioneCreated(CreateConnessioneRequest createConnessioneRequest);

}
