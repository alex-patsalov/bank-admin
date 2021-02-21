package hw4;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel; // 0...100 //
    private String[] habits;

    public void eat() {
        System.out.print("Я кушаю!");
    }

    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился!", this.nickname);
    }

    public void foul() {
        System.out.print("Нужно хорошо замести следы");
    }

    public String toString() {
        return String.format("%s{nickname='%s', age=%d, tricklevel=%d, habits=%s", this.species, this.nickname, this.age, this.trickLevel, Arrays.toString(this.habits));
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {

    }

    public String getNickname(){
        return this.nickname;
    }

    public String setNickName(String newNickName){return this.nickname = newNickName;}

    public int getTrickLevel(){
        return this.trickLevel;
    }

    public int setTrickLevel(int newTrickLevel){
        return this.trickLevel = newTrickLevel;
    }

    public int getAge(){return this.age;}

    public int setAge(int newAge){
        return this.age = newAge;
    }

    public String getSpecies(){return this.species;}
}
