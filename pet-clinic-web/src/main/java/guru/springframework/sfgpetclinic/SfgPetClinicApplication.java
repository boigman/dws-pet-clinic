package guru.springframework.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
//@EnableJpaRepositories("guru.springframework.sfgpetclinic")
@EntityScan("guru.springframework.sfgpetclinic")
@ComponentScan("guru.springframework.sfgpetclinic")

//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@ImportResource("classpath:wongo.xml")
public class SfgPetClinicApplication {

	public static void main(String[] args) {
		System.out.println("Hello from SfgPetClinicApplication");
		SpringApplication.run(SfgPetClinicApplication.class, args);
	}

}
