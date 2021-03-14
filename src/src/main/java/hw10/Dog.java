package hw10;

public class Dog extends Pet implements AbleToFoul {
    private Species species;
    {
        super.setSpecies(Species.Dog);
    }
    @Override
    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился! \n", this.getNickname());
    }
    public void foul() {
        System.out.print("Нужно хорошо загавкать следы \n");
    }
    public Dog(String nickname) {
        super(nickname);
    }
    public Dog(String nickname, int age, int trickLevel, String habit) {
        super(nickname, age, trickLevel, habit);
    }
}
