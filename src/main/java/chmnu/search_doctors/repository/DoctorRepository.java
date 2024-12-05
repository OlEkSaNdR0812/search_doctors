package chmnu.search_doctors.repository;

import chmnu.search_doctors.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecializationAndCity(String specialization, String city);

    List<Doctor> findBySpecialization(String specialization);

    List<Doctor> findByCity(String city);
}
