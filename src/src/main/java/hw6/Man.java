package hw6;

public final class Man extends Human{
    public Man(String name, String surname, int yearOfBirth) {
        super(name, surname, yearOfBirth);
    }

    public Man(String name, String surname, int yearOfBirth, Pet pet, int iq, String[][] schedule) {
        super(name, surname, yearOfBirth, pet, iq, schedule);
    }
    public void greetPet(){
        System.out.printf("Привет %s \n", this.fagetPet());
    }
}
