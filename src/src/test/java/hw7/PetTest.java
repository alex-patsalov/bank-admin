package hw7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PetTest {

    @Test
    void testToString() {
        DomesticCat pet = new DomesticCat("Bob", 2, 70, "sleep");
        String expected = "DomescticCat{nickname='Bob', age=2, tricklevel=70, habits=[sleep]}";
        Assertions.assertEquals(expected, pet.toString());
    }
}