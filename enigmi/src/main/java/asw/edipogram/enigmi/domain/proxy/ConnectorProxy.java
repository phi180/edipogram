package asw.edipogram.enigmi.domain.proxy;

import asw.edipogram.enigmi.domain.vo.EnigmaVO;

public interface ConnectorProxy {

    void forward(EnigmaVO enigmaVO);

}
