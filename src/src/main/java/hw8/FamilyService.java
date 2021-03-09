package hw8;

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
}
