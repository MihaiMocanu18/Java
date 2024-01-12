package com.example.vaccinationservice.service;

import com.example.vaccinationservice.model.Vaccinare;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class VaccinationService {

    private List<Vaccinare> vaccinationList = new ArrayList<>();

    public Vaccinare getVaccinationByColumn(String columnName, String searchValue) {
        try (CSVParser csvParser = new CSVParser(new FileReader("country_vaccinations.csv"), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord csvRecord : csvParser) {
                String columnValue = csvRecord.get(columnName);
                if (columnValue.equals(searchValue)) {
                    Vaccinare vaccinare = new Vaccinare();
                    vaccinare.setCountry(csvRecord.get("country"));
                    vaccinare.setIsoCode(csvRecord.get("iso_code"));
                    return vaccinare;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addVaccinations(List<Vaccinare> vaccinations) {
        vaccinationList.addAll(vaccinations);
    }

    public void deleteVaccinationByColumn(String columnName, String searchValue) {
        Iterator<Vaccinare> iterator = vaccinationList.iterator();
        while (iterator.hasNext()) {
            Vaccinare vaccinare = iterator.next();
            if (searchValue.equals(vaccinare.getCountry())) {
                iterator.remove();
            }
        }
    }

    public void updateVaccinationByColumn(String columnName, String searchValue, String newColumnValue) {
        for (Vaccinare vaccinare : vaccinationList) {
            if (searchValue.equals(vaccinare.getCountry())) {
                vaccinare.setCountry(newColumnValue);
            }
        }
    }
}