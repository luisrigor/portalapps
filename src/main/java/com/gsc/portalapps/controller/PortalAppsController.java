package com.gsc.portalapps.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("${app.baseUrl}")
@Api(value = "",tags = "PORTAL APPS")
@RestController
@CrossOrigin("*")
public class PortalAppsController {

        @GetMapping(value="/")
        public String test(){
            return "Portal Apps!!";
        }
}
