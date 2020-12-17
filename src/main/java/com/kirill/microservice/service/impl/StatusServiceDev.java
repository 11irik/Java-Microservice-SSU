package com.kirill.microservice.service.impl;

import com.kirill.microservice.entity.Status;
import com.kirill.microservice.service.StatusService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import static com.kirill.microservice.config.StatusConfig.DEV;
import static com.kirill.microservice.config.StatusConfig.STATUS_VERSION;

@Service
@ConditionalOnProperty(value = STATUS_VERSION, havingValue = DEV)
public class StatusServiceDev implements StatusService {
    @Override
    public Status getStatus() {
        Status status = new Status();
        status.setMessage("DEV DEV DEV");
        return status;
    }
}
