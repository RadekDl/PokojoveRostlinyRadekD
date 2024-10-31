import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlantManager {
    private List<Plant> plantList = new ArrayList<>();

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
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

    public void sort(){
        plantList.sort(null);
//    //plantList.sort(Comparator.comparing(Plant::getName));
//    for (int i = 0; i < plantList.size(); i++) {
//        System.out.println("výpis po seřazení "+getPlantList().get(i).getName());

    }
    public void sort(Comparator<Plant>comparator){
        plantList.sort(comparator);
    }

}
