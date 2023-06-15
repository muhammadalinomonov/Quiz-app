package uz.gita.myquizapp.play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import uz.gita.myquizapp.R;
import uz.gita.myquizapp.play.ui.game.PlayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnPlay).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, PlayActivity.class));
        });
        findViewById(R.id.btnInfo).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, InfoActivity.class)));
    }
}