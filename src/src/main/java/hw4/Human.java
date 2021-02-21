package hw4;

public class Human {

    private String name;
    private String surname;
    private int yearOfBirth;
    private int iq; // 0 ... 100 //
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public void greetPet(){
        System.out.printf("Привет %s", pet.nickname);
    }

    public void describePet(){
        String trickLevel;
        trickLevel = pet.trickLevel > 50 ? "очень хитрый" : "почти не хитрый";
//        if (pet.trickLevel > 50) {
//            trickLevel = "очень хитрый";
//        } else {
//            trickLevel = "почти не хитрый";
//        }
        System.out.printf("У меня есть %s, ему %d, он %s", pet.species, pet.age, trickLevel);
    }

    public String toString(){

//        dog{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}, где dog - вид животного;

    }
}
