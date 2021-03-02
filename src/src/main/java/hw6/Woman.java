package hw6;

public final class Woman extends Human{
    public Woman(String name, String surname, int yearOfBirth) {
        super(name, surname, yearOfBirth);
    }

    public Woman(String name, String surname, int yearOfBirth, Pet pet, int iq, String[][] schedule) {
        super(name, surname, yearOfBirth, pet, iq, schedule);
    }
}
