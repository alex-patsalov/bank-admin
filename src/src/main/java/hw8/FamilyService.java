package hw8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyService {
    public FamilyDao FamilyDao;

    public FamilyService() {
        FamilyDao = new CollectionFamilyDao();
    }

    public List<Family> getAllFamilies() {
        return FamilyDao.getAllFamilies();
    }

    public void createNewFamily(Woman woman, Man man) {
        FamilyDao.saveFamily(new Family(woman, man));
    }

    public int countFamilies() {
        return FamilyDao.getAllFamilies().size();
    }

    public void displayAllFamilies() { // can be a mistake
        List<Family> allFamilies = FamilyDao.getAllFamilies();
        allFamilies.forEach( f -> System.out.printf("This is family %s", f.toString()));
    }

    public List<Family> getFamiliesBiggerThan(int number){ // can be a mistake
        List<Family> familiesBiggerThan = new ArrayList<>();
        List<Family> allFamilies = getAllFamilies();
        allFamilies.forEach( f ->{
            int qnty = f.countFamily(f);
            if(qnty > number) {
                f.toString();
                familiesBiggerThan.add(f);
            }
        });
        return familiesBiggerThan;
    }

    public List<Family> getFamiliesLessThan(int number){ // can be a mistake
        List<Family> familiesLessThan = new ArrayList<>();
        List<Family> allFamilies = getAllFamilies();
        allFamilies.forEach( f ->{
            int qnty = f.countFamily(f);
            if(qnty < number) {
                f.toString();
                familiesLessThan.add(f);
            }
        });
        return familiesLessThan;
    }

    public int countFamiliesWithMemberNumber(int number){
        List<Family> familiesExact = new ArrayList<>();
        List<Family> allFamilies = getAllFamilies();
        allFamilies.forEach( f ->{
            int qnty = f.countFamily(f);
            if(qnty == number) {
                f.toString();
                familiesExact.add(f);
            }
        });
        return familiesExact.size();
    }

    public void deleteFamilyByIndex(int index){
        FamilyDao.deleteFamily(index);
    }

    public Family getFamilyById(int index){
        return FamilyDao.getFamilyByIndex(index);
    }

    public String getPets(int index){
        Family f = FamilyDao.getFamilyByIndex(index);
        return f.getAllPets();
    }

    public void addPet(int index, Pet pet){
        Family f = FamilyDao.getFamilyByIndex(index);
        f.addPet(pet);
        FamilyDao.saveFamily(f);
    }

    public Family adoptChild(Family family, Human child){
        List<Family> allFamilies = getAllFamilies();
        int index = allFamilies.indexOf(family);
        Family selectedFamily = allFamilies.get(index);
        selectedFamily.addChild(child);
        FamilyDao.saveFamily(selectedFamily);
        return selectedFamily;
    }

    public Human bornChild(Family family, String fName, String mName){
        List<Family> allFamilies = getAllFamilies();
        int index = allFamilies.indexOf(family);
        Family selectedFamily = allFamilies.get(index);
        int rand = (int)(Math.random() * 2);
        Human child;
        if(rand == 0){
            child = new Human(fName, family.getFamilyName(family), LocalDate.now().getYear());
        } else{
            child = new Human(mName, family.getFamilyName(family), LocalDate.now().getYear());
        }
        family.addChild(child);
        FamilyDao.saveFamily(family);
        return child;
    }

    public void deleteAllChildrenOlderThen(int age){
        List<Family> allFamilies = FamilyDao.getAllFamilies();
        allFamilies.forEach(f ->{
            ArrayList<Human> allKids = f.getChildren();
            allKids.forEach(k ->{
                int kidAge = LocalDate.now().getYear() - k.getYearOfBirth();
                if(kidAge > age) {
                    Family ff = k.getFamily();
                    ff.deleteChild(k);
                    FamilyDao.saveFamily(ff);
                }
            });
        });
    }
}
