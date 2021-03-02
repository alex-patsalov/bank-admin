package hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class FamilyTest {

    @Test
    void addChild() {
        Human mother = new Human("Jane", "Patrick", 1990);
        Human father = new Human("Alex", "Joe", 1980);
        Family family = new Family(mother, father);
        family.addChild(new Human("kidName", "kidSurname", 2010));
        Human[] kids = family.getChildren();
        String expected = "[Human{name='kidName', surname='kidSurname', year='2010', iq='0', habits=[[null, null]]}]";
        Assertions.assertEquals(expected, Arrays.toString(family.getChildren()));
    }

    @Test
    void deleteChildSuccess() {
        Human mother = new Human("Jane", "Patrick", 1990);
        Human father = new Human("Alex", "Joe", 1980);
        Human child = new Human("Eliz", "Jane", 2000);
        Family family = new Family(mother, father, child);
        int index = family.findIndex(child);
        family.deleteChild(index);
        int expected = 0;
        Assertions.assertEquals(expected, family.getChildrenQnty());
    }

    @Test
    void deleteChildFail() {
        Human mother = new Human("Jane", "Patrick", 1990);
        Human father = new Human("Alex", "Joe", 1980);
        Human child = new Human("Eliz", "Jane", 2000);
        Human child2 = new Human("child2", "child2", 1990);
        Family family = new Family(mother, father, child);
        int index = family.findIndex(child2);
        boolean isInFamily = index >= 0;
        Assertions.assertEquals(false, isInFamily);
    }

    @Test
    void testToString() {
        Human mother = new Human("Jane", "Patrick", 1990);
        Human father = new Human("Alex", "Joe", 1980);
        Pet pet = new Pet(Species.Bird, "Bob", 2, 70,new String[]{"sleep"});
        Human child = new Human("Eliz", "Jane", 2000);
        Family family = new Family(mother, father, child, pet);
        String expected = "Family: mother='Jane', father='Alex', pet='Bob', children='[Human{name='Eliz', surname='Jane', year='2000', iq='0', habits=[[null, null]]}]'";
        Assertions.assertEquals(expected, family.toString());
    }

    @Test
    void countFamily() {
        Human mother = new Human("Jane", "Patrick", 1990);
        Human father = new Human("Alex", "Joe", 1980);
        Human child = new Human("Eliz", "Jane", 2000);
        Family family = new Family(mother, father, child);
        int expected = 3;
        Assertions.assertEquals(expected, family.countFamily(family));
    }
}