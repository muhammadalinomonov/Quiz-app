package uz.gita.myquizapp.play.ui.result;

import java.util.ArrayList;
import java.util.List;

import uz.gita.myquizapp.play.model.TestData;
import uz.gita.myquizapp.play.repository.AppRepository;

public class ResultModel implements ResultContract.Model {
    AppRepository repository;
    private final int MAX_VALUE = 10;
    private List<TestData> tests;

    private int currentPos;

    public ResultModel() {
        repository = AppRepository.getInstance();
        tests = repository.getOldList();

    }

    @Override
    public int getCorrectCount() {
        return repository.getCorrectCount();
    }

    @Override
    public int getWrongCount() {
        return repository.getWrongCount();
    }

    @Override
    public int getSkipped() {
        return repository.getSkipCount();
    }


    @Override
    public String getUserAnswers() {
        return repository.getAnswers().get(currentPos - 1);
    }


    @Override
    public TestData getNextData() {
        return tests.get(currentPos++);
    }

    @Override
    public boolean hasQuestion() {
        return currentPos < MAX_VALUE;
    }

    @Override
    public int getCurrentPos() {
        return currentPos;
    }

    @Override
    public int getTotalCount() {
        return MAX_VALUE;
    }

}
