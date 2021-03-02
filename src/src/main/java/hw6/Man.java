package hw6;

public final class Man extends Human{
    private Family family;
    public Man(String name, String surname, int yearOfBirth) {
        super(name, surname, yearOfBirth);
    }

    public Man(String name, String surname, int yearOfBirth, Pet pet, int iq, String[][] schedule) {
        super(name, surname, yearOfBirth, pet, iq, schedule);
    }
    public void greetPet(){
        System.out.printf("Привет %s, я твой хазяин \n", this.family.getPet());
    }
    public void setFamily(Family family){
        this.family = family;
    }
    public void doRepair(){
        System.out.println("Она снова попала в аварию!!");
    }
}
