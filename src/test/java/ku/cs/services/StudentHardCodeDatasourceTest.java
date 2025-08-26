package ku.cs.services;


import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class StudentHardCodeDatasourceTest {


    @Test
    void readData_returnsPresetStudents() {
        StudentHardCodeDatasource ds = new StudentHardCodeDatasource();
        StudentList list = ds.readData();


        assertNotNull(list);
        assertEquals(4, list.getStudents().size(), "4 students");


// note: IDs start with 671..., not 641...
        assertNotNull(list.findStudentById("6710400001"));
        assertNotNull(list.findStudentById("6710400002"));
        assertNotNull(list.findStudentById("6710400003"));
        assertNotNull(list.findStudentById("6710400004"));
    }
}