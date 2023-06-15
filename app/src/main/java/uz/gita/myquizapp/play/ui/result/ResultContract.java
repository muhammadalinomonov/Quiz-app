package uz.gita.myquizapp.play.ui.result;

import java.util.List;

import uz.gita.myquizapp.play.model.TestData;

public interface ResultContract {
    interface Model {
        int getCorrectCount();

        int getWrongCount();

        int getSkipped();

        String  getUserAnswers();

        TestData getNextData();

//        void saveData();

        boolean hasQuestion();

        int getCurrentPos();

        int getTotalCount();
    }

    interface View {
        void describe(TestData testData, int currentPos, int getTotal, int indexOfCorrect, int indexOfChecked);

        void loadView();
        void clickButtonHome();

        void loadData(int correct, int wrong, int skip);
    }

    interface Presenter {
        void loadToView();


    }
}
