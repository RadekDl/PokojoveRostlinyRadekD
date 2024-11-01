import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {


            PlantManager plantManager = new PlantManager();
            plantManager.addPlant(new Plant("Růže", " ",LocalDate.of(2024, 10, 19),LocalDate.of(2024, 10, 19), 7));
            plantManager.addPlant(new Plant("Tulipán"));
            plantManager.addPlant(new Plant("Mrkev"));

            Plant plant = new Plant("Modřín");
            plant.getWateringInfo();
            System.out.println(plant.getWateringInfo());
            plantManager.plantForWatering();



//            plantManager.copyOfPlantList();
            System.out.println("výpis z manažeru "+plantManager.getPlantList().get(1).getWateringInfo()+"\n");

            plantManager.sorting();



        } catch (Exception e) {
           System.err.println(e.getMessage());


        }
    }
}