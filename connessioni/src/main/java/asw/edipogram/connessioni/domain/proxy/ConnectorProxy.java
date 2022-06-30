package asw.edipogram.connessioni.domain.proxy;

import asw.edipogram.connessioni.domain.vo.ConnessioneVO;

public interface ConnectorProxy {

    void forward(ConnessioneVO enigmaVO);

}
