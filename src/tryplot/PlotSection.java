package tryplot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author CalvinGabriel
 */
public class PlotSection {
    private Map <String, String[][]> plotSec = new HashMap();            
    private String [][] roomtry3 = new String[28][6];
    private String [][] roomSec = new String[28][6];
    public Map PlotSection(Map hm)
    {
        plotSec.put("1ARKI1", new String[28][6]);
        plotSec.put("1ARKI2", new String[28][6]);
        plotSec.put("1ARKI3", new String[28][6]);
        plotSec.put("1ARKI4", new String[28][6]);
        plotSec.put("1ARKI5", new String[28][6]);
        plotSec.put("1ARKI6", new String[28][6]);
        plotSec.put("1ARKI7", new String[28][6]);
        plotSec.put("1ARKI8", new String[28][6]);
        plotSec.put("1ARKI9", new String[28][6]);
        plotSec.put("1ARKI10", new String[28][6]);
        plotSec.put("1ARKI11", new String[28][6]);
        plotSec.put("1ARKI12", new String[28][6]);
        
        Set set1 = hm.entrySet();                                    
        Iterator itrt1 = set1.iterator();
        while(itrt1.hasNext())
        {
            Map.Entry <String, RoomModel2> map2 = (Map.Entry)itrt1.next();
            RoomModel2 rm = (RoomModel2)map2.getValue();
            roomtry3 = rm.getRoom();
            Set set2 = plotSec.entrySet();
            Iterator itrt2 = set2.iterator();
            while(itrt2.hasNext())
            {    
                for(int o=0;o<28;o++)
                {
                    for(int p=0;p<6;p++)
                    {
                        if(roomtry3[o][p] != null)
                        {
                            if(roomtry3[o][p].startsWith("1ARKI1"))
                            {
                                roomSec[o][p] = roomtry3[o][p];
                            }
                        }
                        else if(roomtry3[o][p] != null)
                        {
                            if(roomtry3[o][p].startsWith("1ARKI1"))
                            {
                                roomSec[o][p] = roomtry3[o][p];
                            }
                        }
                    }
                }
            }    
        }
        return plotSec;
    }    
}
