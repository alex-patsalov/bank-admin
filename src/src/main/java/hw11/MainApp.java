package hw11;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static FamilyController FC = new FamilyController();

    public static void printMainMenu() {
        System.out.print("- 1. Заполнить тестовыми данными (автоматом создать несколько семей и сохранить их в базе)\n" +
                "- 2. Отобразить весь список семей (отображает список всех семей с индексацией, начинающейся с 1)\n" +
                "- 3. Отобразить список семей, где количество людей больше заданного\n" +
                "- 4. Отобразить список семей, где количество людей меньше заданного\n" +
                "- 5. Подсчитать количество семей, где количество членов равно\n" +
                "- 6. Создать новую семью\n" +
                "- 7. Удалить семью по индексу семьи в общем списке\n" +
                "- 8. Редактировать семью по индексу семьи в общем списке \n" +
                "- 9. Удалить всех детей старше возраста (во всех семьях удаляются дети старше указанного возраста - будем считать, что они выросли)\n");
    }

    public static void createFamily() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введи имя матери: ");
        String motherName = sc.nextLine();
        System.out.print("Введи фамилию матери: ");
        String motherSurname = sc.nextLine();
        System.out.print("Введи дату рождения матери: ");
        String dobM = sc.nextLine();
        System.out.print("Введи iq матери: ");
        int iqM = sc.nextInt();
        Woman mother = new Woman(motherName, motherSurname, dobM, iqM);
        String buffer = sc.nextLine();
        System.out.print("Введи имя отца: ");
        String fatherName = sc.nextLine();
        System.out.print("Введи фамилию отца: ");
        String fatherSurname = sc.nextLine();
        System.out.print("Введи дату рождения отца: ");
        String dobF = sc.nextLine();
        System.out.print("Введи iq отца: ");
        int iqF = sc.nextInt();
        Man father = new Man(fatherName, fatherSurname, dobF, iqF);
        FC.createNewFamily(mother, father);
    }
    public static void makeABaby(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введи порядковый номер семьи: ");
        int index = sc.nextInt();
        Family family = FC.getFamilyByIndex(index - 1);
        String buffer = sc.nextLine();
        System.out.print("Какое имя дать мальчику? ");
        String mName = sc.nextLine();
        System.out.print("А девочке? ");
        String fName = sc.nextLine();
//        sc.close();
        FC.bornChild(family,mName,fName);
    }
    public static void adoptChild(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введи номер семьи: ");
        int index = sc.nextInt();
        Family f = FC.getFamilyByIndex(index - 1);
        String buffer = sc.nextLine();
        System.out.print("Введи имя ребенка: ");
        String name = sc.nextLine();
        System.out.print("Введи фамилию ребенка: ");
        String surname = sc.nextLine();
        System.out.print("Введи дату рождения ребенка: ");
        String dob = sc.nextLine();
        System.out.print("Введи iq ребенка: ");
        int iq = sc.nextInt();
        Human kid = new Human(name, surname, dob, iq);
//        sc.close();
        FC.adoptChild(f, kid);
    }

    public static void main(String[] args) {
//        FamilyController FC = new FamilyController();
//        Woman woman1 = new Woman("Jane", "Ostin", "21/06/1995");
//        Man man1 = new Man("Johnathan", "Kings", "21/06/1995");
//        Family family1 = FC.createNewFamily(woman1, man1);
//        System.out.printf("one family -->> %s \n", FC.getAllFamilies());
//        Woman woman2 = new Woman("Kate", "Eliz", "21/06/1995");
//        Man man2 = new Man("Myan", "Teng", "21/06/1995");
//        Family family2 = FC.createNewFamily(woman2, man2);
//        Woman woman3 = new Woman("Aleksia", "Chickens", "21/06/1995");
//        Man man3 = new Man("Mike", "Tontik", "21/06/1995");
//        Human kid1 = new Human("Baby", "Tontik", "21/06/1995");
//        Human kid2 = new Human("Minnie", "Mintik", "21/06/1995");
//        Family family3 = FC.createNewFamily(woman3, man3, kid1);
//        System.out.printf("two (all) families -->> %s \n", FC.getAllFamilies());
//        System.out.printf("How many families are there as for now? - %d \n", FC.countFamilies());
//        System.out.print("This is start of display of all families \n");
//        FC.displayAllFamilies();
//        System.out.print("This is end of display of all families \n");
//        System.out.printf("Families bigger than 2 %s \n", FC.getFamiliesBiggerThan(2));
//        System.out.printf("Families less than 3 %s \n", FC.getFamiliesLessThan(3));
//        System.out.printf("How many families have 1 kid? --> %d \n", FC.countFamiliesWithMemberNumber(3));
//        System.out.printf("How many families have 0 kids? --> %d \n", FC.countFamiliesWithMemberNumber(2));
//        FC.deleteFamilyByIndex(0);
//        System.out.printf("Double-check if the family #1 was deleted -> %s \n", FC.getAllFamilies());
//        Family family11 = FC.createNewFamily(woman1, man1);
//        Family family111 = FC.adoptChild(family11, kid2);
//        System.out.printf("Double-check if the family #1 was created again and kid is adopted -> %s \n", FC.getAllFamilies());
//        System.out.printf("Get family by index --> %s \n", FC.getFamilyByIndex(2));
//        Woman woman4 = new Woman("Aleksia", "Chickens", "21/06/1995");
//        Man man4 = new Man("Mike", "Tontik", "21/06/1995");
//        DomesticCat cat = new DomesticCat("lazy");
//        Human child4 = new Human("Jynnie", "Newport", "21/06/1995");
//        Family family4 = FC.createNewFamily(woman4, man4, child4, cat);
//        System.out.printf("Get pets from family #4 --> %s \n", family4.getAllPets());
//        FC.addPet(1, new Dog("Charlie"));
//        System.out.printf("Checking if dog is added ->> %s\n", family4.getAllPets());
//        System.out.printf("New baby --> %s \n", FC.bornChild(family4, "female", "male"));
//        FC.deleteAllChildrenOlderThen(0);
//        System.out.printf("deleted all kids except for the newly-born %s\n", FC.getAllFamilies());
//        System.out.printf("describeAge in action -->> %s\n",child4.describeAge());
//        FC.displayAllFamilies();
//        System.out.println("------------");
//        System.out.printf("%s",family1.prettyFormat());;
//        System.out.printf("%s",family2.prettyFormat());;
//        System.out.printf("%s",family3.prettyFormat());;
//        System.out.printf("%s",family4.prettyFormat());;
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            printMainMenu();
            System.out.print("Выбери пункт: ");
            int mainMenuSelection = sc.nextInt();
            switch (mainMenuSelection) {
                case 1:
                    FC.makeTestFamilies(5);
                    break;
                case 2:
                    FC.displayAllFamilies();
                    break;
                case 3:
                    System.out.print("Введи количество:");
                    int numberMoreThan = sc.nextInt();
                    FC.getFamiliesBiggerThan(numberMoreThan).forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Введи количество:");
                    int numberLessThan = sc.nextInt();
                    FC.getFamiliesLessThan(numberLessThan).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Введи количество:");
                    int exactNumber = sc.nextInt();
                    int i = FC.countFamiliesWithMemberNumber(exactNumber);
                    System.out.printf("Всего %d семей \n", i);
                    break;
                case 6:
                    createFamily();
                    break;
                case 7:
                    System.out.print("Введи порядковый номер:");
                    int familyNumber = sc.nextInt();
                    FC.deleteFamilyByIndex(familyNumber - 1);
                    break;
                case 8:
                    System.out.println("1. Родить ребенка");
                    System.out.println("2. Усыновить ребенка");
                    System.out.println("3. Вернуться назад");
                    System.out.print("Что делаем? ");
                    int option = sc.nextInt();
                    switch (option){
                        case 1:
                            makeABaby();
                            break;
                        case 2:
                            adoptChild();
                            break;
                        case 3: break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + option);
                    }
                    break;
                case 9:
                    System.out.print("Введи возраст: ");
                    int age = sc.nextInt();
                    FC.deleteAllChildrenOlderThen(age);
                    break;
                case 0:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + mainMenuSelection);
            }
        }
    }
}
