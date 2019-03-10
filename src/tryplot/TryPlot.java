package tryplot;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author CalvinGabriel
 */
public class TryPlot {

    /**
     * @param args the command line arguments
     */
    private static int iday, pday1, pday2, pday3, secRemains, ttlSpan, l, m, n, hrLeftNxt, ttlSpan1, ttlSpan1a, ttlSpan1b, ttlSpan1c, ttlSpan2, ttlSpan3;
    private static String strPDay1, strPDay2, strPDay3, rmType, roomNo, roomNo1, rmType1, roomNo2;
    private static String[] strDays;
    private static String[][] room = new String[28][6];
    private static String[][] room2 = new String[28][6];
    private static String[][] room11 = new String[28][6];
    private static String[][] room11a = new String[28][6];
    private static String[][] roomtry1 = new String[28][6];
    private static String[][] roomtry2 = new String[28][6];
    private static String[][] roomtry3 = new String[28][6];
    private static String[][] roomSec = new String[28][6];
    private static List<String[][]> arrRoomList = new ArrayList<>();
    public static void main(String[] args) {
            int iyearLevel = 1;
            int numofSections = 12;
            String [][]room1a = new String[28][6];
            String [][]room1b = new String[28][6];
            String [][]room2a = new String[28][6];
            String [][]room2b = new String[28][6];
            String [][]room2c = new String[28][6];
            String [][]room2d = new String[28][6];
            String [][]room2e = new String[28][6];
            String [][]room3a = new String[28][6];
            String [][]room3b = new String[28][6];
            String [][]room4a = new String[28][6];
            String [][]room4b = new String[28][6];
            String [][]room5a = new String[28][6];
            String [][]room5b = new String[28][6];
            List currList = new ArrayList();
            currList.add(new Curriculum("ICS 123", "Software Engineering 1", 3, 1, 2, "M-W", 1.0, 1.0, 0.0));
            currList.add(new Curriculum("ICS 114", "Programming4", 0, 1, 1, "M", 1.5, 0.0, 0.0));
            //currList.add(new Curriculum("ICS 113", "Programming3", 0, 3, 1, "T", 2.0, 0.0, 0.0));
            //currList.add(new Curriculum("ENG I", "English", 0, 3, 3, "M-Th-F", 2.0, 1.0, 1.0));
            Map <String, RoomModel> mapStudio = new HashMap();
            Map <String, RoomModel> mapLecture = new HashMap();
            Map <String, RoomModel2> hm = new HashMap();
            Map <String, String[][]> plotSec = new HashMap();
            
            hm.put("Room401", new RoomModel2("Room401", "Hybrid Room", room2a, "Available"));
            hm.put("Room301a", new RoomModel2("Room301a", "Drafting Room", room2b, "Available"));
            hm.put("Room301b", new RoomModel2("Room301b", "Drafting Room", room2c, "Available"));
            hm.put("Room305", new RoomModel2("Room305", "Lecture Room", room2d, "Available"));
            hm.put("Room501", new RoomModel2("Room501", "Computer Laboratory", room2e, "Available"));
            
            mapStudio.put("room402", new RoomModel("room402", "Hybrid Room", room1a));
            mapStudio.put("room406", new RoomModel("room406", "Hybrid Room", room3a));
            mapStudio.put("room405", new RoomModel("room405", "Hybrid Room", room4a));
            mapStudio.put("room302a", new RoomModel("room302a", "Drafting Room", room5a));
            
            mapLecture.put("room502", new RoomModel("room502", "Computer Room", room1b));
            mapLecture.put("room404", new RoomModel("room404", "Hybrid Room", room3b));
            mapLecture.put("room403", new RoomModel("room403", "Hybrid Room", room4b));
            mapLecture.put("room501", new RoomModel("room501", "Computer Room", room5b));
            int icutofftimeF = 7;
            int icutofftimeT = 12;
            int hrSpan = icutofftimeT - icutofftimeF;
            int timeArrF = (icutofftimeF - 7) * 2;
            int timeArrT = ((icutofftimeT - 7) * 2) - 1;
            Iterator it = currList.iterator();
            while(it.hasNext()) 
            {
                Curriculum clum = (Curriculum)it.next();
                //CurriculumList cList = new CurriculumList();               
                //totalStudUnits = cList.totalStudUnits(currList);
                //totalLecUnits = cList.totalLecUnits(currList);
                String courseCode = clum.getCourseCode();
                String pairDay = clum.getPairingDays();                    
                int nday = clum.getNumDays();
                int studUnit = clum.getStudioUnits();
                int lecUnit = clum.getLectureUnits();

                    if((pairDay.length() == 1) || (pairDay.length() == 2))
                    {
                        switch(pairDay)
                        {
                            case "M":
                                iday = 0;
                                break;
                            case "T":
                                iday = 1;
                                break;
                            case "W":
                                iday = 2;
                                break;
                            case "Th":
                                iday = 3;
                                break;
                            case "F":
                                iday = 4;
                                break;
                            case "S":
                                iday = 5;
                                break;
                            default:
                                System.out.println("No match");
                        }     
                    }
                    else if((pairDay.length() == 3) || (pairDay.length() == 4))
                    {
                        strDays = pairDay.split("-");
                        strPDay1 = strDays[0];
                        strPDay2 = strDays[1];
                        switch(strPDay1)
                        {
                            case "M":
                                pday1 = 0;
                                break;
                            case "T":
                                pday1 = 1;
                                break;
                            case "W":
                                pday1 = 2;
                                break;
                            case "Th":
                                pday1 = 3;
                                break;
                            case "F":
                                pday1 = 4;
                                break;
                            case "S":
                                pday1 = 5;
                                break;
                            default:
                                System.out.println("No match");
                        }
                        switch(strPDay2)
                        {
                            case "M":
                                pday2 = 0;
                                break;
                            case "T":
                                pday2 = 1;
                                break;
                            case "W":
                                pday2 = 2;
                                break;
                            case "Th":
                                pday2 = 3;
                                break;
                            case "F":
                                pday2 = 4;
                                break;
                            case "S":
                                pday2 = 5;
                                break;
                            default:
                                System.out.println("No match");
                        }
                    }
                    else if((pairDay.length() == 5) || (pairDay.length() == 6))
                    {
                        strDays = pairDay.split("-");
                        strPDay1 = strDays[0];
                        strPDay2 = strDays[1];
                        strPDay3 = strDays[2];
                        switch(strPDay1)
                        {
                            case "M":
                                pday1 = 0;
                                break;
                            case "T":
                                pday1 = 1;
                                break;
                            case "W":
                                pday1 = 2;
                                break;
                            case "Th":
                                pday1 = 3;
                                break;
                            case "F":
                                pday1 = 4;
                                break;
                            case "S":
                                pday1 = 5;
                                break;
                            default:
                                System.out.println("No match");
                        }
                        switch(strPDay2)
                        {
                            case "M":
                                pday2 = 0;
                                break;
                            case "T":
                                pday2 = 1;
                                break;
                            case "W":
                                pday2 = 2;
                                break;
                            case "Th":
                                pday2 = 3;
                                break;
                            case "F":
                                pday2 = 4;
                                break;
                            case "S":
                                pday2 = 5;
                                break;
                            default:
                                System.out.println("No match");
                        }
                        switch(strPDay3)
                        {
                            case "M":
                                pday3 = 0;
                                break;
                            case "T":
                                pday3 = 1;
                                break;
                            case "W":
                                pday3 = 2;
                                break;
                            case "Th":
                                pday3 = 3;
                                break;
                            case "F":
                                pday3 = 4;
                                break;
                            case "S":
                                pday3 = 5;
                                break;
                            default:
                                System.out.println("No match");
                        }
                    } 
                    //Room Type Assignment
                    
                    if(nday == 1)
                    {
                        double hrday1 = clum.getDay1();
                        int i=numofSections;
                            
                            double dbhr = (hrday1/0.5);
                            int ttlhrc = (int)dbhr;
                            int counter = 1;
                            
                            if(studUnit > 0)
                            {
                                RoomModel2 rm2 = (RoomModel2)hm.get("Room301a");
                                String status = rm2.getStatus();
                                if(status.equals("Available"))
                                {
                                    room = rm2.getRoom();
                                    roomNo1 = rm2.getRoomNo();
                                    rmType1 = rm2.getRoomType();
                                }
                                else
                                {
                                    RoomModel2 rm2a = (RoomModel2)hm.get("Room301b");
                                    String status1 = rm2a.getStatus();
                                    if(status1.equals("Available"))
                                    {
                                        room = rm2a.getRoom();
                                        roomNo1 = rm2a.getRoomNo();
                                        rmType1 = rm2a.getRoomType();
                                    }
                                    else
                                    {
                                        RoomModel2 rm2b = (RoomModel2)hm.get("Room401");
                                        String status2 = rm2b.getStatus();
                                        room = rm2b.getRoom();
                                        roomNo1 = rm2b.getRoomNo();
                                        rmType1= rm2b.getRoomType();
                                    }    
                                }    
                            }
                            else
                            {
                                RoomModel2 rm2 = (RoomModel2)hm.get("Room305");
                                String status = rm2.getStatus();
                                if(status.equals("Available"))
                                {
                                    room = rm2.getRoom();
                                    roomNo1 = rm2.getRoomNo();
                                    rmType1 = rm2.getRoomType();
                                }
                                else
                                {
                                    RoomModel2 rm2a = (RoomModel2)hm.get("Room501");
                                    String status1 = rm2a.getStatus();
                                    if(status1.equals("Available"))
                                    {
                                        room = rm2a.getRoom();
                                        roomNo1 = rm2a.getRoomNo();
                                        rmType1 = rm2a.getRoomType();
                                    }
                                }    
                            }    
                               
                                int j = timeArrF;                                
                                if((room[j][iday] == null))//[j][0] is null
                                {
                                    System.out.println("1Day");
                                    secLoop:
                                    while(i>0)
                                    {    
                                        System.out.println("isang section");
                                        for(int k=0;k<ttlhrc;k++)
                                        {                                            
                                            ttlSpan = timeArrT - j;                                            
                                            int hrLeft = ttlhrc - k;
                                            
                                            if((ttlSpan < hrLeft))
                                            {
                                                System.out.println("The Cutofftime Range specified is fully scheduled");
                                                System.out.println(ttlSpan);
                                                Map map = new HashMap();
                                                if(studUnit > 0)
                                                {
                                                    System.out.println("Subject has studio units");
                                                    map.putAll(mapStudio);
                                                }
                                                else
                                                {
                                                    System.out.println("Subject has lecture units");
                                                    map.putAll(mapLecture);
                                                }    
                                                Set setmap = map.entrySet();                                                
                                                Iterator itrt = setmap.iterator();
                                                while(itrt.hasNext())
                                                {                                                    
                                                    ttlSpan1 = timeArrT - l;
                                                    hrLeftNxt = ttlhrc - k;
                                                    
                                                    Map.Entry<String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                    RoomModel rm = mapa.getValue();
                                                    roomNo = rm.getRoomNo();
                                                    rmType = rm.getRoomType();
                                                    room11 = rm.getRoom();
                                                    
                                                    if(ttlSpan1 < hrLeftNxt)
                                                    {                                                        
                                                        System.out.println("The Cutofftime Range specified is fully scheduled");
                                                        l=0;
                                                        
                                                        if(itrt.hasNext())
                                                        {
                                                            Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                            RoomModel rmz = mapb.getValue();
                                                            roomNo = rmz.getRoomNo();
                                                            rmType = rmz.getRoomType();
                                                            room11 = rmz.getRoom();
                                                        }
                                                        else
                                                        {
                                                            System.out.println("GG ERROR");
                                                            break secLoop;
                                                        }
                                                    } 
                                                    while(k<ttlhrc)
                                                    {                                                        
                                                        if(room11[l][iday] != null)
                                                        {
                                                            if(itrt.hasNext())
                                                            {    
                                                                Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                RoomModel rmz = mapb.getValue();
                                                                roomNo = rmz.getRoomNo();
                                                                rmType = rmz.getRoomType();
                                                                room11 = rmz.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop;
                                                            }    
                                                        }
                                                        else
                                                        {                                                        
                                                            room11[l][iday] = iyearLevel + "ARKI" + counter + " " + courseCode;
                                                            l++;
                                                            k++;
                                                            System.out.println(l);
                                                            System.out.println(roomNo);                                                           
                                                            System.out.println(courseCode);
                                                            if(((i-1) == 0) && (k == ttlhrc))
                                                            {    
                                                                l=0;
                                                            }
                                                        }
                                                        if(studUnit > 0)
                                                        {
                                                            mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                        else
                                                        {
                                                            mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                    }                                                    
                                                }    
                                            }
                                            else 
                                            {
                                                room[j][iday] =  iyearLevel + "ARKI" + counter + " " + courseCode;  
                                                j++;
                                                System.out.println(j);
                                                System.out.println(roomNo1);
                                                System.out.println(courseCode);                                                   
                                            }                                            
                                        }
                                        counter++;
                                        i--;
                                    }
                                    
                                    if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                    {    
                                        hm.replace(roomNo1, new RoomModel2(roomNo1, rmType1, room, "Available"));
                                    }
                                    else
                                    {
                                        hm.replace(roomNo1, new RoomModel2(roomNo1, rmType1, room, "Not Available"));
                                    }
                                }                                    
                                else if((room[j][iday] != null))
                                {
                                    while(room[j][iday] != null)
                                    {
                                       j++;
                                    }
                                    if((room[j][iday] == null))//[j][0] is null
                                    {
                                        secLoopa:
                                        while(i>0)
                                        {    
                                            System.out.println("isang section");
                                            for(int k=0;k<ttlhrc;k++)
                                            {                                            
                                                ttlSpan = timeArrT - j;                                            
                                                int hrLeft = ttlhrc - k;

                                                if((ttlSpan < hrLeft))
                                                {
                                                    System.out.println("The Cutofftime Range specified is fully scheduled");
                                                    System.out.println(ttlSpan);
                                                    Map map = new HashMap();
                                                    if(studUnit > 0)
                                                    {
                                                        map.putAll(mapStudio);
                                                    }
                                                    else
                                                    {
                                                        map.putAll(mapLecture);
                                                    }
                                                    Set setmap = map.entrySet();                                                
                                                    Iterator itrt = setmap.iterator();
                                                    while(itrt.hasNext())
                                                    {                                                    
                                                        ttlSpan1 = timeArrT - l;
                                                        hrLeftNxt = ttlhrc - k;

                                                        Map.Entry<String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                        RoomModel rm = mapa.getValue();
                                                        roomNo = rm.getRoomNo();
                                                        rmType = rm.getRoomType();
                                                        room11 = rm.getRoom();

                                                        if(ttlSpan1 < hrLeftNxt)
                                                        {                                                        
                                                            System.out.println("The Cutofftime Range specified is fully scheduled");
                                                            l=0;

                                                            if(itrt.hasNext())
                                                            {
                                                                Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                RoomModel rmz = mapb.getValue();
                                                                roomNo = rmz.getRoomNo();
                                                                rmType = rmz.getRoomType();
                                                                room11 = rmz.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoopa;
                                                            }
                                                        } 
                                                        while(k<ttlhrc)
                                                        {                                                        
                                                            if(room11[l][iday] != null)
                                                            {
                                                                if(itrt.hasNext())
                                                                {    
                                                                    Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                    RoomModel rmz = mapb.getValue();
                                                                    roomNo = rmz.getRoomNo();
                                                                    rmType = rmz.getRoomType();
                                                                    room11 = rmz.getRoom();
                                                                }
                                                                else
                                                                {
                                                                    System.out.println("GG ERROR");
                                                                    break secLoopa;
                                                                }    
                                                            }
                                                            else
                                                            {                                                        
                                                                room11[l][iday] = iyearLevel + "ARKI" + counter + " " + courseCode;
                                                                l++;
                                                                k++;
                                                                System.out.println(l);
                                                                System.out.println(roomNo);
                                                                if(((i-1) == 0) && (k == ttlhrc))
                                                                {    
                                                                    l=0;
                                                                }
                                                            }
                                                            if(studUnit > 0)
                                                            {
                                                                mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                            else
                                                            {
                                                                mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }                                                            
                                                        }       
                                                    }    
                                                }
                                                else 
                                                {
                                                    room[j][iday] =  iyearLevel + "ARKI" + counter + " " + courseCode;
                                                    j++;
                                                    System.out.println(j);                                                    
                                                }                                                
                                            }
                                            counter++;
                                            i--;                                            
                                        }
                                        if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                        }
                                        else
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                        }                                             
                                    }
                                }                            
                    }        
                    else if(nday == 2)
                    {
                        System.out.println("2Days");
                        double hrday1 = clum.getDay1();
                        double hrday2 = clum.getDay2();
                        double dbhr = hrday1/0.5;
                        double dbhr2 = hrday2/0.5;
                        int ttlhrc = (int) dbhr;
                        int ttlhrc2 = (int) dbhr2;
                        int counter1 = 1;
                        int counter2 = 1;
                        int a = numofSections;
                        int b = numofSections;
                        int j = timeArrF;
                        m = timeArrF;                        
                        
                        if(studUnit > 0)
                        {
                            RoomModel2 rm2 = (RoomModel2)hm.get("Room301a");
                            String status = rm2.getStatus();
                            if(status.equals("Available"))
                            {
                                room = rm2.getRoom();
                                roomNo1 = rm2.getRoomNo();
                                rmType1 = rm2.getRoomType();
                            }
                            else
                            {
                                RoomModel2 rm2a = (RoomModel2)hm.get("Room301b");
                                String status1 = rm2a.getStatus();
                                if(status1.equals("Available"))
                                {
                                    room = rm2a.getRoom();
                                    roomNo1 = rm2a.getRoomNo();
                                    rmType1 = rm2a.getRoomType();
                                }
                                else
                                {
                                    RoomModel2 rm2b = (RoomModel2)hm.get("Room401");
                                    String status2 = rm2b.getStatus();
                                    room = rm2b.getRoom();
                                    roomNo1 = rm2b.getRoomNo();
                                    rmType1 = rm2b.getRoomType();
                                }    
                            }    
                        }
                        else
                        {
                            RoomModel2 rm2 = (RoomModel2)hm.get("Room305");
                            String status = rm2.getStatus();
                            if(status.equals("Available"))
                            {
                                room = rm2.getRoom();
                                roomNo1 = rm2.getRoomNo();
                                rmType1 = rm2.getRoomType();
                            }
                            else
                            {
                                RoomModel2 rm2a = (RoomModel2)hm.get("Room501");
                                String status1 = rm2a.getStatus();
                                if(status1.equals("Available"))
                                {
                                    room = rm2a.getRoom();
                                    roomNo1 = rm2a.getRoomNo();
                                    rmType1 = rm2a.getRoomType();
                                }
                            }    
                        }
                            if((room[j][pday1] == null) | (room[m][pday2] == null) | (room[j][pday1] != null) | (room[m][pday2] != null))
                            {    
                                if((room[j][pday1] == null))//[j][0] is null
                                {
                                    secLoop1a:
                                    while(a>0)
                                    {    
                                        System.out.println("isang section");
                                        for(int k=0;k<ttlhrc;k++)
                                        {                                            
                                            ttlSpan = timeArrT - j;                                            
                                            int hrLeft = ttlhrc - k;
                                            
                                            if((ttlSpan < hrLeft))
                                            {
                                                System.out.println("The Cutofftime Range specified is fully scheduled");
                                                System.out.println(ttlSpan);
                                                Map map = new HashMap();
                                                if(studUnit > 0)
                                                {
                                                    System.out.println("Subject has studio units");
                                                    map.putAll(mapStudio);
                                                }
                                                else
                                                {
                                                    System.out.println("Subject has lecture units");
                                                    System.out.println();
                                                    map.putAll(mapLecture);
                                                }    
                                                Set setmap = map.entrySet();                                                
                                                Iterator itrt = setmap.iterator();
                                                while(itrt.hasNext())
                                                {                                                    
                                                    ttlSpan1a = timeArrT - l;
                                                    hrLeftNxt = ttlhrc - k;
                                                    
                                                    Map.Entry<String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                    RoomModel rm = mapa.getValue();
                                                    roomNo = rm.getRoomNo();
                                                    rmType = rm.getRoomType();
                                                    room11 = rm.getRoom();
                                                    
                                                    if(ttlSpan1a < hrLeftNxt)
                                                    {                                                        
                                                        System.out.println("The Cutofftime Range specified is fully scheduled");
                                                        l=0;
                                                        
                                                        if(itrt.hasNext())
                                                        {
                                                            Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                            RoomModel rmz = mapb.getValue();
                                                            roomNo = rmz.getRoomNo();
                                                            rmType = rmz.getRoomType();
                                                            room11 = rmz.getRoom();
                                                        }
                                                        else
                                                        {
                                                            System.out.println("GG ERROR");
                                                            break secLoop1a;
                                                        }
                                                    } 
                                                    while(k<ttlhrc)
                                                    {                                                        
                                                        if(room11[l][pday1] != null)
                                                        {                                                            
                                                            if(itrt.hasNext())
                                                            {    
                                                                Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                RoomModel rmz = mapb.getValue();
                                                                roomNo = rmz.getRoomNo();
                                                                rmType = rmz.getRoomType();
                                                                room11 = rmz.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1a;
                                                            }
                                                        }
                                                        else
                                                        {                                                        
                                                            room11[l][pday1] = iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                            l++;
                                                            k++;
                                                            System.out.println(l);
                                                            System.out.println(roomNo);                                                            
                                                            System.out.println(courseCode);
                                                            if(((a-1) == 0) && (k == ttlhrc))
                                                            {    
                                                                l=0;
                                                            }
                                                        }
                                                        if(studUnit > 0)
                                                        {
                                                            System.out.println("Im here");
                                                            mapStudio.put(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                        else
                                                        {
                                                            System.out.println("NO, Im here");
                                                            mapLecture.put(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                    }       
                                                }    
                                            }
                                            else 
                                            {
                                                room[j][pday1] =  iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                j++;
                                                System.out.println(j);
                                                System.out.println(roomNo1);                                                    
                                                System.out.println(courseCode);
                                            }
                                        }
                                        counter1++;
                                        a--;
                                    }
                                    if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                    }
                                    else
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                    }
                                }                                    
                                else if((room[j][pday1] != null))
                                {
                                    while(room[j][pday1] != null)
                                    {
                                       j++;
                                    }
                                    if((room[j][pday1] == null))//[j][0] is null
                                    {
                                        secLoop1b:
                                        while(a>0)
                                        {    
                                            System.out.println("isang section");
                                            for(int k=0;k<ttlhrc;k++)
                                            {                                            
                                                ttlSpan = timeArrT - j;                                            
                                                int hrLeft = ttlhrc - k;

                                                if((ttlSpan < hrLeft))
                                                {
                                                    System.out.println("The Cutofftime Range specified is fully scheduled");
                                                    System.out.println(ttlSpan);
                                                    Map map = new HashMap();
                                                    if(studUnit > 0)
                                                    {
                                                        map.putAll(mapStudio);
                                                    }
                                                    else
                                                    {
                                                        map.putAll(mapLecture);
                                                    }
                                                    Set set2 = map.entrySet();
                                                    Iterator itrt = set2.iterator();
                                                    while(itrt.hasNext())
                                                    {                                                    
                                                        ttlSpan1a = timeArrT - l;
                                                        hrLeftNxt = ttlhrc - k;
                                                        Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                        RoomModel rmz = mapb.getValue();
                                                        roomNo = rmz.getRoomNo();
                                                        rmType = rmz.getRoomType();
                                                        room11 = rmz.getRoom();
                                                        if(ttlSpan1a < hrLeftNxt)
                                                        {                                                        
                                                            System.out.println("The Cutofftime Range specified is fully scheduled");
                                                            l=0;

                                                            if(itrt.hasNext())
                                                            {                                                            
                                                                Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                RoomModel rm = mapa.getValue();
                                                                roomNo = rm.getRoomNo();
                                                                rmType = rm.getRoomType();
                                                                room11 = rm.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1b;
                                                            }
                                                        } 
                                                        while(k<ttlhrc)
                                                        {                                                        
                                                            if(room11[l][pday1] != null)
                                                            {
                                                                if(itrt.hasNext())
                                                                {                                                            
                                                                    Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                    RoomModel rm = mapa.getValue();
                                                                    roomNo = rm.getRoomNo();
                                                                    rmType = rm.getRoomType();
                                                                    room11 = rm.getRoom();
                                                                }
                                                                else
                                                                {
                                                                    System.out.println("GG ERROR");
                                                                    break secLoop1b;
                                                                }
                                                            }
                                                            else
                                                            {                                                        
                                                                room11[l][pday1] = iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                                l++;
                                                                k++;
                                                                System.out.println(l);
                                                                System.out.println(roomNo);
                                                                if(((a-1) == 0) && (k == ttlhrc))
                                                                {    
                                                                    l=0;
                                                                }
                                                            }                                                            
                                                            if(studUnit > 0)
                                                            {
                                                                mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                            else
                                                            {
                                                                mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                        }       
                                                    }    
                                                }
                                                else 
                                                {
                                                    room[j][pday1] =  iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                    j++;
                                                    System.out.println(j);   
                                                }
                                            }
                                            counter1++;
                                            a--;
                                        }
                                        if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                        }
                                        else
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                        }
                                    }
                                }                                                              
                                if((room[m][pday2] == null))//[j][0] is null
                                {
                                    secLoop1c:
                                    while(b>0)
                                    {    
                                        System.out.println("isang section");
                                        for(int k=0;k<ttlhrc2;k++)
                                        {                                            
                                            ttlSpan2 = timeArrT - m;                                            
                                            int hrLeft = ttlhrc2 - k;
                                            
                                            if((ttlSpan2 < hrLeft))
                                            {
                                                System.out.println("The Cutofftime Range specified is fully scheduled");
                                                System.out.println(ttlSpan2);
                                                Map map = new HashMap();
                                                if(studUnit > 0)
                                                {
                                                    System.out.println("Subject has studio units");
                                                    map.putAll(mapStudio);
                                                }
                                                else
                                                {
                                                    System.out.println("Subject has lecture units");
                                                    map.putAll(mapLecture);
                                                }    
                                                Set setmap = map.entrySet();                                                
                                                Iterator itrt = setmap.iterator();
                                                while(itrt.hasNext())
                                                {                                                    
                                                    ttlSpan1b = timeArrT - l;
                                                    hrLeftNxt = ttlhrc2 - k;
                                                    
                                                    Map.Entry<String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                    RoomModel rm = mapa.getValue();
                                                    roomNo = rm.getRoomNo();
                                                    rmType = rm.getRoomType();
                                                    room11 = rm.getRoom();
                                                    
                                                    if(ttlSpan1b < hrLeftNxt)
                                                    {                                                        
                                                        System.out.println("The Cutofftime Range specified is fully scheduled");
                                                        l=0;
                                                        
                                                        if(itrt.hasNext())
                                                        {
                                                            Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                            RoomModel rmz = mapb.getValue();
                                                            roomNo = rmz.getRoomNo();
                                                            rmType = rmz.getRoomType();
                                                            room11 = rmz.getRoom();
                                                        }
                                                        else
                                                        {
                                                            System.out.println("GG ERROR");
                                                            break secLoop1c;
                                                        }
                                                    } 
                                                    while(k<ttlhrc2)
                                                    {                                                        
                                                        if(room11[l][pday2] != null)
                                                        {
                                                            if(itrt.hasNext())
                                                            {    
                                                                Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                RoomModel rmz = mapb.getValue();
                                                                roomNo = rmz.getRoomNo();
                                                                rmType = rmz.getRoomType();
                                                                room11 = rmz.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1c;
                                                            }
                                                        }
                                                        else
                                                        {                                                        
                                                            room11[l][pday2] = iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                            l++;
                                                            k++;
                                                            System.out.println(l);
                                                            System.out.println(roomNo);                                                            
                                                            System.out.println(courseCode);
                                                            if(((b-1) == 0) && (k == ttlhrc2))
                                                            {    
                                                                l=0;
                                                            }
                                                        }
                                                        if(studUnit > 0)
                                                        {
                                                            mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                        else
                                                        {
                                                            mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                    }       
                                                }    
                                            }
                                            else 
                                            {
                                                room[m][pday2] =  iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                m++;
                                                System.out.println(m);
                                                System.out.println(roomNo1);                                                    
                                                System.out.println(courseCode);
                                            }
                                        }
                                        counter2++;
                                        b--;
                                    }
                                    if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                    }
                                    else
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                    }
                                }                                    
                                else if((room[m][pday2] != null))
                                {
                                    while(room[m][pday2] != null)
                                    {
                                       m++;
                                    }
                                    if((room[m][pday2] == null))//[j][0] is null
                                    {
                                        secLoop1d:
                                        while(b>0)
                                        {    
                                            System.out.println("isang section");
                                            for(int k=0;k<ttlhrc2;k++)
                                            {                                            
                                                ttlSpan2 = timeArrT - m;                                            
                                                int hrLeft = ttlhrc2 - k;

                                                if((ttlSpan2 < hrLeft))
                                                {
                                                    System.out.println("The Cutofftime Range specified is fully scheduled");
                                                    System.out.println(ttlSpan);
                                                    Map map = new HashMap();
                                                    if(studUnit > 0)
                                                    {
                                                        map.putAll(mapStudio);
                                                    }
                                                    else
                                                    {
                                                        map.putAll(mapLecture);
                                                    }
                                                    Set set2 = map.entrySet();
                                                    Iterator itrt = set2.iterator();
                                                    while(itrt.hasNext())
                                                    {                                                    
                                                        ttlSpan1b = timeArrT - l;
                                                        hrLeftNxt = ttlhrc2 - k;
                                                        Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                        RoomModel rmz = mapb.getValue();
                                                        roomNo = rmz.getRoomNo();
                                                        rmType = rmz.getRoomType();
                                                        room11 = rmz.getRoom();                                                  
                                                        if(ttlSpan1b < hrLeftNxt)
                                                        {                                                        
                                                            System.out.println("The Cutofftime Range specified is fully scheduled");
                                                            l=0;

                                                            if(itrt.hasNext())
                                                            {                                                            
                                                                Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                RoomModel rm = mapa.getValue();
                                                                roomNo = rm.getRoomNo();
                                                                rmType = rm.getRoomType();
                                                                room11 = rm.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1d;
                                                            }
                                                        } 
                                                        while(k<ttlhrc2)
                                                        {                                                        
                                                            if(room11[l][pday2] != null)
                                                            {
                                                                if(itrt.hasNext())
                                                                {                                                            
                                                                    Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                    RoomModel rm = mapa.getValue();
                                                                    roomNo = rm.getRoomNo();
                                                                    rmType = rm.getRoomType();
                                                                    room11 = rm.getRoom();
                                                                }
                                                                else
                                                                {
                                                                    System.out.println("GG ERROR");
                                                                    break secLoop1d;
                                                                }
                                                            }
                                                            else
                                                            {                                                        
                                                                room11a[l][pday2] = iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                                l++;
                                                                k++;
                                                                System.out.println(l);
                                                                System.out.println(roomNo);
                                                                if(((b-1) == 0) && (k == ttlhrc2))
                                                                {    
                                                                    l=0;
                                                                }
                                                            }
                                                            if(studUnit > 0)
                                                            {
                                                                mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                            else
                                                            {
                                                                mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                        }       
                                                    }    
                                                }
                                                else 
                                                {
                                                    room[m][pday2] =  iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                    m++;
                                                    System.out.println(m);
                                                    System.out.println(roomNo1);
                                                    System.out.println(courseCode);
                                                }
                                            }
                                            counter2++;
                                            b--;
                                        }
                                        if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                        }
                                        else
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                        }
                                    }
                                }
                            }    
                    }            
                    else if(nday == 3)
                    {
                        double hrday1 = clum.getDay1();
                        double hrday2 = clum.getDay2();
                        double hrday3 = clum.getDay3();
                        double dbhr = hrday1/0.5;
                        double dbhr2 = hrday2/0.5;
                        double dbhr3 = hrday3/0.5;
                        int ttlhrc = (int) dbhr;
                        int ttlhrc2 = (int) dbhr2;
                        int ttlhrc3 = (int) dbhr3;
                        int counter1 = 1;
                        int counter2 = 1;
                        int counter3 = 1;
                        int a = numofSections;
                        int b = numofSections;
                        int c = numofSections;
                        int j = timeArrF;
                        m = timeArrF;
                        n = timeArrF;
                        
                        if(studUnit > 0)
                        {
                            RoomModel2 rm2 = (RoomModel2)hm.get("Room301a");
                            String status = rm2.getStatus();
                            if(status.equals("Available"))
                            {
                                room = rm2.getRoom();
                                roomNo1 = rm2.getRoomNo();
                                rmType1 = rm2.getRoomType();
                            }
                            else
                            {
                                RoomModel2 rm2a = (RoomModel2)hm.get("Room301b");
                                String status1 = rm2a.getStatus();
                                if(status1.equals("Available"))
                                {
                                    room = rm2a.getRoom();
                                    roomNo1 = rm2a.getRoomNo();
                                    rmType1 = rm2a.getRoomType();
                                }
                                else
                                {
                                    RoomModel2 rm2b = (RoomModel2)hm.get("Room401");
                                    String status2 = rm2b.getStatus();
                                    room = rm2b.getRoom();
                                    roomNo1 = rm2b.getRoomNo();
                                    rmType1 = rm2b.getRoomType();
                                }    
                            }    
                        }
                        else
                        {
                            RoomModel2 rm2 = (RoomModel2)hm.get("Room305");
                            String status = rm2.getStatus();
                            if(status.equals("Available"))
                            {
                                room = rm2.getRoom();
                                roomNo1 = rm2.getRoomNo();
                                rmType1 = rm2.getRoomType();
                            }
                            else
                            {
                                RoomModel2 rm2a = (RoomModel2)hm.get("Room501");
                                String status1 = rm2a.getStatus();
                                if(status1.equals("Available"))
                                {
                                    room = rm2a.getRoom();
                                    roomNo1 = rm2a.getRoomNo();
                                    rmType1 = rm2a.getRoomType();
                                }
                            }    
                        }
                            if((room[j][pday1] == null) | (room[m][pday2] == null) | (room[n][pday3] == null) | (room[j][pday1] != null) | (room[m][pday2] != null) | (room[n][pday3] != null))
                            {    
                                if((room[j][pday1] == null))//[j][0] is null
                                {
                                    secLoop1a:
                                    while(a>0)
                                    {    
                                        System.out.println("isang section");
                                        for(int k=0;k<ttlhrc;k++)
                                        {                                            
                                            ttlSpan = timeArrT - j;                                            
                                            int hrLeft = ttlhrc - k;
                                            
                                            if((ttlSpan < hrLeft))
                                            {
                                                System.out.println("The Cutofftime Range specified is fully scheduled");
                                                System.out.println(ttlSpan);
                                                Map map = new HashMap();
                                                if(studUnit > 0)
                                                {
                                                    System.out.println("Subject has studio units");
                                                    map.putAll(mapStudio);
                                                }
                                                else
                                                {
                                                    System.out.println("Subject has lecture units");
                                                    System.out.println();
                                                    map.putAll(mapLecture);
                                                }    
                                                Set setmap = map.entrySet();                                                
                                                Iterator itrt = setmap.iterator();
                                                while(itrt.hasNext())
                                                {                                                    
                                                    ttlSpan1a = timeArrT - l;
                                                    hrLeftNxt = ttlhrc - k;
                                                    
                                                    Map.Entry<String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                    RoomModel rm = mapa.getValue();
                                                    roomNo = rm.getRoomNo();
                                                    rmType = rm.getRoomType();
                                                    room11 = rm.getRoom();
                                                    
                                                    if(ttlSpan1a < hrLeftNxt)
                                                    {                                                        
                                                        System.out.println("The Cutofftime Range specified is fully scheduled");
                                                        l=0;
                                                        
                                                        if(itrt.hasNext())
                                                        {
                                                            Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                            RoomModel rmz = mapb.getValue();
                                                            roomNo = rmz.getRoomNo();
                                                            rmType = rmz.getRoomType();
                                                            room11 = rmz.getRoom();
                                                        }
                                                        else
                                                        {
                                                            System.out.println("GG ERROR");
                                                            break secLoop1a;
                                                        }
                                                    } 
                                                    while(k<ttlhrc)
                                                    {                                                        
                                                        if(room11[l][pday1] != null)
                                                        {                                                            
                                                            if(itrt.hasNext())
                                                            {    
                                                                Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                RoomModel rmz = mapb.getValue();
                                                                roomNo = rmz.getRoomNo();
                                                                rmType = rmz.getRoomType();
                                                                room11 = rmz.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1a;
                                                            }
                                                        }
                                                        else
                                                        {                                                        
                                                            room11[l][pday1] = iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                            l++;
                                                            k++;
                                                            System.out.println(l);
                                                            System.out.println(roomNo);                                                            
                                                            System.out.println(courseCode);
                                                            if(((a-1) == 0) && (k == ttlhrc))
                                                            {    
                                                                l=0;
                                                            }
                                                        }
                                                        if(studUnit > 0)
                                                        {
                                                            System.out.println("Im here");
                                                            mapStudio.put(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                        else
                                                        {
                                                            System.out.println("NO, Im here");
                                                            mapLecture.put(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                    }       
                                                }    
                                            }
                                            else 
                                            {
                                                room[j][pday1] =  iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                j++;
                                                System.out.println(j);
                                                System.out.println(roomNo1);                                                    
                                                System.out.println(courseCode);
                                            }
                                        }
                                        counter1++;
                                        a--;
                                    }
                                    if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                    }
                                    else
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                    }
                                }                                    
                                else if((room[j][pday1] != null))
                                {
                                    while(room[j][pday1] != null)
                                    {
                                       j++;
                                    }
                                    if((room[j][pday1] == null))//[j][0] is null
                                    {
                                        secLoop1b:
                                        while(a>0)
                                        {    
                                            System.out.println("isang section");
                                            for(int k=0;k<ttlhrc;k++)
                                            {                                            
                                                ttlSpan = timeArrT - j;                                            
                                                int hrLeft = ttlhrc - k;

                                                if((ttlSpan < hrLeft))
                                                {
                                                    System.out.println("The Cutofftime Range specified is fully scheduled");
                                                    System.out.println(ttlSpan);
                                                    Map map = new HashMap();
                                                    if(studUnit > 0)
                                                    {
                                                        map.putAll(mapStudio);
                                                    }
                                                    else
                                                    {
                                                        map.putAll(mapLecture);
                                                    }
                                                    Set set2 = map.entrySet();
                                                    Iterator itrt = set2.iterator();
                                                    while(itrt.hasNext())
                                                    {                                                    
                                                        ttlSpan1a = timeArrT - l;
                                                        hrLeftNxt = ttlhrc - k;
                                                        Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                        RoomModel rmz = mapb.getValue();
                                                        roomNo = rmz.getRoomNo();
                                                        rmType = rmz.getRoomType();
                                                        room11 = rmz.getRoom();
                                                        if(ttlSpan1a < hrLeftNxt)
                                                        {                                                        
                                                            System.out.println("The Cutofftime Range specified is fully scheduled");
                                                            l=0;

                                                            if(itrt.hasNext())
                                                            {                                                            
                                                                Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                RoomModel rm = mapa.getValue();
                                                                roomNo = rm.getRoomNo();
                                                                rmType = rm.getRoomType();
                                                                room11 = rm.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1b;
                                                            }
                                                        } 
                                                        while(k<ttlhrc)
                                                        {                                                        
                                                            if(room11[l][pday1] != null)
                                                            {
                                                                if(itrt.hasNext())
                                                                {                                                            
                                                                    Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                    RoomModel rm = mapa.getValue();
                                                                    roomNo = rm.getRoomNo();
                                                                    rmType = rm.getRoomType();
                                                                    room11 = rm.getRoom();
                                                                }
                                                                else
                                                                {
                                                                    System.out.println("GG ERROR");
                                                                    break secLoop1b;
                                                                }
                                                            }
                                                            else
                                                            {                                                        
                                                                room11[l][pday1] = iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                                l++;
                                                                k++;
                                                                System.out.println(l);
                                                                System.out.println(roomNo);
                                                                if(((a-1) == 0) && (k == ttlhrc))
                                                                {    
                                                                    l=0;
                                                                }
                                                            }                                                            
                                                            if(studUnit > 0)
                                                            {
                                                                mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                            else
                                                            {
                                                                mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                        }       
                                                    }    
                                                }
                                                else 
                                                {
                                                    room[j][pday1] =  iyearLevel + "ARKI" + counter1 + " " + courseCode;
                                                    j++;
                                                    System.out.println(j);   
                                                }
                                            }
                                            counter1++;
                                            a--;
                                        }
                                        if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                        }
                                        else
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                        }
                                    }
                                }                                                              
                                if((room[m][pday2] == null))//[j][0] is null
                                {
                                    secLoop1c:
                                    while(b>0)
                                    {    
                                        System.out.println("isang section");
                                        for(int k=0;k<ttlhrc2;k++)
                                        {                                            
                                            ttlSpan2 = timeArrT - m;                                            
                                            int hrLeft = ttlhrc2 - k;
                                            
                                            if((ttlSpan2 < hrLeft))
                                            {
                                                System.out.println("The Cutofftime Range specified is fully scheduled");
                                                System.out.println(ttlSpan2);
                                                Map map = new HashMap();
                                                if(studUnit > 0)
                                                {
                                                    System.out.println("Subject has studio units");
                                                    map.putAll(mapStudio);
                                                }
                                                else
                                                {
                                                    System.out.println("Subject has lecture units");
                                                    map.putAll(mapLecture);
                                                }    
                                                Set setmap = map.entrySet();                                                
                                                Iterator itrt = setmap.iterator();
                                                while(itrt.hasNext())
                                                {                                                    
                                                    ttlSpan1b = timeArrT - l;
                                                    hrLeftNxt = ttlhrc2 - k;
                                                    
                                                    Map.Entry<String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                    RoomModel rm = mapa.getValue();
                                                    roomNo = rm.getRoomNo();
                                                    rmType = rm.getRoomType();
                                                    room11 = rm.getRoom();
                                                    
                                                    if(ttlSpan1b < hrLeftNxt)
                                                    {                                                        
                                                        System.out.println("The Cutofftime Range specified is fully scheduled");
                                                        l=0;
                                                        
                                                        if(itrt.hasNext())
                                                        {
                                                            Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                            RoomModel rmz = mapb.getValue();
                                                            roomNo = rmz.getRoomNo();
                                                            rmType = rmz.getRoomType();
                                                            room11 = rmz.getRoom();
                                                        }
                                                        else
                                                        {
                                                            System.out.println("GG ERROR");
                                                            break secLoop1c;
                                                        }
                                                    } 
                                                    while(k<ttlhrc2)
                                                    {                                                        
                                                        if(room11[l][pday2] != null)
                                                        {
                                                            if(itrt.hasNext())
                                                            {    
                                                                Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                RoomModel rmz = mapb.getValue();
                                                                roomNo = rmz.getRoomNo();
                                                                rmType = rmz.getRoomType();
                                                                room11 = rmz.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1c;
                                                            }
                                                        }
                                                        else
                                                        {                                                        
                                                            room11[l][pday2] = iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                            l++;
                                                            k++;
                                                            System.out.println(l);
                                                            System.out.println(roomNo);                                                            
                                                            System.out.println(courseCode);
                                                            if(((b-1) == 0) && (k == ttlhrc2))
                                                            {    
                                                                l=0;
                                                            }
                                                        }
                                                        if(studUnit > 0)
                                                        {
                                                            mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                        else
                                                        {
                                                            mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                    }       
                                                }    
                                            }
                                            else 
                                            {
                                                room[m][pday2] =  iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                m++;
                                                System.out.println(m);
                                                System.out.println(roomNo1);                                                    
                                                System.out.println(courseCode);
                                            }
                                        }
                                        counter2++;
                                        b--;
                                    }
                                    if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                    }
                                    else
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                    }
                                }                                    
                                else if((room[m][pday2] != null))
                                {
                                    while(room[m][pday2] != null)
                                    {
                                       m++;
                                    }
                                    if((room[m][pday2] == null))//[j][0] is null
                                    {
                                        secLoop1d:
                                        while(b>0)
                                        {    
                                            System.out.println("isang section");
                                            for(int k=0;k<ttlhrc2;k++)
                                            {                                            
                                                ttlSpan2 = timeArrT - m;                                            
                                                int hrLeft = ttlhrc2 - k;

                                                if((ttlSpan2 < hrLeft))
                                                {
                                                    System.out.println("The Cutofftime Range specified is fully scheduled");
                                                    System.out.println(ttlSpan);
                                                    Map map = new HashMap();
                                                    if(studUnit > 0)
                                                    {
                                                        map.putAll(mapStudio);
                                                    }
                                                    else
                                                    {
                                                        map.putAll(mapLecture);
                                                    }
                                                    Set set2 = map.entrySet();
                                                    Iterator itrt = set2.iterator();
                                                    while(itrt.hasNext())
                                                    {                                                    
                                                        ttlSpan1b = timeArrT - l;
                                                        hrLeftNxt = ttlhrc2 - k;
                                                        Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                        RoomModel rmz = mapb.getValue();
                                                        roomNo = rmz.getRoomNo();
                                                        rmType = rmz.getRoomType();
                                                        room11 = rmz.getRoom();                                                  
                                                        if(ttlSpan1b < hrLeftNxt)
                                                        {                                                        
                                                            System.out.println("The Cutofftime Range specified is fully scheduled");
                                                            l=0;

                                                            if(itrt.hasNext())
                                                            {                                                            
                                                                Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                RoomModel rm = mapa.getValue();
                                                                roomNo = rm.getRoomNo();
                                                                rmType = rm.getRoomType();
                                                                room11 = rm.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1d;
                                                            }
                                                        } 
                                                        while(k<ttlhrc2)
                                                        {                                                        
                                                            if(room11[l][pday2] != null)
                                                            {
                                                                if(itrt.hasNext())
                                                                {                                                            
                                                                    Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                    RoomModel rm = mapa.getValue();
                                                                    roomNo = rm.getRoomNo();
                                                                    rmType = rm.getRoomType();
                                                                    room11 = rm.getRoom();
                                                                }
                                                                else
                                                                {
                                                                    System.out.println("GG ERROR");
                                                                    break secLoop1d;
                                                                }
                                                            }
                                                            else
                                                            {                                                        
                                                                room11[l][pday2] = iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                                l++;
                                                                k++;
                                                                System.out.println(l);
                                                                System.out.println(roomNo);
                                                                if(((b-1) == 0) && (k == ttlhrc2))
                                                                {    
                                                                    l=0;
                                                                }
                                                            }
                                                            if(studUnit > 0)
                                                            {
                                                                mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                            else
                                                            {
                                                                mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                        }       
                                                    }    
                                                }
                                                else 
                                                {
                                                    room[m][pday2] =  iyearLevel + "ARKI" + counter2 + " " + courseCode;
                                                    m++;
                                                    System.out.println(m);
                                                    System.out.println(roomNo1);
                                                    System.out.println(courseCode);
                                                }
                                            }
                                            counter2++;
                                            b--;
                                        }
                                        if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                        }
                                        else
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                        }
                                    }
                                }
                                if((room[n][pday3] == null))//[j][0] is null
                                {
                                    secLoop1e:
                                    while(c>0)
                                    {    
                                        System.out.println("isang section");
                                        for(int k=0;k<ttlhrc3;k++)
                                        {                                            
                                            ttlSpan3 = timeArrT - n;                                            
                                            int hrLeft = ttlhrc3 - k;
                                            
                                            if((ttlSpan3 < hrLeft))
                                            {
                                                System.out.println("The Cutofftime Range specified is fully scheduled");
                                                System.out.println(ttlSpan3);
                                                Map map = new HashMap();
                                                if(studUnit > 0)
                                                {
                                                    System.out.println("Subject has studio units");
                                                    map.putAll(mapStudio);
                                                }
                                                else
                                                {
                                                    System.out.println("Subject has lecture units");
                                                    System.out.println();
                                                    map.putAll(mapLecture);
                                                }    
                                                Set setmap = map.entrySet();                                                
                                                Iterator itrt = setmap.iterator();
                                                while(itrt.hasNext())
                                                {                                                    
                                                    ttlSpan1c = timeArrT - l;
                                                    hrLeftNxt = ttlhrc3 - k;
                                                    
                                                    Map.Entry<String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                    RoomModel rm = mapa.getValue();
                                                    roomNo = rm.getRoomNo();
                                                    rmType = rm.getRoomType();
                                                    room11 = rm.getRoom();
                                                    
                                                    if(ttlSpan1c < hrLeftNxt)
                                                    {                                                        
                                                        System.out.println("The Cutofftime Range specified is fully scheduled");
                                                        l=0;
                                                        
                                                        if(itrt.hasNext())
                                                        {
                                                            Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                            RoomModel rmz = mapb.getValue();
                                                            roomNo = rmz.getRoomNo();
                                                            rmType = rmz.getRoomType();
                                                            room11 = rmz.getRoom();
                                                        }
                                                        else
                                                        {
                                                            System.out.println("GG ERROR");
                                                            break secLoop1e;
                                                        }
                                                    } 
                                                    while(k<ttlhrc3)
                                                    {                                                        
                                                        if(room11[l][pday3] != null)
                                                        {                                                            
                                                            if(itrt.hasNext())
                                                            {    
                                                                Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                                RoomModel rmz = mapb.getValue();
                                                                roomNo = rmz.getRoomNo();
                                                                rmType = rmz.getRoomType();
                                                                room11 = rmz.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1e;
                                                            }
                                                        }
                                                        else
                                                        {                                                        
                                                            room11[l][pday3] = iyearLevel + "ARKI" + counter3 + " " + courseCode;
                                                            l++;
                                                            k++;
                                                            System.out.println(l);
                                                            System.out.println(roomNo);                                                            
                                                            System.out.println(courseCode);
                                                            if(((c-1) == 0) && (k == ttlhrc3))
                                                            {    
                                                                l=0;
                                                            }
                                                        }
                                                        if(studUnit > 0)
                                                        {
                                                            System.out.println("Im here");
                                                            mapStudio.put(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                        else
                                                        {
                                                            System.out.println("NO, Im here");
                                                            mapLecture.put(roomNo, new RoomModel(roomNo, rmType, room11));
                                                        }
                                                    }       
                                                }    
                                            }
                                            else 
                                            {
                                                room[n][pday3] =  iyearLevel + "ARKI" + counter3 + " " + courseCode;
                                                n++;
                                                System.out.println(n);
                                                System.out.println(roomNo1);                                                    
                                                System.out.println(courseCode);
                                            }
                                        }
                                        counter3++;
                                        c--;
                                    }
                                    if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                    }
                                    else
                                    {
                                        hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                    }
                                }                                    
                                else if((room[n][pday3] != null))
                                {
                                    while(room[n][pday3] != null)
                                    {
                                       n++;
                                    }
                                    if((room[n][pday3] == null))//[j][0] is null
                                    {
                                        secLoop1f:
                                        while(c>0)
                                        {    
                                            System.out.println("isang section");
                                            for(int k=0;k<ttlhrc3;k++)
                                            {                                            
                                                ttlSpan3 = timeArrT - n;                                            
                                                int hrLeft = ttlhrc3 - k;

                                                if((ttlSpan3 < hrLeft))
                                                {
                                                    System.out.println("The Cutofftime Range specified is fully scheduled");
                                                    System.out.println(ttlSpan3);
                                                    Map map = new HashMap();
                                                    if(studUnit > 0)
                                                    {
                                                        map.putAll(mapStudio);
                                                    }
                                                    else
                                                    {
                                                        map.putAll(mapLecture);
                                                    }
                                                    Set set2 = map.entrySet();
                                                    Iterator itrt = set2.iterator();
                                                    while(itrt.hasNext())
                                                    {                                                    
                                                        ttlSpan1c = timeArrT - l;
                                                        hrLeftNxt = ttlhrc - k;
                                                        Map.Entry <String, RoomModel> mapb = (Map.Entry)itrt.next();
                                                        RoomModel rmz = mapb.getValue();
                                                        roomNo = rmz.getRoomNo();
                                                        rmType = rmz.getRoomType();
                                                        room11 = rmz.getRoom();
                                                        if(ttlSpan1c < hrLeftNxt)
                                                        {                                                        
                                                            System.out.println("The Cutofftime Range specified is fully scheduled");
                                                            l=0;

                                                            if(itrt.hasNext())
                                                            {                                                            
                                                                Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                RoomModel rm = mapa.getValue();
                                                                roomNo = rm.getRoomNo();
                                                                rmType = rm.getRoomType();
                                                                room11 = rm.getRoom();
                                                            }
                                                            else
                                                            {
                                                                System.out.println("GG ERROR");
                                                                break secLoop1f;
                                                            }
                                                        } 
                                                        while(k<ttlhrc3)
                                                        {                                                        
                                                            if(room11[l][pday3] != null)
                                                            {
                                                                if(itrt.hasNext())
                                                                {                                                            
                                                                    Map.Entry <String, RoomModel> mapa = (Map.Entry)itrt.next();
                                                                    RoomModel rm = mapa.getValue();
                                                                    roomNo = rm.getRoomNo();
                                                                    rmType = rm.getRoomType();
                                                                    room11 = rm.getRoom();
                                                                }
                                                                else
                                                                {
                                                                    System.out.println("GG ERROR");
                                                                    break secLoop1f;
                                                                }
                                                            }
                                                            else
                                                            {                                                        
                                                                room11[l][pday3] = iyearLevel + "ARKI" + counter3 + " " + courseCode;
                                                                l++;
                                                                k++;
                                                                System.out.println(l);
                                                                System.out.println(roomNo);
                                                                if(((c-1) == 0) && (k == ttlhrc3))
                                                                {    
                                                                    l=0;
                                                                }
                                                            }                                                            
                                                            if(studUnit > 0)
                                                            {
                                                                mapStudio.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                            else
                                                            {
                                                                mapLecture.replace(roomNo, new RoomModel(roomNo, rmType, room11));
                                                            }
                                                        }       
                                                    }    
                                                }
                                                else 
                                                {
                                                    room[n][pday3] =  iyearLevel + "ARKI" + counter3 + " " + courseCode;
                                                    n++;
                                                    System.out.println(n);   
                                                }
                                            }
                                            counter3++;
                                            c--;
                                        }
                                        if((room[27][0] == null) && (room[27][1] == null) && (room[27][2] == null) && (room[27][3] == null) && (room[27][4] == null) && (room[27][5] == null))
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "Available"));
                                        }
                                        else
                                        {
                                            hm.replace(roomNo, new RoomModel2(roomNo, rmType, room, "NotAvailable"));
                                        }
                                    }
                                }
                            }
                    }    
            
        }
        System.out.println("Wheres the shame?\n");
        System.out.println("MAPLECTURE\n");
        Set set2 = mapLecture.entrySet();
        Iterator itrt = set2.iterator();
        while(itrt.hasNext())
        {
            Map.Entry <String, RoomModel> mape = (Map.Entry)itrt.next();
            RoomModel rm = (RoomModel)mape.getValue();
            rmType = rm.getRoomType();
            roomtry1 = rm.getRoom();
            roomNo = rm.getRoomNo();
            System.out.println(roomNo);
            System.out.println(rmType);
            for(int o=0;o<28;o++)
            {
                for(int p=0;p<6;p++)
                {    
                        //boolean test = Arrays.stream(roomtry1).anyMatch("1ARKI1"::equals);
                    
                        //System.out.println("TRANSFERRING....");
                        //roomSec[o][p] = roomtry1[o][p];
                       
                        System.out.print(roomtry1[o][p] + " ");
                        
                }
                System.out.println("\n");
            }
        }    
        System.out.println("Wheres the shame?\n");
        System.out.println("MAPSTUDIO\n");
        Set set = mapStudio.entrySet();
        Iterator itrt2 = set.iterator();
        while(itrt2.hasNext())
        {
            Map.Entry <String, RoomModel> mape = (Map.Entry)itrt2.next();
            RoomModel rm = (RoomModel)mape.getValue();
            rmType = rm.getRoomType();
            roomtry2 = rm.getRoom();
            roomNo = rm.getRoomNo();
            System.out.println(roomNo);
            System.out.println(rmType);
            for(int o=0;o<28;o++)
            {
                for(int p=0;p<6;p++)
                {    
                    System.out.print(roomtry2[o][p] + " ");
                }
                System.out.println("\n");
            }
        }
        System.out.println("Wheres the shame?\n");
        System.out.println("HM MAP\n");
        Set set1 = hm.entrySet();
        Iterator itrt1 = set1.iterator();
        while(itrt1.hasNext())
        {
            Map.Entry <String, RoomModel2> map2 = (Map.Entry)itrt1.next();
            RoomModel2 rm = (RoomModel2)map2.getValue();
            rmType = rm.getRoomType();
            roomtry3 = rm.getRoom();
            roomNo = rm.getRoomNo();
            String status = rm.getStatus();
            System.out.println(roomNo);
            System.out.println(rmType);
            System.out.println(status);  
            for(int o=0;o<28;o++)
            {
                for(int p=0;p<6;p++)
                {
                    if(roomtry3[o][p] != null)
                    {
                        if(roomtry3[o][p].startsWith("1ARKI2"))
                        {
                            if(roomSec[o][p] == null)
                            {                                
                                if(roomSec[o][p] == null)
                                {    
                                    roomSec[o][p] = roomtry3[o][p] + " " + roomNo;
                                }
                                else
                                {
                                    int place1 = o;
                                    int place2 = p;
                                    while(roomSec[place1][place2] != null)
                                    {
                                        place1++;
                                    }
                                    roomSec[place1][place2] = roomtry3[o][p];
                                }    
                            }
                            else
                            {                                
                                int place1 = o;
                                int place2 = p;
                                while(roomSec[place1][place2] != null)
                                {
                                    place1++;
                                }
                                roomSec[place1][place2] = roomtry3[o][p];
                            }   
                        }
                    }
                    System.out.print(roomtry3[o][p] + " ");
                }
                System.out.println("\n");
            }
        }
        System.out.println("Room1");
        for(int o=0;o<28;o++)
        {
            for(int p=0;p<6;p++)
            {    
                System.out.print(roomSec[o][p] + " ");
            }
            System.out.println("\n");
        }
        
    }
}
