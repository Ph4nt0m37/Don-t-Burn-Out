package project1.Tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import project1.CustomQuestionHandler;
import student.TestCase;

/**
 * CustomQuestionHandler Test class
 *
 * @author Paulo Korowajczuk Nader
 * @version 09.24.2026
 */
public class CustomQuestionHandlerTest
    extends TestCase
{
    private File testFile;


    /**
     * Sets up the test file before each test.
     */
    public void setUp()
        throws IOException
    {
        testFile = new File("testQuestions.txt");

        PrintWriter writer = new PrintWriter(
            new FileWriter(testFile));

        writer.println("~|~Easy");
        writer.println("What is 1+1?|2");
        writer.println("What color is the sky?|blue");
        writer.println();

        writer.println("~|~Medium");
        writer.println("What is 5*5?|25");
        writer.println("What is the capital of France?|Paris");

        writer.println("~|~Hard");
        writer.println("What is 12*12?|144");
        writer.println("What is the square root of 81?|9");

        writer.close();
    }


    /**
     * Removes the test file after each test.
     */
    public void tearDown()
    {
        if (testFile != null && testFile.exists()) {
            testFile.delete();
        }
    }


    /**
     * Tests that an easy question can be retrieved.
     */
    public void testGetEasyQuestion()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] question =
            handler.getQuestionAndAnswer(0);

        assertNotNull(question);
        assertEquals(2, question.length);

        assertTrue(
            question[0].equals("What is 1+1?")
                || question[0].equals("What color is the sky?"));

        assertTrue(
            question[1].equals("2")
                || question[1].equals("blue"));
    }


    /**
     * Tests that a medium question can be retrieved.
     */
    public void testGetMediumQuestion()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] question =
            handler.getQuestionAndAnswer(1);

        assertNotNull(question);
        assertEquals(2, question.length);

        assertTrue(
            question[0].equals("What is 5*5?")
                || question[0].equals(
                    "What is the capital of France?"));
    }


    /**
     * Tests that a hard question can be retrieved.
     */
    public void testGetHardQuestion()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] question =
            handler.getQuestionAndAnswer(2);

        assertNotNull(question);
        assertEquals(2, question.length);

        assertTrue(
            question[0].equals("What is 12*12?")
                || question[0].equals(
                    "What is the square root of 81?"));
    }


    /**
     * Tests that a negative difficulty uses easy questions.
     */
    public void testNegativeDifficulty()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] question =
            handler.getQuestionAndAnswer(-1);

        assertNotNull(question);
        assertEquals(2, question.length);

        assertTrue(
            question[0].equals("What is 1+1?")
                || question[0].equals("What color is the sky?"));
    }


    /**
     * Tests that a difficulty greater than 2 uses easy questions.
     */
    public void testInvalidHighDifficulty()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] question =
            handler.getQuestionAndAnswer(3);

        assertNotNull(question);
        assertEquals(2, question.length);

        assertTrue(
            question[0].equals("What is 1+1?")
                || question[0].equals("What color is the sky?"));
    }


    /**
     * Tests that a file with blank lines is loaded correctly.
     */
    public void testBlankLines()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] question =
            handler.getQuestionAndAnswer(0);

        assertNotNull(question);
    }


    /**
     * Tests that a nonexistent file throws FileNotFoundException.
     */
    public void testFileNotFound()
    {
        try {
            new CustomQuestionHandler("fileThatDoesNotExist.txt");

            fail("Expected FileNotFoundException");
        }
        catch (java.io.FileNotFoundException e) {
            // Expected exception
        }
    }
}