import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Studentas> studentuListas = new ArrayList<>();
        uzkrautiDuomenis(studentuListas);
        isvestiPagalPavardeVarda(studentuListas);
        isvestiVisuBendraVidurki(studentuListas);
    }

    static void uzkrautiDuomenis(ArrayList<Studentas> studentuListas) {
        try (
                Connection connection = DBConnectionParams.getConnection();
                Statement statement = connection.createStatement();
        )
        {
            ResultSet srs = statement.executeQuery("SELECT * FROM studentai");
            while (srs.next()) {
                Studentas studentas = new Studentas();
                studentas.setId(srs.getInt("Id"));
                studentas.setVardas(srs.getString("vardas"));
                studentas.setPavarde(srs.getString("pavarde"));
                studentas.setEl_pastas(srs.getString("el_pastas"));
                studentas.setPazymiai(new ArrayList<>());
                studentuListas.add(studentas);
            }
            System.out.println("ArrayList sudaro: " + studentuListas.size() + " " + "studentai");
            System.out.println("**********************************************");
            System.out.println(studentuListas.get(0).getVardas() + " " + studentuListas.get(0).getPavarde() + " " + studentuListas.get(0).getEl_pastas());
            System.out.println(studentuListas.get(1).getVardas() + " " + studentuListas.get(1).getPavarde() + " " + studentuListas.get(1).getEl_pastas());
            System.out.println(studentuListas.get(2).getVardas() + " " + studentuListas.get(2).getPavarde() + " " + studentuListas.get(2).getEl_pastas());
            System.out.println(studentuListas.get(3).getVardas() + " " + studentuListas.get(3).getPavarde() + " " + studentuListas.get(3).getEl_pastas());
            System.out.println("**********************************************");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DBConnectionParams.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet res = statement.executeQuery("SELECT * FROM pazymiai");
            while (res.next()) {
                Pazymiai paz = new Pazymiai();
                paz.setStudentasId(res.getInt("studentas_id"));
                paz.setData(res.getDate("data").toLocalDate());
                paz.setPazymys(res.getInt("pazymys"));
                for (Studentas s : studentuListas) {
                    if (s.getId() == paz.getStudentasId()) {
                        s.getPazymiai().add(paz);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void isvestiPagalPavardeVarda(ArrayList<Studentas> studentuListas) {
        studentuListas.stream()
                .sorted(Comparator.comparing(Studentas::getPavarde).thenComparing(Studentas::getVardas))
                .forEach(s -> System.out.println(s.getVardas() + " " + s.getPavarde()));
        System.out.println("**********************************************");
    }

    static void isvestiVisuBendraVidurki(ArrayList<Studentas> studentai) {
        double vidurkis = studentai.stream()
                .flatMap(studentas -> studentas.getPazymiai().stream())
                .mapToInt(pazymys -> pazymys.getPazymys())
                .average().orElse(0);
        System.out.println("Visu pažymių vidurkis: " + vidurkis);
    }
}

