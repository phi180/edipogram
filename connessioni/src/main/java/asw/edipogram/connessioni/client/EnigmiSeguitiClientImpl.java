package asw.edipogram.connessioni.client;

import asw.edipogram.common.rest.CreateConnessioneRequest;
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
    public void connessioneCreated(CreateConnessioneRequest createConnessioneRequest) {
        log.info("EnigmiSeguitiClientImpl - connessioneCreated(): createConnessioneRequest={}, baseUrl={}", createConnessioneRequest,baseUrl);

        webClient.post()
                .uri(baseUrl + "/connessioni")
                .body(Mono.just(createConnessioneRequest), CreateConnessioneRequest.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}