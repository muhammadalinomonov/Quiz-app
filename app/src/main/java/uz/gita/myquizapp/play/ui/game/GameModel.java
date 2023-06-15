package uz.gita.myquizapp.play.ui.game;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import uz.gita.myquizapp.play.LocalStorage;
import uz.gita.myquizapp.play.model.AnswerData;
import uz.gita.myquizapp.play.model.TestData;
import uz.gita.myquizapp.play.repository.AppRepository;

public class GameModel implements GameContract.Model {
    private final int MAX_COUNT = 10;
    private AppRepository repository;
    private List<Integer> states;
    private ArrayList<TestData> tests;
    private int currentPos;
    private int correctCount;
    private int wrongCount;

    @SuppressLint("SuspiciousIndentation")
    GameModel() {

        tests = new ArrayList<>();
        repository = AppRepository.getInstance();

        Log.d("TTT", "testtugadi");
        tests = new ArrayList<>(MAX_COUNT);
        getNeedData();

    }

    private void getNeedData() {
        repository.shuffle();
        tests.addAll(repository.getNeedDataByCount(MAX_COUNT));
    }

    @Override
    public boolean check(String userAnswer) {
        Log.d("TTT", "check");
        if (tests.get(currentPos - 1).getAnswer().equals(userAnswer)) {
            correctCount++;
            return true;
        }
        wrongCount++;
        return false;
    }

    @Override
    public TestData getNextData() {
        Log.d("TTT", "getNextData()");
        return tests.get(currentPos++);
    }

    @Override
    public void saveUserAnswers(List<String> answers) {
        repository.setAnswers(answers);
    }


   /* @Override
    public void saveData() {
        localStorage.setList(tests);
        localStorage.setCurrentPosition(currentPos - 1);
        localStorage.setState(true);
    }*/

    @Override
    public boolean hasQuestion() {
        return currentPos < MAX_COUNT;
    }

    @Override
    public int getCurrentPos() {
        return currentPos;
    }


    public int getCorrectCount() {
        return correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    @Override
    public void writeResultRepository() {
        if (!hasQuestion()) {
            repository.setOldListState(states);
            repository.setSkipCount(MAX_COUNT - correctCount - wrongCount);
            repository.setCorrectCount(correctCount);
            repository.setWrongCount(wrongCount);
        }
    }

    @Override
    public int getTotalCount() {
        return MAX_COUNT;
    }

    @Override
    public void setIndexesOfChecked(List<Integer> list) {
        repository.setIndexesOfChecked(list);
    }

    @Override
    public void setIndexesOfAnswers(List<Integer> list) {
        repository.setIndexesOfAnswers(list);
    }

    public void setStates(List<Integer> states) {
        this.states = states;
        repository.setOldListState(states);
    }
}

