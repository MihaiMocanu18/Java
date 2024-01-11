package com.example.vaccinationservice.controller;

import com.example.vaccinationservice.model.Vaccinare;
import com.example.vaccinationservice.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @GetMapping("/{columnName}/{searchValue}")
    public Vaccinare getVaccinationByColumn(@PathVariable String columnName, @PathVariable String searchValue) {
        return vaccinationService.getVaccinationByColumn(columnName, searchValue);
    }

    @PostMapping("/add")
    public void addVaccinations(@RequestBody List<Vaccinare> vaccinations) {
        vaccinationService.addVaccinations(vaccinations);
    }

    @DeleteMapping("/{columnName}/{searchValue}")
    public void deleteVaccinationByColumn(@PathVariable String columnName, @PathVariable String searchValue) {
        vaccinationService.deleteVaccinationByColumn(columnName, searchValue);
    }

    @PutMapping("/update/{columnName}/{searchValue}/{newColumnValue}")
    public void updateVaccinationByColumn(@PathVariable String columnName,
                                          @PathVariable String searchValue,
                                          @PathVariable String newColumnValue) {
        vaccinationService.updateVaccinationByColumn(columnName, searchValue, newColumnValue);
    }
}