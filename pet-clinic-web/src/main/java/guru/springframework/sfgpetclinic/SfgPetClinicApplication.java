package guru.springframework.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@ImportResource("classpath:wongo.xml")
public class SfgPetClinicApplication {

	public static void main(String[] args) {
		System.out.println("Hello from SfgPetClinicApplication");
		SpringApplication.run(SfgPetClinicApplication.class, args);
	}

}
