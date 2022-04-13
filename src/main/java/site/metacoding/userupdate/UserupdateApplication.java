package site.metacoding.userupdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JpaAuditing 활성화
@SpringBootApplication
public class UserupdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserupdateApplication.class, args);
	}

}
