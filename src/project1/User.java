package project1;
public class User
{
    private String playerName;
    private int money;
    private int wrongAnswers;

    public int getMoney() {
        return money;
        
    }
    public void setMoney(int x) {
        money=x;
        
    }
    public int getNumFailedQuestions() {
        return wrongAnswers;
        
    }
   
    public void setNumFailedQuestions(int numOfQuestions) {
        wrongAnswers=numOfQuestions;
        
    }


}
