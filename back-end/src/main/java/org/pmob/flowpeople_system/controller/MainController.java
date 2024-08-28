package org.pmob.flowpeople_system.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @Bean
    String title(){
        return "Gerenciador de Fluxo de Pessoas";
    }
}
