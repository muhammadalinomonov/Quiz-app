package uz.gita.myquizapp.play.ui.game;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import uz.gita.myquizapp.play.LocalStorage;
import uz.gita.myquizapp.play.model.TestData;
import uz.gita.myquizapp.play.repository.AppRepository;

public class GamePresenter implements GameContract.Presenter {
    private GameContract.Model model;
    ArrayList<Integer> answersState;
    private List<Integer> stateAnswer;
    private List<Integer> indexesOfAnswers;
    private List<String> userAnswers;
    private List<Integer> indexesOfChecked;

//    private AppRepository repository;
    private TestData currentTest;
    private GameContract.View view;
    private String userAnswer;

    public GamePresenter(GameContract.View view) {
        answersState = new ArrayList<>();
        stateAnswer = new ArrayList<>();
        indexesOfChecked = new ArrayList<>();
        userAnswers = new ArrayList<>();
        model = new GameModel();

        this.view = view;


        loadNextData();

    }

    private void loadNextData() {
        if (model.hasQuestion()){
            currentTest = model.getNextData();
            view.clearOldAnswer();
            view.describeTest(currentTest, model.getCurrentPos(), model.getTotalCount());
        }
        else {
            model.saveUserAnswers(userAnswers);
            model.setIndexesOfAnswers(indexesOfAnswers);
            model.setIndexesOfChecked(indexesOfChecked);
            model.setStates(stateAnswer);
            model.writeResultRepository();
            view.openResultActivity();
        }


    }

    @Override
    public void clickSkipButton() {
        indexesOfChecked.add(-1);
        userAnswers.add("");
        stateAnswer.add(0);
        loadNextData();
        view.stateNextButton(false);
        findIndexesOfAnswers();
    }


    @Override
    public void clickNextButton(int index) {
        indexesOfChecked.add(index);
        userAnswers.add(userAnswer);
        if(model.check(userAnswer)){
            Log.d("TTT","Tog'ri javob");
            stateAnswer.add(1);
            indexesOfChecked.add(index);
        }
        else {
            Log.d("TTT", "Noto'g'ri");
            stateAnswer.add(-1);
        }
        Log.d("TTT", "Shu yer ishlamayapti");
        loadNextData();
        view.stateNextButton(false);
        findIndexesOfAnswers();
    }

    @Override
    public void selectUserAnswer(String userAnswer, int index) {
        this.userAnswer = userAnswer;
        view.stateNextButton(true);
    }

    @Override
    public int getTotalCount() {
        return model.getTotalCount();
    }

    @Override
    public int getCorrectCount() {
        return model.getCorrectCount();
    }

    @Override
    public int getWrongCount() {
        return model.getWrongCount();
    }

    void findIndexesOfAnswers(){
        indexesOfAnswers = new ArrayList<>();
        if (currentTest.getAnswer().equals(currentTest.getVariant1())){
            indexesOfAnswers.add(0);
        }
        if (currentTest.getAnswer().equals(currentTest.getVariant2())){
            indexesOfAnswers.add(1);
        }
        if (currentTest.getAnswer().equals(currentTest.getVariant3())){
            indexesOfAnswers.add(2);
        }
        if (currentTest.getAnswer().equals(currentTest.getVariant4())){
            indexesOfAnswers.add(3);
        }
    }


}
