package hw8;

import java.util.List;

public class FamilyController {
    public FamilyService FamilyService;

    public FamilyController() {
        FamilyService = new FamilyService();
    }

    public List<Family> getAllFamilies(){return FamilyService.getAllFamilies();}
    public void createNewFamily(Woman woman, Man man){FamilyService.createNewFamily(woman, man);}
    public int countFamilies(){return FamilyService.countFamilies();}
    public void displayAllFamilies(){FamilyService.displayAllFamilies();}
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
}
