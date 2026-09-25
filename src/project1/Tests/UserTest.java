package project1.Tests;

import project1.User;
import student.TestCase;

/**
 * Tests the User class.
 * 
 * @author Isabella Zhang
 * @version 2026.09.18
 */
public class UserTest
    extends TestCase
{
    private User user;

    /**
     * Sets up a User before each test.
     */
    public void setUp()
    {
        user = new User("John");
    }


    /**
     * Tests setting and getting money.
     */
    public void testMoney()
    {
        user.setMoney(100);
        assertEquals(100, user.getMoney());

        user.setMoney(0);
        assertEquals(0, user.getMoney());

        user.setMoney(500);
        assertEquals(500, user.getMoney());
    }


    /**
     * Tests setting and getting the number of failed questions.
     */
    public void testNumFailedQuestions()
    {
        user.setNumFailedQuestions(3);
        assertEquals(3, user.getNumFailedQuestions());

        user.setNumFailedQuestions(0);
        assertEquals(0, user.getNumFailedQuestions());

        user.setNumFailedQuestions(10);
        assertEquals(10, user.getNumFailedQuestions());
    }
}
