package Model;
public class Student {
    private int idStudents;
    private String pib;
    private int course;
    private String idCode;
    private String passportSeries;
    private String passportNumber;
    private Room roomsEntity;

    public int getIdStudents() {
        return idStudents;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Room getRoomsEntity() {
        return roomsEntity;
    }

    public void setRoomsEntity(Room roomsEntity) {
        this.roomsEntity = roomsEntity;
    }
}
