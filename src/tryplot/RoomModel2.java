package tryplot;

import java.io.Serializable;

/**
 *
 * @author CalvinGabriel
 */
public class RoomModel2 implements Serializable{
    private static final long serialVersionUID = 1L;
    private String roomNo, roomType, status;    
    private String[][] room;
    public RoomModel2(String roomNo, String roomType, String [][] room, String status)
    {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.room = room;
        this.status = status;
    }
    
    public String getRoomNo()
    {
        return roomNo;
    }
    public void setRoomNo(String roomNo)
    {
        this.roomNo = roomNo;
    }
    public String getRoomType()
    {
        return roomType;
    }
    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }
    public String[][] getRoom()
    {
        return room;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    } 
}

