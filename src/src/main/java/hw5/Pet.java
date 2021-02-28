package hw5;

import java.util.Arrays;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel; // 0...100 //
    private String[] habits;
    private Human owner;

    public void eat() {
        System.out.print("Я кушаю! \n");
    }
    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился! \n", this.nickname);
    }
    public void foul() {
        System.out.print("Нужно хорошо замести следы \n");
    }
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, tricklevel=%d, habits=%s owner=%s", this.species, this.nickname, this.age, this.trickLevel, Arrays.toString(this.habits), this.owner.getName());
    }
    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public String getOwner(){return this.owner.toString();}
    public Human setOwner(Human owner){return this.owner = owner;}
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
    public Species getSpecies(){return this.species;}
    public Species setSpecies(Species newSpecies){return this.species = newSpecies;}
    public String getHabits(){return Arrays.toString(this.habits);}
    public String[] setHabits(String[] newHabits){return this.habits = newHabits;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Pet that = (Pet) obj;

        return this.species.equals(that.species) && this.nickname.equals(that.nickname);
    }
    public int hashCode(){
        int code = 11;
        int random = 7;
        code = random*code + this.age;
        return code;
    }
    protected void finalize(){
        System.out.printf("This is what've been deleted -->\n-->> %s\n", this.toString());
    }
}