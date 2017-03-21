package Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students", schema = "hostelregister")
@NamedQuery(name = "StudentsEntity.getAll", query = "SELECT obj FROM StudentsEntity obj")
public class StudentsEntity {
    private int idStudents;
    private String pib;
    private int course;
    private String idCode;
    private String passportSeries;
    private String passportNumber;
    private RoomsEntity roomsEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idStudents", nullable = false, insertable = false, updatable = false)
    public RoomsEntity getRoomsEntity() {
        return roomsEntity;
    }

    public void setRoomsEntity(RoomsEntity roomsEntity) {
        this.roomsEntity = roomsEntity;
    }

    @Id
    @Column(name = "idStudents")
    public int getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(int idStudents) {
        this.idStudents = idStudents;
    }

    @Basic
    @Column(name = "PIB")
    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    @Basic
    @Column(name = "Course")
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Basic
    @Column(name = "IdCode")
    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    @Basic
    @Column(name = "PassportSeries")
    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    @Basic
    @Column(name = "PassportNumber")
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

        if (idStudents != that.idStudents) return false;
        if (course != that.course) return false;
        if (pib != null ? !pib.equals(that.pib) : that.pib != null) return false;
        if (idCode != null ? !idCode.equals(that.idCode) : that.idCode != null) return false;
        if (passportSeries != null ? !passportSeries.equals(that.passportSeries) : that.passportSeries != null)
            return false;
        if (passportNumber != null ? !passportNumber.equals(that.passportNumber) : that.passportNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudents;
        result = 31 * result + (pib != null ? pib.hashCode() : 0);
        result = 31 * result + course;
        result = 31 * result + (idCode != null ? idCode.hashCode() : 0);
        result = 31 * result + (passportSeries != null ? passportSeries.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        return result;
    }
}
