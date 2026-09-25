package project1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the different stove equipment upgrades available to the player.
 * <p>
 * Each equipment item has a purchase value, display name, perk description, and
 * time multiplier. The time multiplier determines how much additional time the
 * player receives to answer questions.
 * </p>
 * 
 * @author Brinda Amidyala
 * @author Paulo Korowajczuk Nader
 */
public enum Equipment
{
    /**
     * The starting stove with no additional time bonus.
     */
    STOVE100(
        0,
        "Stove 100",
        "Gives you 0% more time to answer questions.",
        1.00),

    /**
     * Stove upgrade that provides 25% more time to answer questions.
     */
    STOVE250(
        100,
        "Stove 250",
        "Gives you 25% more time to answer questions.",
        1.25),

    /**
     * Stove upgrade that provides 50% more time to answer questions.
     */
    STOVE500(
        250,
        "Stove 500",
        "Gives you 50% more time to answer questions.",
        1.5),

    /**
     * Stove upgrade that provides 75% more time to answer questions.
     */
    STOVE750(
        500,
        "Stove 750",
        "Gives you 75% more time to answer questions.",
        1.75),

    /**
     * Stove upgrade that provides 100% more time to answer questions.
     */
    STOVE1000(
        750,
        "Stove 1000",
        "Gives you 100% more time to answer questions.",
        2);

    /**
     * Stores the equipment upgrades in the order in which they can be
     * purchased.
     */
    public static final ArrayList<Equipment> equipmentOrder =
        new ArrayList<>(Arrays.asList(STOVE250, STOVE500, STOVE750, STOVE1000));

    /**
     * The amount of money required to purchase the equipment.
     */
    private int value;

    /**
     * The name displayed to the player.
     */
    private String displayName;

    /**
     * A description of the perk provided by the equipment.
     */
    private String perkDescription;

    /**
     * The multiplier applied to the amount of time available to answer
     * questions.
     */
    private double timeMult;

    /**
     * Creates an Equipment object with the specified properties.
     *
     * @param value
     *            the purchase cost of the equipment
     * @param displayName
     *            the name displayed to the player
     * @param perkDescription
     *            a description of the equipment's perk
     * @param timeMult
     *            the multiplier applied to the question answer time
     */
    private Equipment(
        int value,
        String displayName,
        String perkDescription,
        double timeMult)
    {
        this.value = value;
        this.displayName = displayName;
        this.perkDescription = perkDescription;
        this.timeMult = timeMult;
    }


    /**
     * Gets the purchase cost of the equipment.
     *
     * @return the equipment's purchase cost
     */
    public int getValue()
    {
        return value;
    }


    /**
     * Gets the name displayed to the player.
     *
     * @return the equipment's display name
     */
    public String getDisplayName()
    {
        return displayName;
    }


    /**
     * Gets the description of the equipment's perk.
     *
     * @return the equipment's perk description
     */
    public String getPerkDescription()
    {
        return perkDescription;
    }


    /**
     * Gets the time multiplier provided by the equipment.
     *
     * @return the multiplier applied to the question answer time
     */
    public double getTimeMult()
    {
        return timeMult;
    }


    /**
     * Returns the display name of the equipment.
     *
     * @return the equipment's display name
     */
    @Override
    public String toString()
    {
        return displayName;
    }
}
