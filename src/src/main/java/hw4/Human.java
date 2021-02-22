package hw4;

import java.util.Arrays;

public class Human {

    private String name;
    private String surname;
    private int yearOfBirth;
    private int iq; // 0 ... 100 //
    private Pet pet;
//    private Human mother;
//    private Human father;
    private String[][] schedule;
    private Family family;

    public void greetPet(){
        System.out.printf("Привет %s", pet.getNickname());
    }
    public void feedPet(){
        System.out.printf("%s иди кушать", pet.getNickname());
    }

    public void describePet(){
        String trickLevel;
        trickLevel = pet.getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый";
//        if (pet.trickLevel > 50) {
//            trickLevel = "очень хитрый";
//        } else {
//            trickLevel = "почти не хитрый";
//        }
        System.out.printf("У меня есть %s, ему %d, он %s", pet.getSpecies(), pet.getAge(), trickLevel);
    }

    public String toString(){
        return String.format("%s{name='%s', surname='%s', year='%d', iq='%d', habits=%s", this.getClass(), this.name, this.surname, this.yearOfBirth, this.iq, Arrays.toString(this.schedule));
    }

    public Human(String name, String surname, int yearOfBirth){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    public Human(String name, String surname, int yearOfBirth, Family family){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.family = family;
//        this.father = father;
//        this.mother = mother;
    }

    public Human(String name, String surname, int yearOfBirth, Family family, Pet pet, int iq, String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
//        this.father = father;
//        this.mother = mother;
        this.family = family;
        this.pet = pet;
        this.iq = iq;
        this.schedule = schedule;
    }

    public String getName(){return this.name;}
    public String setName(String newName){return this.name = newName;}
    public String getSurname(){return this.surname;}
    public String setSurname(String newSurname){return this.surname = newSurname;}
    public int getYearOfBirth(){return this.yearOfBirth;}
    public int setYearOfBirth(int newYear){return this.yearOfBirth = newYear;}
    public String getPet(Pet pet){return pet.toString();}
    public Pet setPet(Pet pet){return this.pet = pet;}
    public String getMother(){return this.family.getMother();}
    public Human setMother(Human mother){return this.family.setMother(mother);}
    public String getFather(){return this.family.getFather();}
    public Human setFather(Human father){return this.family.setFather(father);}
    public String getFamily(Family family){return this.family.toString();}
}
