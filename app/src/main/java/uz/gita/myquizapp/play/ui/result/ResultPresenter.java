package uz.gita.myquizapp.play.ui.result;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import uz.gita.myquizapp.play.model.TestData;
import uz.gita.myquizapp.play.repository.AppRepository;

public class ResultPresenter implements ResultContract.Presenter{
    ResultContract.Model model;
    private ResultContract.View view;
    private int stateQuestion;
    private List<String> variants;
    public ResultPresenter(ResultContract.View view) {
        model = new ResultModel();
        this.view = view;
    }

    /*private void loadNextData(){
        if (model.hasQuestion()){
            view.describe(model.getNextData(), model.getCurrentPos(), model.getTotalCount());
        }
    }*/



    @Override
    public void loadToView() {


        view.loadData(model.getCorrectCount(), model.getWrongCount(), model.getSkipped());
        for (int i = 0; i < model.getTotalCount(); i++) {
            int userIndex = -1;
            int correctIndex = 0;
            TestData testData = model.getNextData();
            variants = new ArrayList<>();
            variants.add(testData.getVariant1());
            variants.add(testData.getVariant2());
            variants.add(testData.getVariant3());
            variants.add(testData.getVariant4());

            for (int j = 0; j < 4; j++) {
                if (variants.get(j).equals(testData.getAnswer()))
                    correctIndex = j;
                if (variants.get(j).equals(model.getUserAnswers()))
                    userIndex = j;
            }
            view.describe(testData, model.getCurrentPos(), model.getTotalCount(), correctIndex, userIndex);
        }
        /*view.describe(model.getNextData(), model.getCurrentPos(), model.getTotalCount());
        view.loadData(model.getCorrectCount(), model.getWrongCount(), model.getTotalCount() - model.getCorrectCount() - model.getWrongCount());*/
    }
}
