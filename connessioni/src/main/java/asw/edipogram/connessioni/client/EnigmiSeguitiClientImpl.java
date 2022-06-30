package asw.edipogram.connessioni.client;

import asw.edipogram.common.dto.ConnessioneCreatedDTO;
import asw.edipogram.connessioni.domain.EnigmiSeguitiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class EnigmiSeguitiClientImpl implements EnigmiSeguitiClient {

    private WebClient webClient = WebClient.builder().build();

    @Value("${asw.edipogram.connessioniservice.enigmiseguiti.uri}")
    private String baseUrl;

    @Override
    public void connessioneCreated(ConnessioneCreatedDTO connessioneCreatedDTO) {
        log.info("EnigmiSeguitiClientImpl - connessioneCreated(): connessioneCreatedDTO={}, baseUrl={}",connessioneCreatedDTO,baseUrl);

        webClient.post()
                .uri(baseUrl + "/connessioni")
                .body(Mono.just(connessioneCreatedDTO), ConnessioneCreatedDTO.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}