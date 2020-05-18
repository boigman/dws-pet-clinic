package guru.springframework.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:wongo.xml")
public class SfgPetClinicApplication {

	public static void main(String[] args) {
		System.out.println("Hello from SfgPetClinicApplication");
		SpringApplication.run(SfgPetClinicApplication.class, args);
	}

}
