package project1;

/**
 * Represents the player of the Don't Burn Out game.
 * <p>
 * The User class stores information about the player, including their name,
 * current amount of money, and number of questions they have answered
 * incorrectly.
 * </p>
 * 
 * @author Isabella Zhang
 */
public class User
{
    /**
     * The name of the player.
     */
    private String playerName;

    /**
     * The amount of money currently owned by the player.
     */
    private int money = 0;

    /**
     * The number of questions the player has answered incorrectly.
     */
    private int wrongAnswers = 0;

    /**
     * Creates a new User with the specified player name.
     *
     * @param name
     *            the name of the player
     */
    public User(String name)
    {
        this.playerName = name;
    }


    /**
     * Gets the amount of money currently owned by the player.
     *
     * @return the player's current amount of money
     */
    public int getMoney()
    {
        return money;
    }


    /**
     * Sets the player's current amount of money.
     *
     * @param x
     *            the new amount of money
     */
    public void setMoney(int x)
    {
        money = x;
    }


    /**
     * Gets the number of questions the player has answered incorrectly.
     *
     * @return the number of incorrect answers
     */
    public int getNumFailedQuestions()
    {
        return wrongAnswers;
    }


    /**
     * Sets the number of questions the player has answered incorrectly.
     *
     * @param numOfQuestions
     *            the new number of incorrect answers
     */
    public void setNumFailedQuestions(int numOfQuestions)
    {
        wrongAnswers = numOfQuestions;
    }
}
