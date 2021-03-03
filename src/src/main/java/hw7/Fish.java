package hw7;

public class Fish extends Pet {
    private final Species species = Species.Fish;

    @Override
    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился! \n", this.getNickname());
    }
    public Species getSpecies(){return this.species;};
    public void foul() {
        System.out.print("Нужно хорошо заплавать следы \n");
    }
    public Fish(String nickname) {
        super(nickname);
    }
    public Fish(String nickname, int age, int trickLevel, String habit) {
        super(nickname, age, trickLevel, habit);
    }
}
