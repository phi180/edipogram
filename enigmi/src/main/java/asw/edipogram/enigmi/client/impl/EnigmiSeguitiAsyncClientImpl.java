package asw.edipogram.enigmi.client.impl;

import asw.edipogram.common.rest.CreateEnigmaRequest;
import asw.edipogram.enigmi.domain.EnigmiSeguitiClientAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class EnigmiSeguitiAsyncClientImpl implements EnigmiSeguitiClientAsync {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${asw.edipogram.enigmiservice.enigmiseguiti.uri}")
    private String baseUrl;

    @Override
    @Async
    public void createEnigma(CreateEnigmaRequest createEnigmaRequest) {
        log.info("EnigmiSeguitiAsyncClientImpl - createEnigma: createEnigmaRequest={}, baseUrl={}", createEnigmaRequest, baseUrl);

        restTemplate.postForObject(baseUrl + "/enigmi", createEnigmaRequest,Void.class);
    }

}
