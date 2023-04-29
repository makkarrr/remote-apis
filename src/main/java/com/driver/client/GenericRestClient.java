package com.driver.client;

import com.driver.model.RequestDetails;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Service
public class GenericRestClient{
    private RestTemplate restTemplate = new RestTemplate();

    public void execute(String url, Class clazz) {
        restTemplate.getForObject(url, clazz);
    }

    public Object execute(RequestDetails requestDetails, Object data, ResponseErrorHandler errorHandler,
                          Class genericClass) throws ResourceAccessException, Exception {

        restTemplate.setErrorHandler(errorHandler);
        HttpHeaders headers = new HttpHeaders();

        HttpEntity entity = new HttpEntity(data, headers);
        ResponseEntity response = restTemplate.exchange(requestDetails.getUrl(), requestDetails.getRequestType(),
                entity, genericClass);
        return response.getBody();
    }
}
