package com.docker.setup;

import org.springframework.boot.SpringApplication;

public class TestSetupApplication {

    public static void main(String[] args) {
        SpringApplication.from(SetupApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
