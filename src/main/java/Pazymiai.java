import java.time.LocalDate;

public class Pazymiai {
    int id;
    int studentasId;
    LocalDate data;
    int pazymys;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        id = id;
    }
    public int getStudentasId() {
        return studentasId;
    }
    public void setStudentasId(int studentasId) {
        this.studentasId = studentasId;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public int getPazymys() {
        return pazymys;
    }
    public void setPazymys(int pazymys) {
        this.pazymys = pazymys;
    }
}
