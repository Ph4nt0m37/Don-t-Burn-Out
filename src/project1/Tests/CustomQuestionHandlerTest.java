package project1.Tests;

import java.io.File;
import java.io.FileWriter;
import project1.*;
import java.io.FileNotFoundException;

import student.TestCase;

public class CustomQuestionHandlerTest
    extends TestCase
{
    private File testFile;

    public void setUp()
        throws Exception
    {
        testFile = new File("testQuestions.txt");

        FileWriter writer = new FileWriter(testFile);

        writer.write("~|~Easy\n");
        writer.write("What is 1+1?|2\n");
        writer.write("What color is the sky?|blue\n");
        writer.write("\n");

        writer.write("~|~Medium\n");
        writer.write("What is 5*5?|25\n");
        writer.write("What is the capital of France?|Paris\n");

        writer.write("~|~Hard\n");
        writer.write("What is 12*12?|144\n");
        writer.write("What is the square root of 81?|9\n");

        writer.close();
    }


    public void tearDown()
    {
        if (testFile != null && testFile.exists())
        {
            testFile.delete();
        }
    }


    public void testEasyQuestion()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] result = handler.getQuestionAndAnswer(0);

        assertNotNull(result);
        assertEquals(2, result.length);

        assertTrue(
            result[0].equals("What is 1+1?")
                || result[0].equals("What color is the sky?"));

        assertTrue(result[1].equals("2") || result[1].equals("blue"));
    }


    public void testMediumQuestion()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] result = handler.getQuestionAndAnswer(1);

        assertNotNull(result);
        assertEquals(2, result.length);

        assertTrue(
            result[0].equals("What is 5*5?")
                || result[0].equals("What is the capital of France?"));
    }


    public void testHardQuestion()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] result = handler.getQuestionAndAnswer(2);

        assertNotNull(result);
        assertEquals(2, result.length);

        assertTrue(
            result[0].equals("What is 12*12?")
                || result[0].equals("What is the square root of 81?"));
    }


    public void testNegativeDifficulty()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] result = handler.getQuestionAndAnswer(-1);

        assertNotNull(result);
        assertEquals(2, result.length);

        assertTrue(
            result[0].equals("What is 1+1?")
                || result[0].equals("What color is the sky?"));
    }


    public void testHighDifficulty()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        String[] result = handler.getQuestionAndAnswer(3);

        assertNotNull(result);
        assertEquals(2, result.length);

        assertTrue(
            result[0].equals("What is 1+1?")
                || result[0].equals("What color is the sky?"));
    }


    public void testBlankLines()
        throws Exception
    {
        CustomQuestionHandler handler =
            new CustomQuestionHandler("testQuestions.txt");

        // The blank line should be ignored.
        String[] easy = handler.getQuestionAndAnswer(0);

        assertNotNull(easy);
        assertEquals(2, easy.length);
    }


    public void testFileNotFound()
    {
        try
        {
            new CustomQuestionHandler("fileThatDoesNotExist.txt");
            fail("Expected FileNotFoundException");
        }
        catch (FileNotFoundException e)
        {
            // Expected exception
        }
    }
}
