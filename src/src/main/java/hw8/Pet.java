package hw8;

import java.util.HashSet;
import java.util.Set;

public abstract class Pet {
    private String nickname;
    private int age;
    private int trickLevel; // 0...100 //
    private final Set<String> habits = new HashSet<>();
    private Species species = Species.UNKNOWN;

    public void eat() {
        System.out.print("Я кушаю! \n");
    }
    public abstract void respond();
    public Species getSpecies(){return this.species;}
    public void setSpecies(Species species){this.species = species;}
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, tricklevel=%d, habits=%s}", getSpecies(), this.nickname, this.age, this.trickLevel, this.habits);
    }
    public Pet(String nickname) {
        this.nickname = nickname;
    }
    public Pet(String nickname, int age, int trickLevel, String habit) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits.add(habit);
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
//    public abstract Species getSpecies();
    public Set<String> getHabits(){return this.habits;}
    public void addHabit(String habit){
        this.habits.add(habit);
    }
    public boolean deleteHabit(String habit){return this.habits.contains(habit) && this.habits.remove(habit);}
    public abstract void foul();
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Pet that = (Pet) obj;

        return this.nickname.equals(that.nickname);
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