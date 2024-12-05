package chmnu.search_doctors.service;

import chmnu.search_doctors.entity.Doctor;
import chmnu.search_doctors.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findDoctors(String specialization, String city) {
        if (specialization != null && !specialization.trim().isEmpty() &&
                city != null && !city.trim().isEmpty()) {
            return doctorRepository.findBySpecializationAndCity(specialization, city);
        }

        if (specialization != null && !specialization.trim().isEmpty()) {
            return doctorRepository.findBySpecialization(specialization);
        }

        if (city != null && !city.trim().isEmpty()) {
            return doctorRepository.findByCity(city);
        }

        return doctorRepository.findAll();
    }
}
