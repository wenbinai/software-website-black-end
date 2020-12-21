package edu.nefu.softwarewebsite;

import edu.nefu.softwarewebsite.util.SnowflakeIdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftwareWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareWebsiteApplication.class, args);
    }

    @Bean
    public SnowflakeIdWorker createIdWorker() {
        return new SnowflakeIdWorker(0, 0);
    }


}
