package uz.gita.myquizapp.play.ui.game;

import java.util.List;

import uz.gita.myquizapp.play.model.AnswerData;
import uz.gita.myquizapp.play.model.TestData;

public interface GameContract {
     interface Model {
        boolean check(String userAnswer);
        TestData getNextData();

//        void saveData();
         void saveUserAnswers(List<String > answers);
        boolean hasQuestion();

        int getCurrentPos();

        void writeResultRepository();

        int getCorrectCount();

        int getWrongCount();

        int getTotalCount();

        void setIndexesOfChecked(List<Integer> list);
        void setIndexesOfAnswers(List<Integer> list);

        void setStates(List<Integer> states);
    }

    interface View {
        void clearOldAnswer();

        void describeTest(TestData testData, int currentPos, int totalPos);

        void stateNextButton(boolean bool);

        void openResultActivity();
    }
    interface Presenter {

        void clickSkipButton();
        void clickNextButton(int index);

        void selectUserAnswer(String userAnswer, int checkedIndex);

        int getTotalCount();
        int getCorrectCount();
        int getWrongCount();

    }


}

