package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    void testChangeName() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName("Yotsaran");
        assertEquals("Yotsaran", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGradeA(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 75 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGradeB(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(75);
        assertEquals("B", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 65 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGradeC(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(65);
        assertEquals("C", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 55 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGradeD(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(55);
        assertEquals("D", s.grade());
    }

    @Test
    void testIsId() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxxx"));
    }

    @Test
    void testIsNameContains() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isNameContains("StudentTest"));
    }

}