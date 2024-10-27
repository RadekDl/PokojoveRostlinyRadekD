import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {


            PlantManager plantManager = new PlantManager();
            plantManager.addPlant(new Plant("Růže", " ",
                    LocalDate.of(2024, 10, 19),
                    LocalDate.of(2024, 10, 21), 7));
            plantManager.addPlant(new Plant("tulipán"));

            plantManager.plantForWatering();
            System.out.println(plantManager.getPlant(0).getName());

        } catch (Exception e) {
           System.err.println(e.getMessage());
        }

    }
}