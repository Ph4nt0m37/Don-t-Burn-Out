package project1;

import java.util.ArrayList;
import java.util.Arrays;

public enum Equipment
{
    STOVE100(0, "Stove 100", "Gives you 0% more time to answer questions.", 1.00),
    STOVE250(100, "Stove 250", "Gives you 25% more time to answer questions.", 1.25),
    STOVE500(250, "Stove 500", "Gives you 50% more time to answer questions.", 1.5),
    STOVE750(500, "Stove 750", "Gives you 75% more time to answer questions.", 1.75),
    STOVE1000(750, "Stove 1000", "Gives you 100% more time to answer questions.", 2);
    
    public final static ArrayList<Equipment> equipmentOrder = new ArrayList<>(Arrays.asList(STOVE250,STOVE500,STOVE750,STOVE1000));
    
    private int value;
    private String displayName;
    private String perkDescription;
    private double timeMult;
    
    private Equipment(int value, String displayName, String perkDescription, double timeMult)
    {
        this.value = value;
        this.displayName = displayName;
        this.perkDescription = perkDescription;
        this.timeMult = timeMult;
    }

    public int getValue()
    {
        return value;
    }
    
    public String getDisplayName()
    {
        return displayName;
    }
    
    public String getPerkDescription()
    {
        return perkDescription;
    }
    
    public double getTimeMult() {
        return timeMult;
    }
    
    public String toString() {
        return displayName;
    }
}
