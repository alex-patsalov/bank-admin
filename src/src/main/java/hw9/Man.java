package hw9;

public final class Man extends Human {
    private Family family;
    public Man(String name, String surname, int yearOfBirth) {
        super(name, surname, yearOfBirth);
    }

    public Man(String name, String surname, int yearOfBirth, Pet pet, int iq) {
        super(name, surname, yearOfBirth, pet, iq);
    }
    public void greetPet(Pet pet){
        System.out.printf("Привет %s, я твой хозяин \n", this.family.getPet(pet));
    }
    public void setFamily(Family family){
        this.family = family;
    }
    public void doRepair(){
        System.out.println("Она снова попала в аварию!!");
    }
}
