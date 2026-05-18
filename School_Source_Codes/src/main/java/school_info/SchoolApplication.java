package school_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"auth_info", "school_info"}) // Scan both packages
@EnableJpaRepositories(basePackages = {"auth_info.repository","school_info.repository"}) // Ensure repositories are detected
@EntityScan(basePackages = {"auth_info.models","school_info.models"})
public class SchoolApplication {

	public static void main(String[] args) {
		System.out.println("Inside main()");
		SpringApplication.run(SchoolApplication.class, args);
	}

}
