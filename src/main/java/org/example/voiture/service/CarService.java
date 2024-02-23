package org.example.voiture.service;

import org.example.voiture.model.Car;
import org.example.voiture.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Méthode pour ajouter une voiture
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Méthode pour mettre à jour une voiture
    public Car updateCar(Long id, Car updatedCar) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setModel(updatedCar.getModel());
            car.setBrand(updatedCar.getBrand());
            car.setYear(updatedCar.getYear());
            return carRepository.save(car);
        } else {
            throw new RuntimeException("Voiture introuvable avec l'ID: " + id);
        }
    }

    // Méthode pour supprimer une voiture
    public void deleteCar(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            carRepository.deleteById(id);
        } else {
            throw new RuntimeException("Voiture introuvable avec l'ID: " + id);
        }
    }

    // Méthode pour récupérer toutes les voitures
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Car getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            return optionalCar.get();
        } else {
            throw new RuntimeException("Voiture introuvable avec l'ID: " + id);
        }
    }
}
