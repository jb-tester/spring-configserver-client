package org.example.springconfigserverclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *
 * <p>get properties from the config server</p>
 * *
 */
@RestController
@RequestMapping("/")
public class ClientController {

    @Value("${my.props.prop1:test1}")
    private String prop1;
    @Value("${my.props.prop2:test1}")
    private String prop2;
    @Value("${my.profile-specific.prop1}")
    private String profProp;

    @GetMapping("/test1")
    public String test1() {
        return prop1+" "+profProp;
    }
    @GetMapping("/test2")
    public String test2() {
        return prop2+" "+profProp;
    }


}
