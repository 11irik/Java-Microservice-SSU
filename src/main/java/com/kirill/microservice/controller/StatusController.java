package com.kirill.microservice.controller;

import com.kirill.microservice.entity.Status;
import com.kirill.microservice.service.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public Status get() {
        return statusService.getStatus();
    }
}
