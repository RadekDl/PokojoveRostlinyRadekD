import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {


            PlantManager plantManager = new PlantManager();
            plantManager.addPlant(new Plant("Růže", " ",
                    LocalDate.of(2024, 10, 19),
                    LocalDate.of(2024, 10, 19), 7));
            plantManager.addPlant(new Plant("Tulipán"));
            plantManager.addPlant(new Plant("mrkev"));

            Plant plant = new Plant("Modřín");
            plant.getWateringInfo();
            System.out.println(plant.getWateringInfo());
            plantManager.plantForWatering();



            plantManager.copyOfPlantList();
            System.out.println(plant.getWateringInfo());
            plantManager.sort();



        } catch (Exception e) {
           System.err.println(e.getMessage());


        }


    }
}