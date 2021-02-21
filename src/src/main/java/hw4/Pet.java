package hw4;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel; // 0...100 //
    private String[] habits;

    public void eat(){
        System.out.print("Я кушаю!");
    }

    public void respond(){
        System.out.printf("Привет хозяин. Я - %s. Я соскучился!", this.nickname);
    }

    public void foul(){
        System.out.print("Нужно хорошо замести следы");
    }
}
