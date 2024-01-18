import pachet.Vaccinare;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CititorCSV implements Runnable {
    private String caleFisierCSV;
    private List<Vaccinare> listaVaccinari;

    public CititorCSV(String caleFisierCSV) {
        this.caleFisierCSV = caleFisierCSV;
        this.listaVaccinari = new ArrayList<>();
    }

    @Override
    public void run() {
        citesteDateCSV();
    }

    public List<Vaccinare> getListaVaccinari() {
        return listaVaccinari;
    }

    private void citesteDateCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(caleFisierCSV))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] dateVaccinare = linie.split(",");
                Vaccinare vaccinare = new Vaccinare();
                vaccinare.setCountry(dateVaccinare[0]);
                vaccinare.setIsoCode(dateVaccinare[1]);
                listaVaccinari.add(vaccinare);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String caleFisierCSV = "country_vaccinations.csv";

        CititorCSV cititorCSV = new CititorCSV(caleFisierCSV);

        Thread threadCititor = new Thread(cititorCSV);

        threadCititor.start();

        try {
            threadCititor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Vaccinare> listaVaccinari = cititorCSV.getListaVaccinari();

        Collections.sort(listaVaccinari);

        for (Vaccinare vaccinare : listaVaccinari) {
            System.out.println(vaccinare);
        }
    }
}