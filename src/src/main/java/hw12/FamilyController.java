package hw12;

import java.io.IOException;
import java.util.List;

public class FamilyController {
    public FamilyService FamilyService;

    public FamilyController() {
        FamilyService = new FamilyService();
    }

    public List<Family> getAllFamilies(){return FamilyService.getAllFamilies();}
    public Family createNewFamily(Woman woman, Man man){return FamilyService.createNewFamily(woman, man);}
    public Family createNewFamily(Woman woman, Man man, Human child){return FamilyService.createNewFamily(woman, man, child);}
    public Family createNewFamily(Woman woman, Man man, Human child, Pet pet){return FamilyService.createNewFamily(woman, man, child, pet);}
    public int countFamilies(){return FamilyService.countFamilies();}
    public void displayAllFamilies(){
        FamilyService.displayAllFamilies();
    }
    public List<Family> getFamiliesBiggerThan(int number){return FamilyService.getFamiliesBiggerThan(number);}
    public List<Family> getFamiliesLessThan(int number){return FamilyService.getFamiliesLessThan(number);}
    public int countFamiliesWithMemberNumber(int number){return FamilyService.countFamiliesWithMemberNumber(number);}
    public void deleteFamilyByIndex(int index){FamilyService.deleteFamilyByIndex(index);}
    public Family getFamilyByIndex(int index){return FamilyService.getFamilyById(index);}
    public String getPets(int index){return FamilyService.getPets(index);}
    public void addPet(int index, Pet pet){FamilyService.addPet(index, pet);}
    public Family adoptChild(Family family, Human child){return FamilyService.adoptChild(family,child);}
    public Human bornChild(Family family, String fName, String mName){return FamilyService.bornChild(family, fName, mName);}
    public void deleteAllChildrenOlderThen(int age){FamilyService.deleteAllChildrenOlderThen(age);}
    public void makeTestFamilies(int quantity) throws IOException {
        FamilyService.makeTestFamilies(quantity);
    }
    public void deleteAllFamilies(){
        FamilyService.deleteAllFamilies();
    }
    public void saveData(List<Family> data) throws IOException { FamilyService.saveData(data);}
    public List<Family> getData() throws IOException, ClassNotFoundException {return FamilyService.getData();}
}
