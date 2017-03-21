package Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hostels", schema = "hostelregister")
@NamedQuery(name = "HostelsEntity.getAll", query = "SELECT obj FROM HostelsEntity obj")
public class HostelsEntity {
    private int idHostels;
    private int num;
    private String adress;
    private String pibManager;
    private Set<RoomsEntity> roomsEntitySet = new HashSet<RoomsEntity>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hostelsEntity")
    public Set<RoomsEntity> getRoomsEntitySet() {
        return roomsEntitySet;
    }

    public void setRoomsEntitySet(Set<RoomsEntity> roomsEntitySet) {
        this.roomsEntitySet = roomsEntitySet;
    }

    @Id
    @Column(name = "idHostels")
    public int getIdHostels() {
        return idHostels;
    }

    public void setIdHostels(int idHostels) {
        this.idHostels = idHostels;
    }

    @Basic
    @Column(name = "Num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "Adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "PIBManager")
    public String getPibManager() {
        return pibManager;
    }

    public void setPibManager(String pibManager) {
        this.pibManager = pibManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HostelsEntity that = (HostelsEntity) o;

        if (idHostels != that.idHostels) return false;
        if (num != that.num) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (pibManager != null ? !pibManager.equals(that.pibManager) : that.pibManager != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHostels;
        result = 31 * result + num;
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (pibManager != null ? pibManager.hashCode() : 0);
        return result;
    }


}
