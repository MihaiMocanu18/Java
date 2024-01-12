package com.example.vaccinationservice.model;

public class Vaccinare {
    private String country;
    private String isoCode;
    private String date;
    private long totalVaccinations;
    private long peopleVaccinated;
    private long peopleFullyVaccinated;
    private long dailyVaccinationsRaw;
    private long dailyVaccinations;
    private double totalVaccinationsPerHundred;
    private double peopleVaccinatedPerHundred;
    private double peopleFullyVaccinatedPerHundred;
    private double dailyVaccinationsPerMillion;
    private String vaccines;
    private String sourceName;
    private String sourceWebsite;

    public Vaccinare() {
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTotalVaccinations() {
        return totalVaccinations;
    }

    public void setTotalVaccinations(long totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }


    @Override
    public String toString() {
        return "Country: " + country + ", Total Vaccinations: " + totalVaccinations +
                ", People Vaccinated: " + peopleVaccinated + ", People Fully Vaccinated: " + peopleFullyVaccinated +
                ", Date: " + date;
    }
}