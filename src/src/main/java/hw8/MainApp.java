package hw8;

public class MainApp {

    static String[] fatherHabits = {"study", "office", "shopping", "study", "office", "work", "relax"};

    public static void main(String[] args) {
        FamilyController FC = new FamilyController();
        Woman woman1 = new Woman("Jane", "Ostin", 1965);
        Man man1 = new Man("Johnathan", "Kings", 1955);
        Family family1 = FC.createNewFamily(woman1, man1);
        System.out.printf("one family -->> %s \n", FC.getAllFamilies());
        Woman woman2 = new Woman("Kate", "Eliz", 1880);
        Man man2 = new Man("Myan", "Teng", 1870);
        Family family2 = FC.createNewFamily(woman2, man2);
        Woman woman3 = new Woman("Aleksia", "Chickens", 1978);
        Man man3 = new Man("Mike", "Tontik", 1960);
        Human kid1 = new Human("Baby", "Tontik", 2005);
        Human kid2 = new Human("Minnie", "Mintik", 2008);
        Family family3 = FC.createNewFamily(woman3, man3, kid1);
        System.out.printf("two (all) families -->> %s \n", FC.getAllFamilies());
        System.out.printf("How many families are there as for now? - %d \n", FC.countFamilies());
        System.out.printf("This is start of display of all families \n");
        FC.displayAllFamilies();
        System.out.printf("This is end of display of all families \n");
        System.out.printf("Families bigger than 2 %s \n", FC.getFamiliesBiggerThan(2));
        System.out.printf("Families less than 3 %s \n", FC.getFamiliesLessThan(3));
        System.out.printf("How many families have 1 kid? --> %d \n", FC.countFamiliesWithMemberNumber(3));
        System.out.printf("How many families have 0 kids? --> %d \n", FC.countFamiliesWithMemberNumber(2));
        FC.deleteFamilyByIndex(0);
        System.out.printf("Double-check if the family #1 was deleted -> %s \n", FC.getAllFamilies());
        Family family11 = FC.createNewFamily(woman1, man1);
        Family family111 = FC.adoptChild(family11, kid2);
        System.out.printf("Double-check if the family #1 was created again and kid is adopted -> %s \n", FC.getAllFamilies());
        System.out.printf("Get family by index --> %s \n", FC.getFamilyByIndex(2));
        Woman woman4 = new Woman("Aleksia", "Chickens", 1978);
        Man man4 = new Man("Mike", "Tontik", 1960);
        DomesticCat cat = new DomesticCat("lazy");
        Human child4 = new Human("Jynnie", "Newport", 2004);
        Family family4 = FC.createNewFamily(woman4, man4, child4, cat);
        System.out.printf("Get pets from family #4 --> %s \n", family4.getAllPets());
        FC.addPet(1, new Dog("Charlie"));
        System.out.printf("Checking if dog is added ->> %s\n", family4.getAllPets());
        System.out.printf("New baby --> %s \n", FC.bornChild(family4, "female", "male"));
        FC.deleteAllChildrenOlderThen(5);
        System.out.printf("All kids deleted, should be only one --%s", FC.getAllFamilies());

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
//        Woman mother2 = new Woman("Jolie", "Stend", 1986);
//        Man father2 = new Man("Jack", "Drama", 1978);
//        Dog pet2 = new Dog("smarty", 2, 70, "trick");
//        pet2.addHabit("play");
//        pet2.deleteHabit("play");
//        Human child2 = new Human("Alex", "Holland", 2004, pet2, 50);
//        Family family2 = new Family(mother2, father2, child2, pet2);
//        System.out.printf("this is second family \n%s \n===\n", family2.toString());
//        mother2.greetPet(pet2);
//        mother2.doMakeUp();
//        father2.doRepair();
//        pet2.respond();
//        pet2.eat();
//        pet2.foul();
//        child2.feedPet(pet2);
//        child2.greetPet(pet2);
//        child2.describePet(pet2);
//        System.out.println("adding second pet \n");
//        family2.addPet(new Dog("Charlie", 21, 10,"sleep"));
//        System.out.printf("two pets in family %s \n", family2.getAllPets());
//        System.out.println("adding a child \n");
//        family2.addChild(new Human("Barbie", "Girl", 2008, pet2, 10));
//        System.out.printf("this is second family with two kids \n %s \n===\n", family2.toString());
//        System.out.printf("There are %d people in the second family \n", family2.countFamily(family2));
//        System.out.printf("There are pets in the second family %s\n", family2.getAllPets());
//        for (int i = 0; i < DayOfWeek.values().length; i++) {
//            father2.addSchedule(DayOfWeek.values()[i], fatherHabits[i]);
//        }
//        System.out.printf("father schedule-->%s \n", father2.getSchedule());
//        family2.deleteChild(child2);
//        System.out.println("deleting a child...");
//        System.out.printf("this is second family with one kids \n %s \n===\n", family2.toString());
//        for (int i = 0; i < 40000; i++) {
//            Human mother3 = new Human("Tania", "Watson", 1970);
//            Human father3 = new Human("Vasyl", "Black", 1960);
//            Pet pet3 = new Fish("Jujka", 2, 60, new String[]{"eat", "sleep"});
//            Human child3 = new Human("Sergii", "Hey", 2004);
//            Family family3 = new Family(mother3, father3, child3, pet3);
//        }
    }
}
