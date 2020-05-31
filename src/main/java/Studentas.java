import java.util.ArrayList;


public class Studentas {
    private int id;
    private String vardas;
    private String pavarde;
    private String elPastas;
    private ArrayList<Pazymiai> pazymiai;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getVardas() {
        return vardas;
    }
    public void setVardas(String vardas) {
        this.vardas = vardas;
    }
    public String getPavarde() {
        return pavarde;
    }
    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }
    public String getEl_pastas() {
        return elPastas;
    }
    public void setEl_pastas(String el_pastas) {
        this.elPastas = el_pastas;
    }
    public ArrayList<Pazymiai> getPazymiai() {
        return pazymiai;
    }
    public void setPazymiai(ArrayList<Pazymiai> pazymiai) {
        this.pazymiai = pazymiai;
    }
}
