package asw.edipogram.connessioni.domain.proxy;

import asw.edipogram.connessioni.domain.entity.Connessione;

public interface ConnectorProxy {

    void forward(Connessione connessione);

}
