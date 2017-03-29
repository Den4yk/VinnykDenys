package Model;


public class Room {
    private int idRooms;
    private String num;
    private int maxStudents;
    private int floor;
    private Hostel hostelsEntity;

    public int getIdRooms() {
        return idRooms;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Hostel getHostelsEntity() {
        return hostelsEntity;
    }

    public void setHostelsEntity(Hostel hostelsEntity) {
        this.hostelsEntity = hostelsEntity;
    }
}
