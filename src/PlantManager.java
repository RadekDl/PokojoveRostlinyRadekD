import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlantManager {
    private List<Plant> plantList = new ArrayList<>();

    //přidání nové rostliny
    public void addPlant(Plant plant){
        plantList.add(plant);
    }
    //získání květiny dle indexu
    public Plant getPlant(int index){
        return plantList.get(index);
    }
    //smazání rostliny dle indexu
    public void plantList(int index){
        plantList.remove(index);
    }
    //kopírování listu
    public  List<Plant> getCopyPlantList(){
         List<Plant> copyOfList = new ArrayList<>(plantList);
         return copyOfList;
    }
    // výpis rostlin k zalití
    public void plantForWatering() throws PlantException {
        for (int i = 0; i< plantList.size(); i++){
            if (LocalDate.now().isAfter(plantList.get(i).getWatering().plusDays(plantList.get(i).getFrequenceOfWatering())))
            System.out.println("rostlinu "+getPlant(i).getName()+" je potřeba zalít. ");

        }

    }

}
