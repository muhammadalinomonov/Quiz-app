package uz.gita.myquizapp.play.model;

public class TestData {
    private String question;
    private String variant1;
    private String variant2;
    private String variant3;
    private String variant4;
    private String answer;
    private int image;

    public TestData(String question, String variant1, String variant2, String variant3, String variant4, String answer, int image) {
        this.question = question;
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4 = variant4;
        this.answer = answer;
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public String getVariant1() {
        return variant1;
    }

    public String getVariant2() {
        return variant2;
    }

    public String getVariant3() {
        return variant3;
    }

    public String getVariant4() {
        return variant4;
    }

    public String getAnswer() {
        return answer;
    }

    public int getImage() {
        return image;
    }
}
