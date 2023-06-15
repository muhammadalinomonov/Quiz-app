package uz.gita.myquizapp.play.model;

public class AnswerData {
    private int answer;
    private int answerByPosition;

    public AnswerData(int answer, int answerByPosition) {
        this.answer = answer;
        this.answerByPosition = answerByPosition;
    }
    public int getAnswer(){
        return answer;
    }

    public int getAnswerByPosition() {
        return answerByPosition;
    }

    public void setAnswerByPosition(int answerByPosition) {
        this.answerByPosition = answerByPosition;
    }
}
