package pe.edu.tecsup.mascotasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MascotasApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MascotasApiRestApplication.class, args);
    }

}
