package hw9;

public final class Woman extends Human {
    private Family family;
    public Woman(String name, String surname, String DOB) {
        super(name, surname, DOB);
    }

    public Woman(String name, String surname, String DOB, Pet pet, int iq) {
        super(name, surname, DOB, pet, iq);
    }
    public void greetPet(Pet pet){
        System.out.printf("Привет %s, я твоя хозяйка \n", this.family.getPet(pet));
    }
    public void setFamily(Family family){
        this.family = family;
    }
    public void doMakeUp(){
        System.out.println("Интересно накрашусь ли я за 2 часа?");
    }
}
