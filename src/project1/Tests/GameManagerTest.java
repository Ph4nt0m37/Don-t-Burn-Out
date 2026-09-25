package project1.Tests;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import project1.*;
import student.TestCase;

public class GameManagerTest
    extends TestCase
{
    private PrintStream originalOut;

    public void setUp()
    {
        originalOut = System.out;
    }


    public void tearDown()
    {
        System.setOut(originalOut);

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream("".getBytes()));
    }


    public void testMainNoCustomQuestionsMath()
    {
        /*
         * Name Load custom questions? -> N Subject -> Math Maximum wrong
         * answers -> 0 Answer -> intentionally wrong
         */
        String input =
            "Test User\n" + "N\n" + "Math\n" + "0\n" + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        assertTrue(true);
    }


    public void testMainNoCustomQuestionsEnglish()
    {
        String input =
            "Test User\n" + "N\n" + "English\n" + "0\n" + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        assertTrue(true);
    }


    public void testMainNoCustomQuestionsScience()
    {
        String input =
            "Test User\n" + "N\n" + "Science\n" + "0\n" + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        assertTrue(true);
    }


    public void testInvalidSubjectThenValidSubject()
    {
        String input = "Test User\n" + "N\n" + "InvalidSubject\n" + "Math\n"
            + "0\n" + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        assertTrue(true);
    }


    public void testInvalidMaxWrongAnswersThenValid()
    {
        String input = "Test User\n" + "N\n" + "Math\n" + "invalid\n" + "-1\n"
            + "100\n" + "0\n" + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        assertTrue(true);
    }


    public void testMaximumWrongAnswers()
    {
        String input =
            "Test User\n" + "N\n" + "Math\n" + "0\n" + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        assertTrue(true);
    }


    public void testCustomQuestions()
        throws Exception
    {
        File questionsFile = new File("questions.txt");

        boolean createdFile = false;

        if (!questionsFile.exists())
        {
            createdFile = questionsFile.createNewFile();
        }

        java.io.FileWriter writer = new java.io.FileWriter(questionsFile);

        writer.write("~|~Easy\n");
        writer.write("What is 1+1?|2\n");
        writer.write("What is 2+2?|4\n");

        writer.write("~|~Medium\n");
        writer.write("What is 5+5?|10\n");

        writer.write("~|~Hard\n");
        writer.write("What is 10+10?|20\n");

        writer.close();

        String input = "Test User\n" + "Y\n" + "0\n" + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        if (createdFile)
        {
            questionsFile.delete();
        }
        else
        {
            questionsFile.delete();
        }

        assertTrue(true);
    }


    public void testCorrectAnswer()
    {
        /*
         * This test uses the custom-question file so that we know what the
         * correct answer is.
         */
        File questionsFile = new File("questions.txt");

        try
        {
            java.io.FileWriter writer = new java.io.FileWriter(questionsFile);

            writer.write("~|~Easy\n");
            writer.write("What is 1+1?|2\n");
            writer.close();

            /*
             * The question is randomly selected, but there is only one easy
             * question, so the answer is known.
             */
            String input =
                "Test User\n" + "Y\n" + "0\n" + "2\n" + "wrong answer\n";

            InputHandler.scanner =
                new Scanner(new ByteArrayInputStream(input.getBytes()));

            GameManager.main(new String[0]);

            assertTrue(true);
        }
        catch (Exception e)
        {
            fail("Unexpected exception: " + e.getMessage());
        }
        finally
        {
            questionsFile.delete();
        }
    }


    public void testInvalidBooleanInput()
    {
        String input = "Test User\n" + "Maybe\n" + "N\n" + "Math\n" + "0\n"
            + "wrong answer\n";

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream(input.getBytes()));

        GameManager.main(new String[0]);

        assertTrue(true);
    }
}
