package asw.edipogram.enigmi.client.impl;

import asw.edipogram.common.dto.EnigmaCreatedDTO;
import asw.edipogram.enigmi.domain.EnigmiSeguitiClientAsync;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Component
public class EnigmiSeguitiAsyncClientImpl implements EnigmiSeguitiClientAsync {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${asw.edipogram.enigmiservice.enigmiseguiti.uri}")
    private String baseUrl;

    @Override
    @Async
    public CompletableFuture<Void> createEnigma(EnigmaCreatedDTO enigmaCreatedDTO) {
        restTemplate.postForObject(baseUrl + "/enigmi",enigmaCreatedDTO,Void.class);
        return new CompletableFuture<>();
    }

}
