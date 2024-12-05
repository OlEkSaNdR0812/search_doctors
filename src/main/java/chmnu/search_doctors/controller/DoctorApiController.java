package chmnu.search_doctors.controller;

import chmnu.search_doctors.entity.Doctor;
import chmnu.search_doctors.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorApiController {
    private final DoctorService doctorService;

    public DoctorApiController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/api/doctors")
    public List<Doctor> getDoctors(@RequestParam(required = false) String specialization,
                                   @RequestParam(required = false) String city) {
        return doctorService.findDoctors(specialization, city);
    }
}
