package project1.Tests;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import project1.*;
import student.TestCase;

public class InputHandlerTest extends TestCase
{
    public void setUp()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("".getBytes()));
    }

    public void testGetUserInput()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("Hello World\n".getBytes()));

        String result = InputHandler.getUserInput("Enter text: ");

        assertEquals("Hello World", result);
    }

    public void testGetUserInputValidFirstAnswer()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("Yes\n".getBytes()));

        String result = InputHandler.getUserInput(
            "Enter answer: ",
            new String[] {"Yes", "No"},
            "Invalid!");

        assertEquals("Yes", result);
    }

    public void testGetUserInputValidSecondAnswer()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("No\n".getBytes()));

        String result = InputHandler.getUserInput(
            "Enter answer: ",
            new String[] {"Yes", "No"},
            "Invalid!");

        assertEquals("No", result);
    }

    public void testGetUserInputCaseInsensitive()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("yEs\n".getBytes()));

        String result = InputHandler.getUserInput(
            "Enter answer: ",
            new String[] {"Yes", "No"},
            "Invalid!");

        assertEquals("yEs", result);
    }

    public void testGetUserInputInvalidThenValid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("Maybe\nYes\n".getBytes()));

        String result = InputHandler.getUserInput(
            "Enter answer: ",
            new String[] {"Yes", "No"},
            "Invalid!");

        assertEquals("Yes", result);
    }

    public void testGetUserInputMultipleInvalid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream(
                "Maybe\nPerhaps\nHello\nNo\n".getBytes()));

        String result = InputHandler.getUserInput(
            "Enter answer: ",
            new String[] {"Yes", "No"},
            "Invalid!");

        assertEquals("No", result);
    }

    public void testGetUserIntInputValid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ",
            1,
            100,
            "Invalid!");

        assertEquals(50, result);
    }

    public void testGetUserIntInputMinimum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("1\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ",
            1,
            100,
            "Invalid!");

        assertEquals(1, result);
    }

    public void testGetUserIntInputMaximum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("100\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ",
            1,
            100,
            "Invalid!");

        assertEquals(100, result);
    }

    public void testGetUserIntInputBelowMinimum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("-1\n50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ",
            1,
            100,
            "Invalid!");

        assertEquals(50, result);
    }

    public void testGetUserIntInputAboveMaximum()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("101\n50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ",
            1,
            100,
            "Invalid!");

        assertEquals(50, result);
    }

    public void testGetUserIntInputNonNumeric()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("abc\n50\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ",
            1,
            100,
            "Invalid!");

        assertEquals(50, result);
    }

    public void testGetUserIntInputMultipleInvalid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream(
                "abc\n-5\n101\n42\n".getBytes()));

        int result = InputHandler.getUserIntInput(
            "Enter number: ",
            0,
            99,
            "Invalid!");

        assertEquals(42, result);
    }

    public void testGetUserBoolInputYes()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("Yes\n".getBytes()));

        boolean result = InputHandler.getUserBoolInput(
            "Continue? ",
            "Invalid!");

        assertTrue(result);
    }

    public void testGetUserBoolInputY()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("Y\n".getBytes()));

        boolean result = InputHandler.getUserBoolInput(
            "Continue? ",
            "Invalid!");

        assertTrue(result);
    }

    public void testGetUserBoolInputNo()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("No\n".getBytes()));

        boolean result = InputHandler.getUserBoolInput(
            "Continue? ",
            "Invalid!");

        assertFalse(result);
    }

    public void testGetUserBoolInputN()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("N\n".getBytes()));

        boolean result = InputHandler.getUserBoolInput(
            "Continue? ",
            "Invalid!");

        assertFalse(result);
    }

    public void testGetUserBoolInputCaseInsensitive()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("yEs\n".getBytes()));

        boolean result = InputHandler.getUserBoolInput(
            "Continue? ",
            "Invalid!");

        assertTrue(result);
    }

    public void testGetUserBoolInputInvalidThenValid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream("Maybe\nY\n".getBytes()));

        boolean result = InputHandler.getUserBoolInput(
            "Continue? ",
            "Invalid!");

        assertTrue(result);
    }

    public void testGetUserBoolInputMultipleInvalid()
    {
        InputHandler.scanner = new Scanner(
            new ByteArrayInputStream(
                "Maybe\nPerhaps\nHello\nN\n".getBytes()));

        boolean result = InputHandler.getUserBoolInput(
            "Continue? ",
            "Invalid!");

        assertFalse(result);
    }
}