package com.kirill.microservice.service.impl;

import com.kirill.microservice.entity.Status;
import com.kirill.microservice.service.StatusService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import static com.kirill.microservice.config.StatusConfig.PROD;
import static com.kirill.microservice.config.StatusConfig.STATUS_VERSION;

@Service
@ConditionalOnProperty(value = STATUS_VERSION, havingValue = PROD)
public class StatusServiceProd implements StatusService {
    @Override
    public Status getStatus() {
        Status status = new Status();
        status.setMessage("PROD PROD PROD");
        return status;
    }
}
