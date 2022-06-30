package asw.edipogram.enigmi.domain.proxy.impl;

import asw.edipogram.common.dto.EnigmaCreatedDTO;
import asw.edipogram.common.event.EnigmaCreatedEvent;
import asw.edipogram.enigmi.domain.EnigmiSeguitiClient;
import asw.edipogram.enigmi.domain.EnigmaDomainEventPublisher;
import asw.edipogram.enigmi.domain.EnigmiSeguitiClientAsync;
import asw.edipogram.enigmi.domain.proxy.ConnectorProxy;
import asw.edipogram.enigmi.domain.proxy.enums.ForwardMethod;
import asw.edipogram.enigmi.domain.vo.EnigmaVO;
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
    private EnigmaDomainEventPublisher publisher;

    @Override
    public void forward(EnigmaVO enigmaVO) {

        if(FORWARD_METHOD.equals(ForwardMethod.MESSAGE.toString())) {
            EnigmaCreatedEvent enigmaCreatedEvent = new EnigmaCreatedEvent(
                    enigmaVO.getAutore(),enigmaVO.getTipo(),enigmaVO.getTipoSpecifico(),
                    enigmaVO.getTitolo(),enigmaVO.getTesto());
            publisher.publish(enigmaCreatedEvent);
        } else if(FORWARD_METHOD.equals(ForwardMethod.REST.toString())) {
            EnigmaCreatedDTO enigmaCreatedDTO = new EnigmaCreatedDTO(enigmaVO.getAutore(),enigmaVO.getTipo(),enigmaVO.getTipoSpecifico(),
                    enigmaVO.getTitolo(),enigmaVO.getTesto());
            enigmiSeguitiClient.createEnigma(enigmaCreatedDTO);
        } else if(FORWARD_METHOD.equals(ForwardMethod.REST_ASYNC.toString())) {
            EnigmaCreatedDTO enigmaCreatedDTO = new EnigmaCreatedDTO(enigmaVO.getAutore(),enigmaVO.getTipo(),enigmaVO.getTipoSpecifico(),
                    enigmaVO.getTitolo(),enigmaVO.getTesto());
            enigmiSeguitiClientAsync.createEnigma(enigmaCreatedDTO);
        }

    }
}

