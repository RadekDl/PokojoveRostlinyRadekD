import java.time.LocalDate;
import java.util.Collection;

public class Main {
    public static final String TABULATOR = "\t";
    private static int indexTulipan = 1;

    public static void main(String[] args) {

        try {
            PlantManager plantManager = new PlantManager();

//          plantManager.readingFile("kvetiny-spatne-datum.txt");
            System.out.println("\n");

//          plantManager.readingFile("kvetiny-spatne-frekvence.txt");
            plantManager.loadingAndSaving("kvetiny.txt");
            System.out.println("\n");
            //úprava frekvence zálivky dle souboru kvetiny.txt
            plantManager.getPlant(0).setFrequencyOfWatering(3);
            plantManager.getPlant(1).setFrequencyOfWatering(4);
            plantManager.getPlant(2).setFrequencyOfWatering(365);

            //výpis o zálivce
            System.out.println("výpis o zálivce \n");
            plantManager.plantForWatering();
            System.out.println("\n");

            //přidání nové květiny
            plantManager.getPlantList().add(new Plant("Kopretina","bez poznámky",5,LocalDate.now(),LocalDate.now()));

            System.out.println("počet květin v seznamu je: "+ plantManager.getPlantList().size()+"\n");
            //nových 10 rostlin
             for ( int i = 0; i < 10; i++) {
               plantManager.getPlantList().add(new Plant("Tulipán "+indexTulipan++," Tulipán na prodej ",
                        14, LocalDate.now(),LocalDate.now()));
            }
            System.out.println("počet květin v seznamu po přidání nových květin je: "+ plantManager.getPlantList().size()+"\n");
             plantManager.listing();


            //Smazání rostliny na třetí pozici
            plantManager.getPlantList().remove(2);

            // výpis rostlin v seznamu
            System.out.println("\n výpis po prodání třetí rostliny a přidání 10ti Tulipánů \n");
            for (int i = 0; i < plantManager.getPlantList().size(); i++) {

                    System.out.println("jméno "+plantManager.getPlantList().get(i).getName()+" zápis v notesu "+plantManager.getPlantList().get(i).getNotes()+
                            " frekvence zálivky je "+plantManager.getPlantList().get(i).getFrequencyOfWatering()+" dnů "+" naposledy zalito v "+plantManager.getPlantList().get(i).getWatering()+
                            " rostlina byla zasazena "+plantManager.getPlantList().get(i).getPlanted());

            }
            plantManager.fileCreation("Kvetiny1.txt",TABULATOR);
            System.out.println("\n seřazení podle jména \n");
            plantManager.sortingNameAndWatering();
            plantManager.listing();
            System.out.println("\n seřazení podle zálivky \n");
            plantManager.sortingWatering();
            plantManager.listing();
            System.out.println("\n znovunačtení Kvetiny1.txt \n");
            plantManager.readingFile("Kvetiny1.txt");
            plantManager.getPlantList().sort(Plant::compareTo);
            System.out.println("\nvýpis compareTo\n");
            plantManager.getPlantList().forEach(System.out::println);


        } catch (Exception e) {
           System.err.println(e.getMessage());
        }
    }
}