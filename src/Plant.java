import java.time.DateTimeException;
import java.time.LocalDate;

public class Plant implements Comparable<Plant>{
    private String name;
    private String notes;           //poznámky
    private int frequencyOfWatering; //běžná frekvence zálivky ve dnech
    private LocalDate watering;     //datum poslední zálivky
    private LocalDate planted;      //datum vysazení




    public Plant(String name, String notes,int frequencyOfWatering,LocalDate watering,LocalDate planted ) throws PlantException {
//        if(watering.isBefore(planted)){
//            throw new PlantException("datum zálivky nesmí být před datumem zasazení!");
//        }
        this.name = name;
        this.notes = notes;
        this.setFrequencyOfWatering(frequencyOfWatering);
        this.watering = watering;
        this.setPlanted(planted);


    }

    public Plant(String name,int frequencyOfWatering) throws PlantException {
        this(name," ",frequencyOfWatering,LocalDate.now(),LocalDate.now());
    }

    public Plant(String name) throws PlantException {
        this(name," ",7,LocalDate.now(),LocalDate.now());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) throws PlantException {
        if (planted.isAfter(watering)){
            throw new PlantException("datum zálivky nesmí být před datumem zasazení!");
        }
        this.watering = watering;
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        if (watering.isBefore(planted)){
            throw new PlantException("datum zálivky nesmí být před datumem zasazení!");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() throws PlantException {
        if (frequencyOfWatering <= 0){
            throw new PlantException("hodnota zálivky (frequenceOfWatering) nesmí být menší nebo rovno 0! ");
        }
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0){
           throw new PlantException("hodnota zálivky (frequenceOfWatering) nesmí být menší nebo rovno 0! ");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    //výpis info o jméně rostliny, poslední zálivce a doporučení další zálivky
    public   String getWateringInfo(){
        LocalDate wateringNew;
        wateringNew = watering.plusDays(frequencyOfWatering);
        String listing = "jméno květiny "+name+" datum poslední zálivky "+watering+
                " doporučená další zálivka je "+wateringNew;
        return listing;
    }
    //nastavení zálivky na dnešní den
    public LocalDate doWateringNow() throws PlantException {
        setWatering(LocalDate.now());
        return watering;
    }
    //toSting kvůli řazení

    @Override
    public String toString() {
        return "Květiny {" +
                "jméno = '" + name + '\'' +
                ", notes='" + notes + '\'' +     ", frekvence zalívání po =" + frequencyOfWatering +" dnech "+
                ", zalito =" + watering +
                ", zasazeno =" + planted +
                '}';
    }
    public static Plant parse(String line, int numberLine) throws PlantException {
        int numberItems =5;
        String[] parts = line.split(Main.TABULATOR);
        if(parts.length != numberItems){
            throw new PlantException("špatný počet prvků v řádku "+numberLine+" má být "+numberItems+"\n ale je zde: "+line);
        }
        String name = parts[0].trim();
        String notes = parts[1].trim();
        try {
            int frequencyOfWatering = Integer.parseInt(parts[2].trim());
            LocalDate watering = LocalDate.parse(parts[3].trim());
            LocalDate planted = LocalDate.parse(parts[4].trim());

            return new Plant(name, notes, frequencyOfWatering, watering, planted);

        } catch (DateTimeException | NumberFormatException e) {
            throw new PlantException("soubor má chybný formát v řádcích \n"+ e);
        }
    }

    public String toTransfer(String Tabulator) {

       return name+ Tabulator + notes + Tabulator + frequencyOfWatering + Tabulator + watering + Tabulator + planted;

    }

    @Override
    public int compareTo(Plant o) {
        return name.compareTo(o.name);
    }
}

