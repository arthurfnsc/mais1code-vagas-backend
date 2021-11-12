package br.com.maisumcode.vagasbackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VagasController {
    @RequestMapping(value = "v1/hello", produces = { "application/json" }, method = RequestMethod.GET)
    public String hello() {
        return "{\"value\":\"Olá, Arthur\"}";
    }
    @RequestMapping(value = "v2/hello", produces = { "application/json" }, method = RequestMethod.GET)
    public String hello2() {
        return "Olá, Arthur 2";
    }
}
