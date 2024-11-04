public class Main {
    public static final String TABULATOR = "\t";


    public static void main(String[] args) {

        try {


            PlantManager plantManager = new PlantManager();

//          plantManager.readingFile("kvetiny-spatne-datum.txt");
            System.out.println("\n");
//          plantManager.readingFile("kvetiny-spatne-frekvence.txt");
            plantManager.readingFile("kvetiny.txt");
            plantManager.plantForWatering();





        } catch (Exception e) {
           System.err.println(e.getMessage());


        }
    }
}