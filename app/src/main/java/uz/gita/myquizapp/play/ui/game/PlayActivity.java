package uz.gita.myquizapp.play.ui.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import uz.gita.myquizapp.R;
import uz.gita.myquizapp.play.model.TestData;
import uz.gita.myquizapp.play.ui.game.CustomDilog.CustomDialog;
import uz.gita.myquizapp.play.ui.game.CustomDilog.OnNegativeCLickListener;
import uz.gita.myquizapp.play.ui.game.CustomDilog.OnPositiveClickListener;
import uz.gita.myquizapp.play.ui.result.ResultActivity;

public class PlayActivity extends AppCompatActivity implements GameContract.View, OnPositiveClickListener, OnNegativeCLickListener {

    private GameContract.Presenter presenter;
    private List<RadioButton> radios;
    private List<TextView> variants;
    List<CardView> cards;
    private TextView questionText;
    private TextView currentPosText;
    ImageView image;
    private AppCompatButton buttonSkip;
    private AppCompatButton buttonNext;
    private int checkedIndex;

    private CustomDialog dialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        loadViews();
        attachClickListener();
        presenter = new GamePresenter(this);
    }

    @Override
    public void clearOldAnswer() {
        for (int i = 0; i < radios.size(); i++) {
            if (radios.get(i).isChecked())
                radios.get(i).setChecked(false);
        }
    }

    @Override
    public void describeTest(TestData testData, int currentPos, int totalPos) {
        currentPosText.setText(currentPos + "/" + totalPos);
        questionText.setText(testData.getQuestion());

        variants.get(0).setText(testData.getVariant1());
        variants.get(1).setText(testData.getVariant2());
        variants.get(2).setText(testData.getVariant3());
        variants.get(3).setText(testData.getVariant4());
        image.setImageResource(testData.getImage());
    }

    @Override
    public void stateNextButton(boolean bool) {
        buttonNext.setEnabled(bool);
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public void openResultActivity() {
        startActivity(new Intent(PlayActivity.this, ResultActivity.class));

        finish();
        dialog = new CustomDialog(this);

    }



    private void loadViews() {
        cards = new ArrayList<>();

        image = findViewById(R.id.image);
        radios = new ArrayList<>();
        radios.add(findViewById(R.id.radio1));
        radios.add(findViewById(R.id.radio2));
        radios.add(findViewById(R.id.radio3));
        radios.add(findViewById(R.id.radio4));

        variants = new ArrayList<>();
        variants.add(findViewById(R.id.text1));
        variants.add(findViewById(R.id.text2));
        variants.add(findViewById(R.id.text3));
        variants.add(findViewById(R.id.text4));

        questionText = findViewById(R.id.question);
        currentPosText = findViewById(R.id.textCurrent);
        buttonNext = findViewById(R.id.btn_next);
        buttonSkip = findViewById(R.id.btn_skip);

        cards.add(findViewById(R.id.btn1));
        cards.add(findViewById(R.id.btn2));
        cards.add(findViewById(R.id.btn2));
        cards.add(findViewById(R.id.btn3));

        findViewById(R.id.back).setOnClickListener(v -> finish());

    }

    private void attachClickListener() {
        buttonSkip.setOnClickListener(v -> presenter.clickSkipButton());
        buttonNext.setOnClickListener(v -> presenter.clickNextButton(checkedIndex));

        for (int i = 0; i < cards.size(); i++) {


            radios.get(i).setTag(i);
            radios.get(i).setOnClickListener(v -> {
                int pos = (int) v.getTag();
                if (radios.get(pos).isChecked()) {
                    clearOldAnswer();
                    radios.get(pos).setChecked(true);
                    checkedIndex = pos;
                    presenter.selectUserAnswer(variants.get(pos).getText().toString(), pos);
                }
            });
        }
    }


    @Override
    public void clickButton() {
        startActivity(new Intent(PlayActivity.this, ResultActivity.class));
        finish();
    }

    @Override
    public void clickNegativeButton() {
        finish();
    }
}