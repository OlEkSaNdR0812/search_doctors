package chmnu.search_doctors.controller;

import chmnu.search_doctors.entity.Doctor;
import chmnu.search_doctors.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DoctorWebController {
    private final DoctorService doctorService;

    public DoctorWebController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String searchDoctors(@RequestParam(required = false) String specialization,
                                @RequestParam(required = false) String city, Model model) {
        List<Doctor> doctors = doctorService.findDoctors(specialization, city);
        model.addAttribute("doctors", doctors);
        return "doctor-search";
    }
}
