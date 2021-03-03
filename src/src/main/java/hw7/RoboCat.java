package hw7;

public class RoboCat extends Pet {
    private final Species species = Species.UNKNOWN;
    @Override
    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился! \n", this.getNickname());
    }
    public Species getSpecies(){return this.species;}

    @Override
    public void foul() {
        System.out.print("А я шкодничать не умею \n");
    }
    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, String habit) {
        super(nickname, age, trickLevel, habit);
    }
}
