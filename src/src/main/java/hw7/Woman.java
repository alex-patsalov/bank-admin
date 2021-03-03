package hw7;

public final class Woman extends Human {
    private Family family;
    public Woman(String name, String surname, int yearOfBirth) {
        super(name, surname, yearOfBirth);
    }

    public Woman(String name, String surname, int yearOfBirth, Pet pet, int iq, String[][] schedule) {
        super(name, surname, yearOfBirth, pet, iq, schedule);
    }
    public void greetPet(){
        System.out.printf("Привет %s, я твоя хозяйка \n", this.family.getPet());
    }
    public void setFamily(Family family){
        this.family = family;
    }
    public void doMakeUp(){
        System.out.println("Интересно накрашусь ли я за 2 часа?");
    }
}