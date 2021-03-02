package hw6;

public class Dog extends Pet implements AbleToFoul{
    private final Species species = Species.Dog;
    @Override
    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился! \n", this.getNickname());
    }
    public Species getSpecies(){return this.species;};
    public void foul() {
        System.out.print("Нужно хорошо загавкать следы \n");
    }
    public Dog(String nickname) {
        super(nickname);
    }
    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
}
