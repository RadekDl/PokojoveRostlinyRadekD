import java.io.*;
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
    public  Plant getPlant(int index){
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
                    getFrequencyOfWatering())));
            System.out.println("rostlinu "+ getPlant(i).getName()+" je potřeba zalít. ");

        }

    }
    //seřazení rostlin výchozí dle jména a podle poslední zálivky
    public void sortingNameAndWatering() throws PlantException {
        // Seřazení plantList
        plantList.sort(Comparator.comparing(Plant::getName).thenComparing(Plant::getWatering));
    }

    //seřazení rostlin podle poslední zálivky
    public void sortingWatering(){
        plantList.sort(Comparator.comparing(Plant::getWatering));
    }
    //výpis rostlin ze seznamu
    public void listing() {
        for (Plant plant : plantList) {
            System.out.println(plant);
        }
    }

    //načtení souboru a uložení do seznamu
    public void loadingAndSaving(String nameFile) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(nameFile)))) {

            int lineNumber = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                lineNumber++;
                System.out.println(Plant.parse(line,lineNumber));// výpis řádků souboru
                plantList.add(Plant.parse(line,lineNumber)); // uložení do seznamu
            }

        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor "+nameFile+" nebyl nalezen! \n"+ e.getLocalizedMessage());

        }
    }
    //vytvoření souboru
    public void fileCreation(String nameFile, String TABULATOR) throws PlantException {
        //tab = "\t";
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nameFile)))){
            for (Plant plant: plantList){
                writer.println(plant.toTransfer(TABULATOR));

            }

        }catch (IOException e){
            throw new PlantException("Do souboru nejde zapisovat "+ e.getLocalizedMessage());
        }
    }
    //načtení souboru
    public void readingFile(String nameFile) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(nameFile)))) {

            int lineNumber = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                lineNumber++;
                System.out.println(Plant.parse(line,lineNumber));// výpis řádků souboru
            }

        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor "+nameFile+" nebyl nalezen! \n"+ e.getLocalizedMessage());

        }
    }
}
