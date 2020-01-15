package com.jerry.springboot_file_upload;

import com.jerry.springboot_file_upload.storage.StorageProperties;
import com.jerry.springboot_file_upload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringbootFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFileUploadApplication.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService)
    {
        return (args)->{
            storageService.deleteAll();
            storageService.init();
        };
    }
}
