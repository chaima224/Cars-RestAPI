package org.example.voiture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.CommandLineRunner;
import org.example.voiture.model.Car;
import org.example.voiture.repositories.CarRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.voiture.repositories")
public class VoitureApplication {
    @Autowired
    private final CarRepository carRepository;

    public VoitureApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner demo() {
        return args -> {
            // Création de quelques instances de Car
            Car car1 = new Car("Model1", "Brand1", 2022);
            Car car2 = new Car("Model2", "Brand2", 2023);

            // Enregistrement des instances dans la base de données
            carRepository.save(car1);
            carRepository.save(car2);

            // Affichage des données insérées dans la console
            System.out.println("Données insérées avec succès !");
        };
    }*/
}
