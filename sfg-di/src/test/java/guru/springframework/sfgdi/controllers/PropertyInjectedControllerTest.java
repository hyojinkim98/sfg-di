package guru.springframework.sfgdi.controllers;

import java.lang.ModuleLayer.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.match.ContentRequestMatchers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;

public class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new ConstructorGreetingService(); // runtime에 implementation 준다.
    }

    @Test
    void getGreeting() {
        System.out.print(controller.getGreeting());
    }

}
