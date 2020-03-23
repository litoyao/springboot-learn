package com.example.demo;

import com.example.demo.aop.Speakable;
import com.example.demo.configurations.PetConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private Speakable personSpring;
    public static void main(String[] args) {
        ApplicationContext ctx= SpringApplication.run(DemoApplication.class, args);

        System.out.println("======================================");
        System.out.println("server.port:"+ctx.getEnvironment().getProperty("server.port"));
        System.out.println("server.port:"+ctx.getEnvironment().getProperty("application.name"));

        PetConfig petConfig=(PetConfig)ctx.getBean("petConfig");
        petConfig.show();

    }



    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            // spring aop
            System.out.println("******** spring aop ******** ");
            personSpring.sayHi();
            personSpring.sayBye();
          //  System.exit(0);
        };
    }

}
