package uz.gita.myquizapp.play.ui.game.CustomDilog;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import uz.gita.myquizapp.R;
import uz.gita.myquizapp.play.ui.game.GameContract;
import uz.gita.myquizapp.play.ui.game.GamePresenter;

public class CustomDialog extends AlertDialog {
    private OnPositiveClickListener positiveClickListener;
    private OnNegativeCLickListener negativeCLickListener;
    private Button noBtn;
    private TextView correctCount = findViewById(R.id.correct_count_);
    private TextView wrongCount = findViewById(R.id.wrong_count_);
    private TextView skipCount = findViewById(R.id.skipped_count_);

    public CustomDialog(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setCancelable(false);

        correctCount = findViewById(R.id.correct_count_);
        wrongCount = findViewById(R.id.wrong_count_);
        skipCount = findViewById(R.id.skipped_count_);
        noBtn = findViewById(R.id.no);
        Button yesBtn = findViewById(R.id.yes);

        yesBtn.setOnClickListener(v -> {
            if (hasListener()){
                positiveClickListener.clickButton();
                dismiss();
            }
        });
        noBtn.setOnClickListener(v -> {
            if (hasNegativeListener()){
                negativeCLickListener.clickNegativeButton();
            }
        });
    }

    private boolean hasListener() {
        return positiveClickListener != null;
    }
    private boolean hasNegativeListener(){
        return negativeCLickListener != null;
    }

    public void setPositiveClickListener(OnPositiveClickListener positiveClickListener) {
        this.positiveClickListener = positiveClickListener;
    }

    public void setNegativeCLickListener(OnNegativeCLickListener negativeCLickListener) {
        this.negativeCLickListener = negativeCLickListener;
    }
    /*public void setCorrectCount(String count) {
        correctCount.setText((count));
    }

    public void setWrongCount(String count) {
        wrongCount.setText((count));
    }


    public void setSkipCount(String count) {
        skipCount.setText((count));
    }*/

}
