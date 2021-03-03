package hw7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class FamilyTest {

    @Test
    void addChild() {
        Woman mother = new Woman("Jane", "Patrick", 1990);
        Man father = new Man("Alex", "Joe", 1980);
        Family family = new Family(mother, father);
        family.addChild(new Human("kidName", "kidSurname", 2010));
        ArrayList<Human> kids = family.getChildren();
        String expected = "[Human{name='kidName', surname='kidSurname', year='2010', iq='0', habits={}}]";
        Assertions.assertEquals(expected, kids.toString());
    }

    @Test
    void deleteChildSuccess() {
        Woman mother = new Woman("Jane", "Patrick", 1990);
        Man father = new Man("Alex", "Joe", 1980);
        Human child = new Human("Eliz", "Jane", 2000);
        Family family = new Family(mother, father, child);
//        int index = family.findIndex(child);
        family.deleteChild(child);
        int expected = 0;
        Assertions.assertEquals(expected, family.getChildrenQnty());
    }

    @Test
    void deleteChildFail() {
        Woman mother = new Woman("Jane", "Patrick", 1990);
        Man father = new Man("Alex", "Joe", 1980);
        Human child = new Human("Eliz", "Jane", 2000);
        Human child2 = new Human("child2", "child2", 1990);
        Family family = new Family(mother, father, child);
        ArrayList<Human> kids = family.getChildren();
        boolean isInFamily = kids.contains(child2);
        Assertions.assertEquals(false, isInFamily);
    }

    @Test
    void testToString() {
        Woman mother = new Woman("Jane", "Patrick", 1990);
        Man father = new Man("Alex", "Joe", 1980);
        Dog pet = new Dog("Bob", 2, 70,"sleep");
        Human child = new Human("Eliz", "Jane", 2000);
        Family family = new Family(mother, father, child, pet);
        String expected = "Family: mother='Jane', father='Alex', pet='[Dog{nickname='Bob', age=2, tricklevel=70, habits=[sleep]}]', children='[Human{name='Eliz', surname='Jane', year='2000', iq='0', habits={}}]'";
        Assertions.assertEquals(expected, family.toString());
    }

    @Test
    void countFamily() {
        Woman mother = new Woman("Jane", "Patrick", 1990);
        Man father = new Man("Alex", "Joe", 1980);
        Human child = new Human("Eliz", "Jane", 2000);
        Family family = new Family(mother, father, child);
        int expected = 3;
        Assertions.assertEquals(expected, family.countFamily(family));
    }
}