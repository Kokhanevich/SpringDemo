package com.example.demo

import com.example.demo.controller.AuthController
import com.example.demo.payload.request.LoginRequest
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringDemoApplication {

    static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication, args)
    }

}
