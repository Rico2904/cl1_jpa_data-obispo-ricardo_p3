package pe.edu._0.cl1_jpa_data_obispo_ricardo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu._0.cl1_jpa_data_obispo_ricardo.entity.Country;
import pe.edu._0.cl1_jpa_data_obispo_ricardo.repository.CountryRepository;

import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataObispoRicardoApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataObispoRicardoApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// 1. Consultar y mostrar idiomas de "ARG"
		Optional<Country> optionalARG = countryRepository.findById("ARG");
		optionalARG.ifPresentOrElse(
				country -> {
					System.out.println("Idiomas de Argentina (ARG):");
					country.getLanguages().forEach(language -> {
						System.out.println("- " + language.getCountryLanguageId().getLanguage());
					});
				},
				() -> System.out.println("País 'ARG' no encontrado.")
		);

		// 2. Eliminar "ARG" en cascada
		if (countryRepository.existsById("ARG")) {
			countryRepository.deleteById("ARG");
			System.out.println("El país 'ARG' y sus lenguajes fueron eliminados.");
		} else {
			System.out.println("El país 'ARG' no existe en la base de datos.");
		}
	}

}
