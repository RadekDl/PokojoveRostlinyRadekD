import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {


            PlantManager plantManager = new PlantManager();
//            plantManager.addPlant(new Plant("Růže", " ",LocalDate.of(2024, 10, 19),LocalDate.of(2024, 11, 19), 7));
//            plantManager.addPlant(new Plant("Tulipán"));
//            plantManager.addPlant(new Plant("Mrkev"));
//
//            Plant plant = new Plant("Modřín");
//            plant.getWateringInfo();
//            System.out.println(plant.getWateringInfo());
//            plantManager.plantForWatering();
//
//
//
////            plantManager.copyOfPlantList();
//            System.out.println("výpis z manažeru "+plantManager.getPlantList().get(1).getWateringInfo()+"\n");
//
//            plantManager.sortingNameAndWatering();
//            plantManager.sortingWatering();
//            plantManager.readingFile("kvetiny-spatne-datum.txt");
            System.out.println("\n");
            plantManager.readingFile("kvetiny-spatne-frekvence.txt");





        } catch (Exception e) {
           System.err.println(e.getMessage());


        }
    }
}