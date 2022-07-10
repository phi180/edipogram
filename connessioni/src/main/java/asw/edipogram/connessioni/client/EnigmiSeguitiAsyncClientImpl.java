package asw.edipogram.connessioni.client;

import asw.edipogram.common.rest.CreateConnessioneRequest;
import asw.edipogram.connessioni.domain.EnigmiSeguitiClientAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class EnigmiSeguitiAsyncClientImpl implements EnigmiSeguitiClientAsync {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${asw.edipogram.connessioniservice.enigmiseguiti.uri}")
    private String baseUrl;

    @Override
    @Async
    public void connessioneCreated(CreateConnessioneRequest createConnessioneRequest) {
        log.info("EnigmiSeguitiAsyncClientImpl - connessioneCreated(): createConnessioneRequest={}, baseUrl={}", createConnessioneRequest,baseUrl);

        restTemplate.postForObject(baseUrl + "/connessioni", createConnessioneRequest,Void.class);
    }

}
