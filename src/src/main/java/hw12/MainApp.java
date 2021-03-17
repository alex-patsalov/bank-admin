package hw12;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainApp {
    public static FamilyController FC = new FamilyController();
    public static Scanner sc = new Scanner(System.in);

    public static Map<Integer, Runnable> cases = new HashMap<Integer,Runnable>() {{
        put(1, () -> {
            try {
                FC.makeTestFamilies(5);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(2, () -> {
            try {
                FC.getData();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        put(3, MainApp::case3);
        put(4, MainApp::case4);
        put(5, MainApp::case5);
        put(6, MainApp::createFamily);
        put(7, MainApp::case7);
        put(8, MainApp::case8);
        put(9, MainApp::case9);
        put(10, MainApp::case10);
    }};

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
        String buffer1 = sc.nextLine();
        System.out.print("Введи имя матери: ");
        String motherName = sc.nextLine();
        System.out.print("Введи фамилию матери: ");
        String motherSurname = sc.nextLine();
        System.out.print("Введи дату рождения матери: ");
        String dobM = sc.nextLine();
        System.out.print("Введи iq матери: ");
        int iqM = sc.nextInt();
        if (motherName == null || motherSurname == null || dobM == null) throw new IllegalArgumentException();
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
        if (fatherName == null || fatherSurname == null || dobF == null) throw new IllegalArgumentException();
        Man father = new Man(fatherName, fatherSurname, dobF, iqF);
        FC.createNewFamily(mother, father);
    }
    public static void makeABaby() {
        System.out.print("Введи порядковый номер семьи: ");
        int index = sc.nextInt();
        if (index < 0) throw new IllegalArgumentException();
        Family family = FC.getFamilyByIndex(index - 1);
        if (family.getChildrenQnty() > 2) throw new FamilyOverFlownException("Maybe it is enough?");
        String buffer = sc.nextLine();
        System.out.print("Какое имя дать мальчику? ");
        String mName = sc.nextLine();
        System.out.print("А девочке? ");
        String fName = sc.nextLine();
        if (mName == null || fName == null) throw new IllegalArgumentException();
        FC.bornChild(family, mName, fName);
    }
    public static void adoptChild() {
        System.out.print("Введи номер семьи: ");
        int index = sc.nextInt();
        if (index < 0) throw new IllegalArgumentException();
        Family f = FC.getFamilyByIndex(index - 1);
        if (f.getChildrenQnty() > 2) throw new FamilyOverFlownException("Maybe it is enough?");
        String buffer = sc.nextLine();
        System.out.print("Введи имя ребенка: ");
        String name = sc.nextLine();
        System.out.print("Введи фамилию ребенка: ");
        String surname = sc.nextLine();
        System.out.print("Введи дату рождения ребенка: ");
        String dob = sc.nextLine();
        System.out.print("Введи iq ребенка: ");
        int iq = sc.nextInt();
        if (name == null || surname == null || dob == null) throw new IllegalArgumentException();
        Human kid = new Human(name, surname, dob, iq);
        FC.adoptChild(f, kid);
    }
    public static void case3(){
        System.out.print("Введи количество:");
        int numberMoreThan = sc.nextInt();
        if (numberMoreThan < 2) throw new IllegalArgumentException();
        FC.getFamiliesBiggerThan(numberMoreThan).forEach(System.out::println);
    }
    public static void case4(){
        System.out.print("Введи количество:");
        int numberLessThan = sc.nextInt();
        if (numberLessThan < 2) throw new IllegalArgumentException();
        FC.getFamiliesLessThan(numberLessThan).forEach(System.out::println);
    }
    public static void case5(){
        System.out.print("Введи количество:");
        int exactNumber = sc.nextInt();
        if (exactNumber < 2) throw new IllegalArgumentException();
        int i = FC.countFamiliesWithMemberNumber(exactNumber);
        System.out.printf("Всего %d семей \n", i);
    }
    public static void case7(){
        System.out.print("Введи порядковый номер:");
        int familyNumber = sc.nextInt();
        if (familyNumber < 0) throw new IllegalArgumentException();
        FC.deleteFamilyByIndex(familyNumber - 1);
    }
    public static void case8(){
        System.out.println("1. Родить ребенка");
        System.out.println("2. Усыновить ребенка");
        System.out.println("3. Вернуться назад");
        System.out.print("Что делаем? ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                makeABaby();
                break;
            case 2:
                adoptChild();
                break;
            case 3:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
    public static void case9(){
        System.out.print("Введи возраст: ");
        int age = sc.nextInt();
        if (age < 1) throw new IllegalArgumentException();
        FC.deleteAllChildrenOlderThen(age);
    }
    public static void case10() {
        List<Family> allFamilies = FC.getAllFamilies();
        try{
            FC.saveData(allFamilies);
        } catch (IOException e){
            e.getMessage();
        }

    }
    public static void main(String[] args) {

        for (; ; ) {
            printMainMenu();
            System.out.print("Выбери пункт: ");
            int mainMenuSelection = sc.nextInt();
            cases.get(mainMenuSelection).run();
        }
    }
}
