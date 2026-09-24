package project1;

public class Equipment
{
    private int value;
    private String perkDescription;
    
    public Equipment(int value, String perkDescription)
    {
        this.value = value;
        this.perkDescription = perkDescription;
    }

    public int getValue()
    {
        return value;
    }
    
    public String getPerkDescription()
    {
        return perkDescription;
    }
}
