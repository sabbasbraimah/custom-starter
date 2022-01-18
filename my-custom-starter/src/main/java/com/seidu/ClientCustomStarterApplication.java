package com.seidu;

import ns.aop.LogMethodExecutionTime;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//Main Class
@SpringBootApplication
public class ClientCustomStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientCustomStarterApplication.class, args);
    }

    @Bean
    ApplicationRunner init(TestClass testClass) {
        return (ApplicationArguments args) -> dataSetup(testClass);
    }

    private void dataSetup(TestClass testClass) throws InterruptedException {
        testClass.run();
    }

    @Component
    public class TestClass {
        @LogMethodExecutionTime
        public void run() throws InterruptedException {
            Thread.sleep(3000);
        }
    }
}
