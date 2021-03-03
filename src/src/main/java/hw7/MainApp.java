package hw7;

public class MainApp {

    static String[] fatherHabits = {"study", "office", "shopping", "study", "office", "work", "relax"};
    public static void main(String[] args) {

//        Woman mother1 = new Woman("Jane", "Watson", 1970);
//        Man father1 = new Man("Joe", "Black", 1960);
//        Pet pet1 = new Fish("Sam", 2, 60, new String[]{"eat", "sleep"});
//        Human child1 = new Human("Alex", "Holland", 2004);
//        Family family1 = new Family(mother1, father1, child1, pet1);
//        family1.addChild(new Human("Alissa", "Boiner", 1994));
//        family1.addChild(new Human("Mike", "Stewart", 1990));
//        System.out.printf("this is first family \n%s \n===\n", family1.toString());
//        mother1.greetPet();
//        mother1.doMakeUp();
//        father1.doRepair();
        Woman mother2 = new Woman("Jolie", "Stend", 1986);
        Man father2 = new Man("Jack", "Drama", 1978);
        Dog pet2 = new Dog("smarty", 2, 70, "trick");
        pet2.addHabit("play");
        pet2.deleteHabit("play");
        Human child2 = new Human("Alex", "Holland", 2004, pet2, 50);
        Family family2 = new Family(mother2, father2, child2, pet2);
        System.out.printf("this is second family \n%s \n===\n", family2.toString());
        mother2.greetPet(pet2);
        mother2.doMakeUp();
        father2.doRepair();
        pet2.respond();
        pet2.eat();
        pet2.foul();
        child2.feedPet(pet2);
        child2.greetPet(pet2);
        child2.describePet(pet2);
        System.out.println("adding second pet \n");
        family2.addPet(new Dog("Charlie", 21, 10,"sleep"));
        System.out.printf("two pets in family %s \n", family2.getAllPets());
        System.out.println("adding a child \n");
        family2.addChild(new Human("Barbie", "Girl", 2008, pet2, 10));
        System.out.printf("this is second family with two kids \n %s \n===\n", family2.toString());
        System.out.printf("There are %d people in the second family \n", family2.countFamily(family2));
        System.out.printf("There are pets in the second family %s\n", family2.getAllPets());
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            father2.addSchedule(DayOfWeek.values()[i], fatherHabits[i]);
        }
        System.out.printf("father schedule-->%s \n", father2.getSchedule());
        family2.deleteChild(child2);
        System.out.println("deleting a child...");
        System.out.printf("this is second family with one kids \n %s \n===\n", family2.toString());
//        for (int i = 0; i < 40000; i++) {
//            Human mother3 = new Human("Tania", "Watson", 1970);
//            Human father3 = new Human("Vasyl", "Black", 1960);
//            Pet pet3 = new Fish("Jujka", 2, 60, new String[]{"eat", "sleep"});
//            Human child3 = new Human("Sergii", "Hey", 2004);
//            Family family3 = new Family(mother3, father3, child3, pet3);
//        }
    }
}
