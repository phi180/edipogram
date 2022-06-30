package asw.edipogram.enigmi.domain.proxy;


import asw.edipogram.enigmi.domain.entity.Enigma;

public interface ConnectorProxy {

    void forward(Enigma enigmaVO);

}
