import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;           //poznámky
    private LocalDate planted;      //datum vysazení
    private LocalDate watering;     //datum poslední zálivky
    private int frequenceOfWatering; //běžná frekvence zálivky ve dnech

    //konstruktor 1
    public Plant(String name, String notes,LocalDate planted, LocalDate watering, int frequenceOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequenceOfWatering = frequenceOfWatering;
    }
    //konstruktor 2
    public Plant(String name,int frequenceOfWatering) throws PlantException {
        this(name," ", LocalDate.now(),LocalDate.now(),frequenceOfWatering);
    }
    //konstruktor 3
    public Plant(String name) throws PlantException {
        this(name," ",LocalDate.now(),LocalDate.now(),7);
    }
    //metody


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
       // return name;
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

    public void setPlanted(LocalDate planted) {
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

    public int getFrequenceOfWatering() throws PlantException {
        if (frequenceOfWatering <= 0){
            throw new PlantException("hodnota zálivky (frequenceOfWatering) nesmí být menší nebo rovno 0! ");
        }
        return frequenceOfWatering;
    }

    public void setFrequenceOfWatering(int frequenceOfWatering) throws PlantException {
        if (frequenceOfWatering <= 0){
           throw new PlantException("hodnota zálivky (frequenceOfWatering) nesmí být menší nebo rovno 0! ");
        }
        this.frequenceOfWatering = frequenceOfWatering;
    }
    //úkol 2
    //výpis info o jméně rostliny, poslední zálivce a doporučení další zálivky
    public   String getWateringInfo(){
        LocalDate wateringNew;
        wateringNew = watering.plusDays(frequenceOfWatering);
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
        return "květiny {" +
                "jméno = '" + name + '\'' +
                ", notes = '" + notes + '\'' +
                ", zasazeno = " + planted +
                ", zalito = " + watering +
                ", frekvence zalívání po " + frequenceOfWatering +" dnech "+
                '}';
    }
}
