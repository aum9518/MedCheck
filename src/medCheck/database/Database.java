package medCheck.database;

import medCheck.model.Hospital;

import java.util.List;

public class Database {
    private List<Hospital> hospitals;

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
