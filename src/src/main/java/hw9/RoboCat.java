package hw9;

public class RoboCat extends Pet {
    private Species species;
    {
        super.setSpecies(Species.RoboCat);
    }
    @Override
    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился! \n", this.getNickname());
    }
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
