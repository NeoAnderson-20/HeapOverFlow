package mybatis;

import java.util.List;

public interface StudentDao {
    int insertStudents(String name,String password);
    List<Student> selectStudents();
}
