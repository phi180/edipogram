package asw.edipogram.enigmi.client.impl;

import asw.edipogram.common.dto.EnigmaCreatedDTO;
import asw.edipogram.enigmi.domain.EnigmiSeguitiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class EnigmiSeguitiClientImpl implements EnigmiSeguitiClient {

    private WebClient webClient = WebClient.builder().build();

    @Value("${asw.edipogram.enigmiservice.enigmiseguiti.uri}")
    private String baseUrl;

    @Override
    public void createEnigma(EnigmaCreatedDTO enigmaCreatedDTO) {
        log.info("EnigmiSeguitiClientImpl - createEnigma(): enigmaCreatedDTO={}, baseUrl={}",enigmaCreatedDTO,baseUrl);

        webClient.post()
                .uri(baseUrl + "/enigmi")
                .body(Mono.just(enigmaCreatedDTO), EnigmaCreatedDTO.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}