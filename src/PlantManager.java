import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlantManager {
    private List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant){                      //přidání nové rostliny
        plantList.add(plant);
    }
    public Plant getPlant(int index){                       //získání květiny dle indexu
        return plantList.get(index);
    }
    public void plantList(int index){
        plantList.remove(index);
    }
    public  List<Plant> getCopyPlantList(){
         List<Plant> copyOfList = new ArrayList<>(plantList);
         return copyOfList;
    }
    public void plantForWatering() throws PlantException {                         // výpis rostlin k zalití
        for (int i = 0; i< plantList.size(); i++){
            if (LocalDate.now().isAfter(plantList.get(i).getWatering().plusDays(plantList.get(i).getFrequenceOfWatering())))
            System.out.println("rostlinu "+getPlant(i).getName()+" je potřeba zalít. ");

        }

    }

}
