package hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PetTest {

    @Test
    void testToString() {
        Pet pet = new Pet(Species.Bird, "Bob", 2, 70,new String[]{"sleep"});
        String expected = "Bird{nickname='Bob', age=2, tricklevel=70, habits=[sleep]}";
        Assertions.assertEquals(expected, pet.toString());
    }
}