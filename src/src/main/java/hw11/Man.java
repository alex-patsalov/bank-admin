package hw11;

public final class Man extends Human {
    private Family family;
    public Man(String name, String surname, String DOB) {
        super(name, surname, DOB);
    }
    public Man(String name, String surname, String DOB, int iq){super(name, surname, DOB, iq);}
    public Man(String name, String surname, String DOB, Pet pet, int iq) {
        super(name, surname, DOB, pet, iq);
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
