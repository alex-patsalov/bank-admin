package hw9;

public class MainApp {

    static String[] fatherHabits = {"study", "office", "shopping", "study", "office", "work", "relax"};

    public static void main(String[] args) {
        FamilyController FC = new FamilyController();
        Woman woman1 = new Woman("Jane", "Ostin", "21/06/1995");
        Man man1 = new Man("Johnathan", "Kings", "21/06/1995");
        Family family1 = FC.createNewFamily(woman1, man1);
        System.out.printf("one family -->> %s \n", FC.getAllFamilies());
        Woman woman2 = new Woman("Kate", "Eliz", "21/06/1995");
        Man man2 = new Man("Myan", "Teng", "21/06/1995");
        Family family2 = FC.createNewFamily(woman2, man2);
        Woman woman3 = new Woman("Aleksia", "Chickens", "21/06/1995");
        Man man3 = new Man("Mike", "Tontik", "21/06/1995");
        Human kid1 = new Human("Baby", "Tontik", "21/06/1995");
        Human kid2 = new Human("Minnie", "Mintik", "21/06/1995");
        Family family3 = FC.createNewFamily(woman3, man3, kid1);
        System.out.printf("two (all) families -->> %s \n", FC.getAllFamilies());
        System.out.printf("How many families are there as for now? - %d \n", FC.countFamilies());
        System.out.print("This is start of display of all families \n");
        FC.displayAllFamilies();
        System.out.print("This is end of display of all families \n");
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
        Woman woman4 = new Woman("Aleksia", "Chickens", "21/06/1995");
        Man man4 = new Man("Mike", "Tontik", "21/06/1995");
        DomesticCat cat = new DomesticCat("lazy");
        Human child4 = new Human("Jynnie", "Newport", "21/06/1995");
        Family family4 = FC.createNewFamily(woman4, man4, child4, cat);
        System.out.printf("Get pets from family #4 --> %s \n", family4.getAllPets());
        FC.addPet(1, new Dog("Charlie"));
        System.out.printf("Checking if dog is added ->> %s\n", family4.getAllPets());
        System.out.printf("New baby --> %s \n", FC.bornChild(family4, "female", "male"));
        FC.deleteAllChildrenOlderThen(0);
        System.out.printf("deleted all kids except for the newly-born %s\n", FC.getAllFamilies());
        System.out.printf("describeAge in action -->> %s",child4.describeAge());
    }
}
