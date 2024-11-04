import java.time.LocalDate;

public class Main {
    public static final String TABULATOR = "\t";
    private static int indexTulipan = 1;

    public static void main(String[] args) {

        try {


            PlantManager plantManager = new PlantManager();

//          plantManager.readingFile("kvetiny-spatne-datum.txt");
            System.out.println("\n");

//          plantManager.readingFile("kvetiny-spatne-frekvence.txt");
            plantManager.readingFile("kvetiny.txt");
            System.out.println("\n");
            plantManager.getPlantIndex(0).setFrequencyOfWatering(3);
            plantManager.getPlantIndex(1).setFrequencyOfWatering(4);
            plantManager.getPlantIndex(2).setFrequencyOfWatering(365);

            //výpis o zálivce
            plantManager.plantForWatering();
            System.out.println("\n");

            //přidání nové květiny
            plantManager.getPlantList().add(new Plant("Kopretina",5));

            System.out.println("počet květin v seznamu je: "+ plantManager.getPlantList().size()+"\n");
            //nových 10 rostlin
            for ( int i = 0; i < 10; i++) {
                plantManager.getPlantList().add(new Plant("Tulipán "+indexTulipan++," Tulipán na prodej ",
                        14, LocalDate.now(),LocalDate.now()));
            }
            System.out.println("počet květin v seznamu po přidání nových květin je: "+ plantManager.getPlantList().size()+"\n");

            //Smazání rostliny na třetí pozici
            plantManager.getPlantList().remove(2);

//            // výpis rostlin v seznamu
//            for (int i = 0; i < plantManager.getPlantList().size(); i++) {
//
//                    System.out.println("jméno "+plantManager.getPlantList().get(i).getName()+" zápis v notesu "+plantManager.getPlantList().get(i).getNotes()+
//                            " frekvence zálivky je "+plantManager.getPlantList().get(i).getFrequencyOfWatering()+" dnů "+" naposledy zalito v "+plantManager.getPlantList().get(i).getWatering()+
//                            " rostlina byla zasazena "+plantManager.getPlantList().get(i).getPlanted());
//
//
//            }

        } catch (Exception e) {
           System.err.println(e.getMessage());


        }
    }
}