package project1.Tests;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import project1.InputHandler;
import student.TestCase;

public class InputHandlerTest
    extends TestCase
{
    /**
     * Sets up each test method.
     */
    public void setUp()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("".getBytes()));
    }


    /**
     * Tests getUserInput() with a normal string.
     */
    public void testGetUserInput()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("Hello World\n".getBytes()));

        String result = InputHandler.getUserInput("Enter text: ");

        assertEquals("Hello World", result);
    }
    
    /**
     * Tests getUserInput() when the user enters a valid answer.
     */
    public void testGetUserInputValidAnswer()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("yes\n".getBytes()));

        String[] validAnswers = {"yes", "no"};

        String result = InputHandler.getUserInput(
            "Enter yes or no: ",
            validAnswers,
            "Invalid answer");

        assertEquals("yes", result);
    }


    /**
     * Tests getUserInput() when the user enters another valid answer.
     */
    public void testGetUserInputSecondValidAnswer()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("no\n".getBytes()));

        String[] validAnswers = {"yes", "no"};

        String result = InputHandler.getUserInput(
            "Enter yes or no: ",
            validAnswers,
            "Invalid answer");

        assertEquals("no", result);
    }


    /**
     * Tests getUserInput() when the user enters an invalid answer
     * before entering a valid answer.
     */
    public void testGetUserInputInvalidThenValid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("maybe\nyes\n".getBytes()));

        String[] validAnswers = {"yes", "no"};

        String result = InputHandler.getUserInput(
            "Enter yes or no: ",
            validAnswers,
            "Invalid answer");

        assertEquals("yes", result);
    }


    /**
     * Tests getUserInput() with multiple invalid answers
     * before entering a valid answer.
     */
    public void testGetUserInputMultipleInvalidAnswers()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream(
                "maybe\nperhaps\nhello\nno\n".getBytes()));

        String[] validAnswers = {"yes", "no"};

        String result = InputHandler.getUserInput(
            "Enter yes or no: ",
            validAnswers,
            "Invalid answer");

        assertEquals("no", result);
    }


    /**
     * Tests getUserInput() with multiple valid answers.
     */
    public void testGetUserInputDifferentValidAnswers()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("apple\n".getBytes()));

        String[] validAnswers = {"apple", "banana", "orange"};

        String result = InputHandler.getUserInput(
            "Choose a fruit: ",
            validAnswers,
            "Invalid fruit");

        assertEquals("apple", result);
    }


    /**
     * Tests getUserIntInput() with a valid number.
     */
    public void testGetUserIntInputValid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ", 1, 100, "Invalid input");

        assertEquals(50, result);
    }


    /**
     * Tests getUserIntInput() with the minimum value.
     */
    public void testGetUserIntInputMinimum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("1\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ", 1, 100, "Invalid input");

        assertEquals(1, result);
    }


    /**
     * Tests getUserIntInput() with the maximum value.
     */
    public void testGetUserIntInputMaximum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("100\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ", 1, 100, "Invalid input");

        assertEquals(100, result);
    }


    /**
     * Tests getUserIntInput() with a value below the minimum.
     */
    public void testGetUserIntInputBelowMinimum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("-1\n50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ", 1, 100, "Invalid input");

        assertEquals(50, result);
    }


    /**
     * Tests getUserIntInput() with a value above the maximum.
     */
    public void testGetUserIntInputAboveMaximum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("101\n50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ", 1, 100, "Invalid input");

        assertEquals(50, result);
    }


    /**
     * Tests getUserIntInput() with non-numeric input.
     */
    public void testGetUserIntInputNonNumeric()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("abc\n50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ", 1, 100, "Invalid input");

        assertEquals(50, result);
    }


    /**
     * Tests getUserIntInput() with multiple invalid inputs.
     */
    public void testGetUserIntInputMultipleInvalidInputs()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream(
                "abc\n-5\n101\n42\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ", 1, 100, "Invalid input");

        assertEquals(42, result);
    }
}