package hw4;

public class MainApp {
    public static void main(String[] args) {

        Human mother1 = new Human("Jane", "Watson", 1970);
        Human father1 = new Human("Joe", "Black", 1960);
        Pet pet1 = new Pet("dog", "Sam");
        Human child1 = new Human("Alex", "Holland", 2004);
        Family family1 = new Family(mother1, father1, child1, pet1);
        System.out.printf("this is first family \n%s \n===\n", family1.toString());
        family1.addChild(new Human("Julia", "Che", 1994));
        System.out.printf("this is first family \n%s \n===\n", family1.toString());
    }
}
