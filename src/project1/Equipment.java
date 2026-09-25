package project1;

public enum Equipment
{
    STOVE250(100, "Gives you 25% more time to answer questions."),
    STOVE500(250, "Gives you 50% more time to answer questions."),
    STOVE750(500, "Gives you 75% more time to answer questions."),
    STOVE1000(750, "Gives you 100% more time to answer questions.");
    
    private int value;
    private String perkDescription;
    
    private Equipment(int value, String perkDescription)
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
