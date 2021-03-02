package hw6;

import java.util.Arrays;

public class MainApp {

    static String[] fatherHabits = {"study", "office", "shopping", "study", "office", "work", "relax"};
    public static void main(String[] args) {

        Woman mother1 = new Woman("Jane", "Watson", 1970);
        Man father1 = new Man("Joe", "Black", 1960);
        Pet pet1 = new Fish("Sam", 2, 60, new String[]{"eat", "sleep"});
        Human child1 = new Human("Alex", "Holland", 2004);
        Family family1 = new Family(mother1, father1, child1, pet1);
        family1.addChild(new Human("Alissa", "Boiner", 1994));
        family1.addChild(new Human("Mike", "Stewart", 1990));
        System.out.printf("this is first family \n%s \n===\n", family1.toString());
        mother1.greetPet();
        Woman mother2 = new Woman("Jolie", "Stend", 1986);
        Man father2 = new Man("Jack", "Drama", 1978);
        Pet pet2 = new RoboCat("smarty", 2, 70, new String[]{"trick", "eat"});
        Human child2 = new Human("Alex", "Holland", 2004, pet2, 50, null);
        Family family2 = new Family(mother2, father2, child2, pet2);
        System.out.printf("this is second family \n%s \n===\n", family2.toString());
        System.out.printf("who is your owner? %s \n", pet2.getOwner());
        pet2.respond();
        pet2.eat();
        pet2.foul();
        child2.feedPet();
        child2.greetPet();
        child2.describePet();
        System.out.println("adding a child");
        family2.addChild(new Human("Barbie", "Girl", 2008, pet2, 10, null));
        System.out.printf("this is second family with two kids \n %s \n===\n", family2.toString());
        System.out.printf("There are %d people in the second family \n", family2.countFamily(family2));
        System.out.printf("This a pet in the second family %s\n", family2.getPet());
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            father1.setSchedule(DayOfWeek.values()[i], fatherHabits[i]);
        }
        System.out.printf("father schedule-->%s \n", Arrays.deepToString(father1.getSchedule()));
//        for (int i = 0; i < 40000; i++) {
//            Human mother3 = new Human("Tania", "Watson", 1970);
//            Human father3 = new Human("Vasyl", "Black", 1960);
//            Pet pet3 = new Fish("Jujka", 2, 60, new String[]{"eat", "sleep"});
//            Human child3 = new Human("Sergii", "Hey", 2004);
//            Family family3 = new Family(mother3, father3, child3, pet3);
//        }
    }
}
