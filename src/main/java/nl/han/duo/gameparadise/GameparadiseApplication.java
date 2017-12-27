package nl.han.duo.gameparadise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GameparadiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameparadiseApplication.class, args);
	}
}
