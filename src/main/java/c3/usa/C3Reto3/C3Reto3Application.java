package c3.usa.C3Reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = "c3.usa.C3Reto3.Model")
@SpringBootApplication
public class C3Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(C3Reto3Application.class, args);
	}

}
