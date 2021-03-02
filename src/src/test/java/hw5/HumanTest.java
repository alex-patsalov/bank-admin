package hw5;


import org.junit.jupiter.api.Assertions;

class HumanTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Human human = new Human("name", "surName", 1990);
        String expected = "Human{name='name', surname='surName', year='1990', iq='0', habits=[[null, null]]}";
        Assertions.assertEquals(expected, human.toString());
    }
}