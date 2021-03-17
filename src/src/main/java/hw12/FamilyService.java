package hw12;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    public FamilyDao FamilyDao;

    public FamilyService() throws IOException, ClassNotFoundException {
        FamilyDao = new CollectionFamilyDao();
    }

    public List<Family> getAllFamilies() {
        return FamilyDao.getAllFamilies();
    }

    public Family createNewFamily(Woman woman, Man man) {
        return FamilyDao.saveFamily(new Family(woman, man));
    }

    public Family createNewFamily(Woman woman, Man man, Human child) {
        return FamilyDao.saveFamily(new Family(woman, man, child));
    }

    public Family createNewFamily(Woman woman, Man man, Human child, Pet pet) {
        return FamilyDao.saveFamily(new Family(woman, man, child, pet));
    }

    public void makeTestFamilies(int quantity) throws IOException {
        String testName = "testName";
        String testSurname = "testSurname";
        for (int i = 0; i < quantity; i++) {
            String s = String.valueOf((int) (Math.random() * 100));
            Man father = new Man(testName + s, testSurname + s, "21/04/1980");
            Woman mother = new Woman(testName + s, testSurname + s, "11/02/1987");
            Human child = new Human(testName + s, testSurname + s, "20/11/2005");
            FamilyDao.saveFamily(new Family(mother, father, child));
        }
        List<Family> allFamilies = getAllFamilies();
        saveData(allFamilies);
    }

    public void deleteAllFamilies(){
        FamilyDao.getAllFamilies().removeAll(this.getAllFamilies());
    }

    public int countFamilies() {
        return FamilyDao.getAllFamilies().size();
    }

    public void displayAllFamilies() {
        List<Family> allFamilies = FamilyDao.getAllFamilies();
        for(int i = 0; i < allFamilies.size(); i++){
            System.out.printf("%d) %s",i, allFamilies.get(i).prettyFormat());
        }
    }

    public List<Family> getFamiliesBiggerThan(int number) throws IOException, ClassNotFoundException {
        return FamilyDao.getData()
                .stream()
                .filter(f -> f.countFamily(f) > number)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int number) throws IOException, ClassNotFoundException {
        return FamilyDao.getData()
                .stream()
                .filter(f -> f.countFamily(f) < number)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int number) throws IOException, ClassNotFoundException {
        return (int) FamilyDao.getData()
                .stream()
                .filter(f -> f.countFamily(f) == number).count();
    }

    public Family deleteFamilyByIndex(int index) {
        return FamilyDao.deleteFamily(index);
    }

    public Family getFamilyById(int index) {
        return FamilyDao.getFamilyByIndex(index);
    }

    public String getPets(int index) {
        Family f = FamilyDao.getFamilyByIndex(index);
        return f.getAllPets();
    }

    public boolean addPet(int index, Pet pet) {
        Family f = FamilyDao.getFamilyByIndex(index);
        f.addPet(pet);
        FamilyDao.saveFamily(f);
        return true;
    }

    public Family adoptChild(Family family, Human child) {
        List<Family> allFamilies = getAllFamilies();
        int index = allFamilies.indexOf(family);
        Family selectedFamily = allFamilies.get(index);
        selectedFamily.addChild(child);
        FamilyDao.saveFamily(selectedFamily);
        return selectedFamily;
    }

    public String dobToString(Date date) {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");
        return formatForDateNow.format(date);
    }

    public Human bornChild(Family family, String fName, String mName) {
        int rand = (int) (Math.random() * 2);
        Human child;
        if (rand == 0) {
            child = new Human(fName, family.getFamilyName(family), dobToString(new Date()));
        } else {
            child = new Human(mName, family.getFamilyName(family), dobToString(new Date()));
        }
        family.addChild(child);
        FamilyDao.saveFamily(family);
        return child;
    }

    public void deleteAllChildrenOlderThen(int age) {
        FamilyDao.getAllFamilies()
                .stream()
                .peek(f -> f.getChildren().removeIf(h -> LocalDate.now().getYear() - h.getAge() > age))
                .close();
    }

    public void saveData(List<Family> data) throws IOException {
        FamilyDao.saveData(data);
    }
    public List<Family> getData() throws IOException, ClassNotFoundException {
        return FamilyDao.getData();
    }
}
