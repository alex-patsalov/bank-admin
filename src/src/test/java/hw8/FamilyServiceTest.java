package hw8;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    static FamilyService FS = null;
    @BeforeEach
    public void before(){
        FS = new FamilyService();
    }
    @AfterEach
    public void after(){
        FS = null;
    }
    @Test
    void getAllFamilies() {
        List<Family> families = new ArrayList<>();
        Woman w1 = new Woman("female", "fsurname", 1980);
        Man m1 = new Man("male", "msurname", 1980);
        Family f1 = new Family(w1,m1);
        families.add(f1);
        FS.createNewFamily(w1,m1);
        Assertions.assertEquals(FS.getAllFamilies(), families);
    }
    @Test
    void createNewFamily() {
        Woman w2 = new Woman("female", "fsurname", 1980);
        Man m2 = new Man("male", "msurname", 1980);
        Family f2 = new Family(w2,m2);
        Assertions.assertEquals(FS.createNewFamily(w2,m2), f2);
    }
    @Test
    void testCreateNewFamily() {
        Woman w3 = new Woman("female", "fsurname", 1980);
        Man m3 = new Man("male", "msurname", 1980);
        Human c3 = new Human("kid","kids", 2005);
        Family f3 = new Family(w3,m3, c3);
        Assertions.assertEquals(FS.createNewFamily(w3,m3, c3), f3);
    }
    @Test
    void testCreateNewFamily1() {
        Woman w4 = new Woman("female", "fsurname", 1980);
        Man m4 = new Man("male", "msurname", 1980);
        Human c4 = new Human("kid","kids", 2005);
        Fish fish = new Fish("fish");
        Family f4 = new Family(w4,m4, c4, fish);
        Assertions.assertEquals(FS.createNewFamily(w4,m4, c4, fish), f4);
    }
    @Test
    void countFamilies() {
        List<Family> families = new ArrayList<>();
        Woman w5 = new Woman("female", "fsurname", 1980);
        Man m5 = new Man("male", "msurname", 1980);
        Family f5 = new Family(w5,m5);
        families.add(f5);
        FS.createNewFamily(w5,m5);
        Assertions.assertEquals(FS.countFamilies(), families.size());
    }
    @Test
    void displayAllFamilies() {
        Woman w6 = new Woman("Kate", "fsurname", 1980);
        Man m6 = new Man("Myan", "msurname", 1980);
        FS.createNewFamily(w6,m6);
        String expected = "[Family: mother='Kate', father='Myan', pet='[]', children='[]']";
        Assertions.assertEquals(expected, FS.displayAllFamilies());
    }
    @Test
    void getFamiliesBiggerThan() {
        Woman w7 = new Woman("female", "fsurname", 1980);
        Man m7 = new Man("male", "msurname", 1980);
        Human c7 = new Human("kid","kids", 2005);
        FS.createNewFamily(w7,m7,c7);
        String expected = "[Family: mother='female', father='male', pet='[]', children='[Human{name='kid', surname='kids', year='2005', iq='0', habits={}}]']";
        Assertions.assertEquals(expected, FS.getFamiliesBiggerThan(2).toString());
    }
    @Test
    void getFamiliesLessThan() {
        Woman w8 = new Woman("female", "fsurname", 1980);
        Man m8 = new Man("male", "msurname", 1980);
        Human c8 = new Human("kid","kids", 2005);
        FS.createNewFamily(w8,m8,c8);
        String expected = "[Family: mother='female', father='male', pet='[]', children='[Human{name='kid', surname='kids', year='2005', iq='0', habits={}}]']";
        Assertions.assertEquals(expected, FS.getFamiliesLessThan(4).toString());
    }
    @Test
    void countFamiliesWithMemberNumber() {
        Woman w9 = new Woman("female", "fsurname", 1980);
        Man m9 = new Man("male", "msurname", 1980);
        Human c9 = new Human("kid","kids", 2005);
        FS.createNewFamily(w9,m9,c9);
        Assertions.assertEquals(1, FS.countFamiliesWithMemberNumber(3));
    }
    @Test
    void deleteFamilyByIndex() {
        Woman w01 = new Woman("female", "fsurname", 1980);
        Man m01 = new Man("male", "msurname", 1980);
        Family f01 = new Family(w01,m01);
        Woman w02 = new Woman("female2", "fsurname2", 1980);
        Man m02 = new Man("male2", "msurname2", 1980);
        Family f02 = new Family(w02,m02);
        FS.createNewFamily(w01,m01);
        FS.createNewFamily(w02,m02);
        Family deleted = FS.deleteFamilyByIndex(0);
        Assertions.assertEquals(deleted, f01);
    }
    @Test
    void getFamilyById() {
        Woman w03 = new Woman("female", "fsurname", 1980);
        Man m03 = new Man("male", "msurname", 1980);
        Family f03 = new Family(w03,m03);
        FS.createNewFamily(w03,m03);
        Assertions.assertEquals(f03, FS.getFamilyById(0));
    }
    @Test
    void getPets() {
        Woman w04 = new Woman("female", "fsurname", 1980);
        Man m04 = new Man("male", "msurname", 1980);
        Human c04 = new Human("kid","kids", 2005);
        Fish fish = new Fish("fish");
        FS.createNewFamily(w04,m04, c04, fish);
        String expected = "[Fish{nickname='fish', age=0, tricklevel=0, habits=[]}]";
        Assertions.assertEquals(expected, FS.getPets(0));
    }
    @Test
    void addPet() {
        Woman w05 = new Woman("female", "fsurname", 1980);
        Man m05 = new Man("male", "msurname", 1980);
        Human c05 = new Human("kid","kids", 2005);
        Fish fish = new Fish("fish");
        Family f05 = new Family(w05, m05, c05, fish);
        Dog newPet = new Dog("Rocky");
        FS.createNewFamily(w05,m05, c05, fish);
        Assertions.assertEquals(f05.addPet(newPet), FS.addPet(0, new Dog("rocky")));
    }
    @Test
    void adoptChild() {
        Woman w06 = new Woman("female", "fsurname", 1980);
        Man m06 = new Man("male", "msurname", 1980);
        Family f06 = new Family(w06,m06);
        FS.createNewFamily(w06,m06);
        f06.addChild(new Human("baby", "baby", 2008));
        ArrayList<Human> children = FS.adoptChild(f06, new Human("baby", "baby", 2008)).getChildren();
        Assertions.assertEquals(f06.addChild(new Human("baby", "baby", 2008)), children);
    }
    @Test
    void bornChild() {
        Woman w07 = new Woman("female", "fsurname", 1980);
        Man m07 = new Man("male", "msurname", 1980);
        Family f07 = new Family(w07,m07);
        FS.createNewFamily(w07,m07);
        f07.addChild(new Human("baby", "msurname", 2008));
        ArrayList<Human> children = f07.getChildren();
        Assertions.assertEquals(children.get(0), FS.bornChild(f07,"baby", "baby"));
    }
}