package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Handles the loading and retrieval of custom questions from a file.
 * <p>
 * Custom questions are organized into three difficulty levels: easy, medium,
 * and hard. The questions file uses difficulty headers to determine which list
 * each question and answer pair should be added to.
 * </p>
 * <p>
 * Each question in the file should contain a question and answer separated by a
 * vertical bar ({@code |}).
 * </p>
 *
 * @author Paulo Korowajczuk Nader
 */
public class CustomQuestionHandler
{
    private String questionsFilePath;

    private int difficultyNum = 0;

    private ArrayList<String[]> easyQuestions = new ArrayList<>();

    private ArrayList<String[]> mediumQuestions = new ArrayList<>();

    private ArrayList<String[]> hardQuestions = new ArrayList<>();

    /**
     * Creates a CustomQuestionHandler and loads the custom questions from the
     * specified file.
     *
     * @param questionsFilePath
     *            the path to the file containing the custom questions and
     *            answers
     * @throws FileNotFoundException
     *             if the specified questions file cannot be found
     */
    public CustomQuestionHandler(String questionsFilePath)
        throws FileNotFoundException
    {
        this.questionsFilePath = questionsFilePath;

        loadCustomQuestions();
    }


    private void loadCustomQuestions()
        throws FileNotFoundException
    {
        Scanner questionFileScanner = new Scanner(new File(questionsFilePath));

        while (questionFileScanner.hasNextLine())
        {

            String nextLine = questionFileScanner.nextLine();

            if (nextLine.length() > 0)
            {

                if (nextLine.startsWith("~|~"))
                {

                    if (nextLine.contains("Hard"))
                    {

                        difficultyNum = 2;

                    }
                    else if (nextLine.contains("Medium"))
                    {

                        difficultyNum = 1;

                    }
                    else
                    {

                        difficultyNum = 0;

                    }

                }
                else
                {

                    String[] qAndA = nextLine.split("[|]");

                    if (difficultyNum == 2)
                    {

                        hardQuestions.add(qAndA);

                    }
                    else if (difficultyNum == 1)
                    {

                        mediumQuestions.add(qAndA);

                    }
                    else
                    {

                        easyQuestions.add(qAndA);

                    }
                }
            }
        }
    }


    /**
     * Retrieves a random custom question and its corresponding answer from the
     * specified difficulty level.
     * <p>
     * A difficulty value of {@code 0} selects from the easy questions,
     * {@code 1} selects from the medium questions, and {@code 2} selects from
     * the hard questions. Any difficulty value other than {@code 1} or
     * {@code 2} is treated as easy.
     * </p>
     *
     * @param difficulty
     *            the difficulty level of the question to retrieve
     * @return a two-element String array containing the question at index
     *             {@code 0} and its answer at index {@code 1}
     * @throws IllegalArgumentException
     *             if the selected difficulty contains no questions
     */
    public String[] getQuestionAndAnswer(int difficulty)
    {
        Random rand = new Random();

        if (difficulty == 2)
        {

            return hardQuestions.get(rand.nextInt(hardQuestions.size()));

        }
        else if (difficulty == 1)
        {

            return mediumQuestions.get(rand.nextInt(mediumQuestions.size()));

        }
        else
        {

            return easyQuestions.get(rand.nextInt(easyQuestions.size()));

        }
    }
}
