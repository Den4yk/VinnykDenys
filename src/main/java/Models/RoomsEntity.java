package Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms", schema = "hostelregister")
@NamedQuery(name = "RoomsEntity.getAll", query = "SELECT obj FROM RoomsEntity obj")
public class RoomsEntity {
    private int idRooms;
    private String num;
    private int maxStudents;
    private int floor;
    private Set<StudentsEntity> studentsEntitySet = new HashSet<StudentsEntity>(0);
    private HostelsEntity hostelsEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRooms", nullable = false, insertable = false, updatable = false)
    public HostelsEntity getHostelsEntity() {
        return hostelsEntity;
    }

    public void setHostelsEntity(HostelsEntity hostelsEntity) {
        this.hostelsEntity = hostelsEntity;
    }

    @Id
    @Column(name = "idRooms")
    public int getIdRooms() {
        return idRooms;
    }

    public void setIdRooms(int idRooms) {
        this.idRooms = idRooms;
    }

    @Basic
    @Column(name = "Num")
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Basic
    @Column(name = "MaxStudents")
    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    @Basic
    @Column(name = "Floor")
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomsEntity that = (RoomsEntity) o;

        if (idRooms != that.idRooms) return false;
        if (maxStudents != that.maxStudents) return false;
        if (floor != that.floor) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRooms;
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + maxStudents;
        result = 31 * result + floor;
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomsEntity")
    public Set<StudentsEntity> getStudentsEntitySet() {
        return studentsEntitySet;
    }

    public void setStudentsEntitySet(Set<StudentsEntity> studentsEntitySet) {
        this.studentsEntitySet = studentsEntitySet;
    }

}
