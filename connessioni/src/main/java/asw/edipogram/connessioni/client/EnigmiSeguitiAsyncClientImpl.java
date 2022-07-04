package asw.edipogram.connessioni.client;

import asw.edipogram.common.dto.ConnessioneCreatedDTO;
import asw.edipogram.connessioni.domain.EnigmiSeguitiClientAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class EnigmiSeguitiAsyncClientImpl implements EnigmiSeguitiClientAsync {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${asw.edipogram.connessioniservice.enigmiseguiti.uri}")
    private String baseUrl;

    @Override
    @Async
    public void connessioneCreated(ConnessioneCreatedDTO connessioneCreatedDTO) {
        log.info("EnigmiSeguitiAsyncClientImpl - connessioneCreated(): connessioneCreatedDTO={}, baseUrl={}",connessioneCreatedDTO,baseUrl);

        restTemplate.postForObject(baseUrl + "/connessioni",connessioneCreatedDTO,Void.class);
    }

}
