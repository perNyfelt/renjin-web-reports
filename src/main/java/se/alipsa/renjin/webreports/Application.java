package se.alipsa.renjin.webreports;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import se.alipsa.renjin.webreports.service.FileStorageProperties;
import se.alipsa.renjin.webreports.service.FileStorageService;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
@EnableScheduling
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner init(FileStorageService fileStorageService) {
    return (args) -> {
      fileStorageService.init();
    };
  }
}
