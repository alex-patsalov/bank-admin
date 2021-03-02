package hw6;

public class DomesticCat extends Pet implements AbleToFoul{
    private final Species species = Species.DomescticCat;
    @Override
    public void respond() {
        System.out.printf("Привет хозяин. Я - %s. Я соскучился! \n", this.getNickname());
    }
    public Species getSpecies(){return this.species;};
    public void foul() {
        System.out.print("Нужно хорошо замяукать следы \n");
    }
    public DomesticCat(String nickname) {
        super(nickname);
    }
    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
}
