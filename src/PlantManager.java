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


}
