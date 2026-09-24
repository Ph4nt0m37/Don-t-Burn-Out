package project1;
public class User
{
    private String playerName;
    private int money = 0;
    private int wrongAnswers = 0;
    
    public User(String name) {
        this.playerName = name;
    }

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
