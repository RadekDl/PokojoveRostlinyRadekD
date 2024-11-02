import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PlantManager {
    private List<Plant> plantList = new ArrayList<>();

    public List<Plant> getPlantList() {
        return plantList;
    }

    //přidání nové rostliny
    public void addPlant(Plant plant){
        plantList.add(plant);
    }
    //získání květiny dle indexu
    public  Plant getPlantIndex(int index){
        return  plantList.get(index);
    }
    //smazání rostliny dle indexu
    public void plantListRemoveIndex(int index){
        plantList.remove(index);
    }
    //kopírování listu
    public   List<Plant> copyOfPlantList(){
         List<Plant> copyOfPlantlist = new ArrayList<>(plantList);
        return copyOfPlantlist;
    }
    // výpis rostlin k zalití
    public void plantForWatering() throws PlantException {
        for (int i = 0; i< plantList.size(); i++){
            if (LocalDate.now().isAfter(plantList.get(i).getWatering().plusDays(plantList.get(i).
                    getFrequenceOfWatering())))
            System.out.println("rostlinu "+ getPlantIndex(i).getName()+" je potřeba zalít. ");

        }

    }
    //seřazení rostlin výchozí dle jména a podle poslední zálivky
    public void sortingNameAndWatering() {
        // Seřazení plantList
        plantList.sort(Comparator.comparing(Plant::getName).thenComparing(Plant::getWatering));
        // Výpis rostlin na obrazovku
        for (Plant plant : plantList) {
            System.out.println(plant);
        }
        System.out.println("\n");
    }
    //seřazení rostlin podle poslední zálivky
    public void sortingWatering(){
        plantList.sort(Comparator.comparing(Plant::getWatering));
        //výpis seřazených rostlin na obrazovku
            plantList.forEach(System.out::println);
        }

    //načtení souboru
    public void readingFile(String nameFile) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(nameFile)))) {

            int lineNumber = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                lineNumber++;
                System.out.println(Plant.parse(line,lineNumber)); // výpis řádků souboru
            }

        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor "+nameFile+" nebyl nalezen! \n"+ e.getLocalizedMessage());

        }
    }
}
