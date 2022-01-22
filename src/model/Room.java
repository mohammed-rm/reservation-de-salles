package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    private int IdRoom;

    /**
     * @return IdRoom
     */
    public int getIdRoom() {
        return IdRoom;
    }

    /**
     * @param idRoom
     */
    public void setIdRoom(int idRoom) {
        IdRoom = idRoom;
    }

    @Override
    public String toString() {
        return "Room{" + "IdRoom=" + IdRoom + '}';
    }
}