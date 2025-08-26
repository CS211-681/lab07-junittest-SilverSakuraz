// File: src/test/java/ku/cs/models/StudentListTest.java
package ku.cs.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    void testAddNewStudent() {
        StudentList list = new StudentList();
        list.addNewStudent(" 6710400010 ", " First ");
        list.addNewStudent("6710400010", "DuplicateId"); // duplicate id -> ignored
        list.addNewStudent("1", "2nd", 99.9);

        assertEquals(2, list.getStudents().size());
        // trimmed id & name
        assertEquals("6710400010", list.getStudents().get(0).getId());
        assertEquals("First", list.getStudents().get(0).getName());
        assertEquals(99.9, list.getStudents().get(1).getScore());
    }

    @Test
    void testAddNewStudentWithScore() {
        StudentList list = new StudentList();
        list.addNewStudent(" 6710400010 ", " First ", 80.00);
        list.addNewStudent("6710400010", "DuplicateId");
        assertEquals(1, list.getStudents().size());
        assertEquals("6710400010", list.getStudents().get(0).getId());
        assertEquals("First", list.getStudents().get(0).getName());
        assertEquals(80.0, list.getStudents().get(0).getScore());
    }

    @Test
    void findStudentById() {
        StudentList list = new StudentList();
        list.addNewStudent("6710400020", "A");
        list.addNewStudent("6710400021", "B");
        assertNotNull(list.findStudentById("6710400020"));
        assertNull(list.findStudentById("0000000000"));
    }

    @Test
    void filterByName() {
        StudentList list = new StudentList();
        list.addNewStudent("6710400100", "Alice");
        list.addNewStudent("6710400101", "Alicia");
        list.addNewStudent("6710400102", "Bob");

        StudentList result1 = list.filterByName("Alice");
        assertEquals(1, result1.getStudents().size());
        assertEquals("Alice", result1.getStudents().get(0).getName());

        StudentList result2 = list.filterByName("xyz");
        assertEquals(0, result2.getStudents().size());
    }

    @Test
    void giveScoreToId() {
        StudentList list = new StudentList();
        list.addNewStudent("6710400200", "A");
        list.addNewStudent("6710400201", "B");

        list.giveScoreToId("6710400200", 15.5);
        assertEquals(15.5, list.findStudentById("6710400200").getScore());

        list.giveScoreToId("999", 10.0); // not found -> no effect
        assertEquals(0.0, list.findStudentById("6710400201").getScore());
    }

    @Test
    void viewGradeOfId() {
        StudentList list = new StudentList();
        list.addNewStudent("6710400030", "A"); // initial score 0 => expect failing grade by spec
        assertEquals("F", list.viewGradeOfId("6710400030"));
        assertNull(list.viewGradeOfId("999"));
    }

    @Test
    void getStudents() {
        StudentList list = new StudentList();
        list.addNewStudent("6710400300", "First");
        list.addNewStudent("6710400301", "Second");
        var all = list.getStudents();
        assertEquals(2, all.size());
        assertEquals("6710400300", all.get(0).getId());
        assertEquals("6710400301", all.get(1).getId());
    }
}
