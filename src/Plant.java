import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;           //poznámky
    private LocalDate planted;      //datum vysazení
    private LocalDate watering;     //datum poslední zálivky
    private int frequenceOfWatering; //běžná frekvence zálivky ve dnech

    //konstruktor 1
    public Plant(String name, String notes,LocalDate planted, LocalDate watering, int frequenceOfWatering){
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequenceOfWatering = frequenceOfWatering;
    }
    //konstruktor 2
    public Plant(String name,int frequenceOfWatering){
        this(name," ", LocalDate.now(),LocalDate.now(),frequenceOfWatering);
    }
    //konstruktor 3
    public Plant(String name){
        this(name," ",LocalDate.now(),LocalDate.now(),7);
    }
    //metody


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

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequenceOfWatering() {
        return frequenceOfWatering;
    }

    public void setFrequenceOfWatering(int frequenceOfWatering) {
        this.frequenceOfWatering = frequenceOfWatering;
    }
    //úkol 2
    //výpis info o jméně rostliny, poslední zálivce a doporučené další zálivce
    public String getWateringInfo(){
        String listing = "jméno květiny "+name+" datum poslední zálivky "+watering+
                "doporučená další zálivka je "+watering + 7;
        return listing;
    }
    //nastavení zálivky na dnešní den
    public LocalDate doWateringNow(){
        setWatering(LocalDate.now());
        return watering;
    }
}
