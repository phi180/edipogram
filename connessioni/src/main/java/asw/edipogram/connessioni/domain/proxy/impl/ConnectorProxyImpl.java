package asw.edipogram.connessioni.domain.proxy.impl;

import asw.edipogram.common.dto.ConnessioneCreatedDTO;
import asw.edipogram.common.dto.EnigmaCreatedDTO;
import asw.edipogram.common.event.ConnessioneCreatedEvent;
import asw.edipogram.common.event.EnigmaCreatedEvent;
import asw.edipogram.connessioni.domain.ConnessioneDomainEventPublisher;
import asw.edipogram.connessioni.domain.EnigmiSeguitiClient;
import asw.edipogram.connessioni.domain.EnigmiSeguitiClientAsync;
import asw.edipogram.connessioni.domain.entity.Connessione;
import asw.edipogram.connessioni.domain.proxy.ConnectorProxy;
import asw.edipogram.connessioni.domain.vo.ConnessioneVO;
import asw.edipogram.connessioni.domain.proxy.enums.ForwardMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectorProxyImpl implements ConnectorProxy { // RIVEDERE NOME DELLA CLASSE TODO

    @Value("${asw.edipogram.mode}")
    private String FORWARD_METHOD = ForwardMethod.MESSAGE.getName();

    @Autowired
    private EnigmiSeguitiClient enigmiSeguitiClient;

    @Autowired
    private EnigmiSeguitiClientAsync enigmiSeguitiClientAsync;

    @Autowired
    private ConnessioneDomainEventPublisher publisher;

    @Override
    public void forward(ConnessioneVO connessioneVO) {

        if(FORWARD_METHOD.equals(ForwardMethod.MESSAGE.toString())) {
            publisher.publish(new ConnessioneCreatedEvent(connessioneVO.getUtente(),connessioneVO.getTipo()));
        } else if(FORWARD_METHOD.equals(ForwardMethod.REST.toString())) {
            enigmiSeguitiClient.connessioneCreated(new ConnessioneCreatedDTO(connessioneVO.getUtente(),connessioneVO.getTipo()));
        } else if(FORWARD_METHOD.equals(ForwardMethod.REST_ASYNC.toString())) {
            enigmiSeguitiClientAsync.connessioneCreated(new ConnessioneCreatedDTO(connessioneVO.getUtente(),connessioneVO.getTipo()));
        }

    }
}

