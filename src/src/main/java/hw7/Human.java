package hw7;

import java.util.HashMap;
import java.util.Map;

public class Human {

    private String name;
    private String surname;
    private int yearOfBirth;
    private int iq; // 0 ... 100 //
    private Map<DayOfWeek, String> schedule = new HashMap<>();
    private Family family;

    public void greetPet(Pet pet){
        System.out.printf("Привет %s \n", this.family.getPet(pet));
    }
    public void feedPet(Pet pet){
        System.out.printf("%s иди кушать \n", this.family.getPetName(pet));
    }
    public void describePet(Pet pet){
        String trickLevel;
        trickLevel = this.family.getPetTrickLevel(pet) > 50 ? "очень хитрый" : "почти не хитрый";
        System.out.printf("У меня есть %s, ему %d, он %s \n", this.family.getPetSpecies(pet), this.family.getPetAge(pet), trickLevel);
    }
    public String toString(){
        return String.format("%s{name='%s', surname='%s', year='%d', iq='%d', habits=%s}", this.getClass().getSimpleName(), this.name, this.surname, this.yearOfBirth, this.iq, this.schedule);
    }
    public Human(String name, String surname, int yearOfBirth){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }
    public Human(String name, String surname, int yearOfBirth, Pet pet, int iq){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.iq = iq;
    }
    public String getName(){return this.name;}
    public String setName(String newName){return this.name = newName;}
    public String getSurname(){return this.surname;}
    public String setSurname(String newSurname){return this.surname = newSurname;}
    public int getYearOfBirth(){return this.yearOfBirth;}
    public int setYearOfBirth(int newYear){return this.yearOfBirth = newYear;}
    public String getMother(){return this.family.getMother();}
    public Human setMother(Woman mother){return this.family.setMother(mother);}
    public String getFather(){return this.family.getFather();}
    public Human setFather(Man father){return this.family.setFather(father);}
    public String getFamily(){return this.family.toString();}
    public void setFamily(Family family){
        this.family = family;
    }
    public void addSchedule(DayOfWeek day, String habit){
        this.schedule.put(day, habit);
    }
    public Map<DayOfWeek, String> getSchedule(){return this.schedule;}
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Human that = (Human) obj;

        return this.name.equals(that.name) && this.surname.equals(that.surname);
    }
    @Override
    public int hashCode(){
        int code = 11;
        int random = 7;
        code = random*code + this.yearOfBirth;
        return code;
    }
    protected void finalize(){
        System.out.printf("This is what've been deleted -->\n-->> %s\n", this.toString());
    }
}
