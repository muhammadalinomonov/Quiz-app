package uz.gita.myquizapp.play.ui.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uz.gita.myquizapp.R;
import uz.gita.myquizapp.play.model.TestData;
import uz.gita.myquizapp.play.repository.AppRepository;

public class ResultActivity extends AppCompatActivity implements ResultContract.View {

    ResultPresenter presenter;
    TextView correctCount;
    TextView inCorrectCount;
    TextView skipCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presenter = new ResultPresenter(ResultActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        loadView();
        presenter = new ResultPresenter(ResultActivity.this);


//        describe(presenter.get);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void describe(TestData testData, int currentPos, int getTotal, int correctIndex, int indexOfChecked) {

        List<RadioButton> radios = new ArrayList<>();
        LinearLayout container = findViewById(R.id.container);
        View view = LayoutInflater.from(this).inflate(R.layout.question, null);
        TextView currentPosition = view.findViewById(R.id.currentPositionForResult);
        View cardView = view.findViewById(R.id.cardQuestion);
        View var1 = view.findViewById(R.id.btn1);
        View var2 = view.findViewById(R.id.btn2);
        View var3 = view.findViewById(R.id.btn3);
        View var4 = view.findViewById(R.id.btn4);

        radios.add(view.findViewById(R.id.radio1));
        radios.add(view.findViewById(R.id.radio2));
        radios.add(view.findViewById(R.id.radio3));
        radios.add(view.findViewById(R.id.radio4));
        List<View> vars = new ArrayList<>();
        vars.add(var1);
        vars.add(var2);
        vars.add(var3);
        vars.add(var4);

        List<View> variants = new ArrayList<>();
        TextView question = view.findViewById(R.id.question);
        TextView variant1 = view.findViewById(R.id.text1);
        TextView variant2 = view.findViewById(R.id.text2);
        TextView variant3 = view.findViewById(R.id.text3);
        TextView variant4 = view.findViewById(R.id.text4);
        variants.add(variant1);
        variants.add(variant2);
        variants.add(variant3);
        variants.add(variant4);

        Log.d("TTTT", "belgilangani " + indexOfChecked + " togrisi :" + correctIndex);

        /*if (correctIndex != indexOfChecked){*/

            for (int i = 0; i < variants.size(); i++) {
                if (i == indexOfChecked && correctIndex != indexOfChecked){
                    vars.get(i).setBackgroundResource(android.R.color.holo_red_dark);
                }
                if (i == indexOfChecked){
                    radios.get(i).setChecked(true);
                }
                if (indexOfChecked == -1){
                    cardView.setBackgroundResource(android.R.color.holo_orange_dark);
                }
                if (i == correctIndex){
                    vars.get(i).setBackgroundResource(android.R.color.holo_green_light);
                }
            }
//        }
        currentPosition.setText(currentPos + "/" + getTotal);

        question.setText(testData.getQuestion());
        variant1.setText(testData.getVariant1());
        variant2.setText(testData.getVariant2());
        variant3.setText(testData.getVariant3());
        variant4.setText(testData.getVariant4());
        container.addView(view);
    }

    @Override
    public void loadView() {
        this.correctCount = findViewById(R.id.correct_count);
        inCorrectCount = findViewById(R.id.wrong_count);
        this.skipCount = findViewById(R.id.skip_count);
        findViewById(R.id.btn_home).setOnClickListener(v -> finish());

        presenter.loadToView();

    }

    @Override
    public void clickButtonHome() {
        finish();
    }

    @Override
    public void loadData(int correctCount, int wrongCount, int skipCount) {
        this.correctCount.setText(String.valueOf(correctCount));
        this.inCorrectCount.setText(String.valueOf(wrongCount));
        this.skipCount.setText(String.valueOf(skipCount));

    }
}