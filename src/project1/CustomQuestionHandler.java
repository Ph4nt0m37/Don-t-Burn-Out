package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CustomQuestionHandler
{
    private String questionsFilePath;
    
    private int difficultyNum = 0;
    private ArrayList<String[]> easyQuestions = new ArrayList<>();
    private ArrayList<String[]> mediumQuestions = new ArrayList<>();
    private ArrayList<String[]> hardQuestions = new ArrayList<>();
    
    public CustomQuestionHandler(String questionsFilePath) throws FileNotFoundException {
        this.questionsFilePath = questionsFilePath;
        loadCustomQuestions();
    }

    private void loadCustomQuestions() throws FileNotFoundException {
        Scanner questionFileScanner = new Scanner(new File(questionsFilePath));
        while (questionFileScanner.hasNextLine()) {
            String nextLine = questionFileScanner.nextLine();
            if (nextLine.length()>0) {
                if (nextLine.startsWith("~|~")) {
                    if (nextLine.contains("Hard")) {
                        difficultyNum = 2;
                    }else if (nextLine.contains("Medium")) {
                        difficultyNum = 1;
                    }else {
                        difficultyNum = 0;
                    }
                }else {
                    String[] qAndA = nextLine.split("[|]"); //regex awesomeness
                    if (difficultyNum == 2) {
                        hardQuestions.add(qAndA);
                    }else if (difficultyNum == 1) {
                        mediumQuestions.add(qAndA);
                    }else {
                        easyQuestions.add(qAndA);
                    }
                }
            }
        }
//        System.out.println(easyQuestions.toString());
//        System.out.println(mediumQuestions.toString());
//        System.out.println(hardQuestions.toString());
    }
    
    public String[] getQuestionAndAnswer(int difficulty) {
        Random rand = new Random();
        if (difficulty == 2) {
            return hardQuestions.get(rand.nextInt(hardQuestions.size()));
        }else if (difficulty == 1) {
            return mediumQuestions.get(rand.nextInt(mediumQuestions.size()));
        }else {
            return easyQuestions.get(rand.nextInt(easyQuestions.size()));
        }
    }
    
}
