package asw.edipogram.enigmi.domain.proxy.impl;

import asw.edipogram.common.dto.EnigmaCreatedDTO;
import asw.edipogram.common.event.EnigmaCreatedEvent;
import asw.edipogram.enigmi.domain.EnigmiSeguitiClient;
import asw.edipogram.enigmi.domain.EnigmaDomainEventPublisher;
import asw.edipogram.enigmi.domain.EnigmiSeguitiClientAsync;
import asw.edipogram.enigmi.domain.entity.Enigma;
import asw.edipogram.enigmi.domain.proxy.ConnectorProxy;
import asw.edipogram.enigmi.domain.proxy.enums.ForwardMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectorProxyImpl implements ConnectorProxy {

    @Value("${asw.edipogram.mode}")
    private String FORWARD_METHOD = ForwardMethod.MESSAGE.getName();

    @Autowired
    private EnigmiSeguitiClient enigmiSeguitiClient;

    @Autowired
    private EnigmiSeguitiClientAsync enigmiSeguitiClientAsync;

    @Autowired
    private EnigmaDomainEventPublisher publisher;

    @Override
    public void forward(Enigma enigma) {

        if(FORWARD_METHOD.equals(ForwardMethod.MESSAGE.toString())) {
            EnigmaCreatedEvent enigmaCreatedEvent = new EnigmaCreatedEvent(
                    enigma.getAutore(),enigma.getTipo(),enigma.getTipoSpecifico(),
                    enigma.getTitolo(),enigma.getTesto());
            publisher.publish(enigmaCreatedEvent);
        } else if(FORWARD_METHOD.equals(ForwardMethod.REST.toString())) {
            EnigmaCreatedDTO enigmaCreatedDTO = new EnigmaCreatedDTO(enigma.getAutore(),enigma.getTipo(),enigma.getTipoSpecifico(),
                    enigma.getTitolo(),enigma.getTesto());
            enigmiSeguitiClient.createEnigma(enigmaCreatedDTO);
        } else if(FORWARD_METHOD.equals(ForwardMethod.REST_ASYNC.toString())) {
            EnigmaCreatedDTO enigmaCreatedDTO = new EnigmaCreatedDTO(enigma.getAutore(),enigma.getTipo(),enigma.getTipoSpecifico(),
                    enigma.getTitolo(),enigma.getTesto());
            enigmiSeguitiClientAsync.createEnigma(enigmaCreatedDTO);
        }

    }
}

