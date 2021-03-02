package hw6;

import java.util.Arrays;

public class Human {

    private String name;
    private String surname;
    private int yearOfBirth;
    private int iq; // 0 ... 100 //
    private String[][] schedule = new String[1][2];
    private Family family;

    public void greetPet(){
        System.out.printf("Привет %s \n", this.family.getPet());
    }
    public void feedPet(){
        System.out.printf("%s иди кушать \n", this.family.getPetName());
    }
    public void describePet(){
        String trickLevel;
        trickLevel = this.family.getPetTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый";
        System.out.printf("У меня есть %s, ему %d, он %s \n", this.family.getPetSpecies(), this.family.getPetAge(), trickLevel);
    }
    public String toString(){
        return String.format("%s{name='%s', surname='%s', year='%d', iq='%d', habits=%s}", this.getClass().getSimpleName(), this.name, this.surname, this.yearOfBirth, this.iq, Arrays.deepToString(this.schedule));
    }
    public Human(String name, String surname, int yearOfBirth){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }
    public Human(String name, String surname, int yearOfBirth, Pet pet, int iq, String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.iq = iq;
        this.schedule = schedule;
    }
    public String getName(){return this.name;}
    public String setName(String newName){return this.name = newName;}
    public String getSurname(){return this.surname;}
    public String setSurname(String newSurname){return this.surname = newSurname;}
    public int getYearOfBirth(){return this.yearOfBirth;}
    public int setYearOfBirth(int newYear){return this.yearOfBirth = newYear;}
    public String getMother(){return this.family.getMother();}
    public Human setMother(Human mother){return this.family.setMother(mother);}
    public String getFather(){return this.family.getFather();}
    public Human setFather(Human father){return this.family.setFather(father);}
    public String getFamily(){return this.family.toString();}
    public void setFamily(Family family){
        this.family = family;
    }
    public void setSchedule(DayOfWeek day, String habit){
        String[] dayHabit = new String[]{day.name(), habit};
        String[][] humanSchedule = this.getSchedule();
        String[][] newSchedule;
        for (int i = 0; i < humanSchedule.length; i++) {
            for (int j = 0; j < humanSchedule[i].length; j++) {
                if(humanSchedule[i][j] == null){
                    humanSchedule[i] = dayHabit;
                    this.schedule = humanSchedule;
                    return;
                }
                else if(humanSchedule[i][j] !=null){
                    newSchedule = Arrays.copyOf(humanSchedule, humanSchedule.length + 1);
                    newSchedule[newSchedule.length - 1] = dayHabit;
                    this.schedule = newSchedule;
                    return;
                }
            } break;
        }
    }
    public String[][] getSchedule(){return this.schedule;}
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
