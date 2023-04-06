package medCheck.database;

import medCheck.model.Doctor;
import medCheck.model.Hospital;

import javax.print.Doc;
import java.util.List;

public class Database {

    private List<Hospital>hospitals;

    public List<Hospital> getHospitals() {
        return hospitals;
    }
    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }


    public Database(List<Hospital> hospitals) {
        this.hospitals = hospitals;

    }
    public Database() {
    }
}
