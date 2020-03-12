package com.example.projet;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet.PagePlay;

import com.example.projet.PageRule;
import com.example.projet.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Button bp = (Button)findViewById(R.id.bPlay);

        bp.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(MainActivity.this, PagePlay.class);
                startActivity(gameActivity);
            }
        });

        Button br = (Button)findViewById(R.id.bRules);

        br.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent ruleActivity = new Intent(MainActivity.this, PageRule.class);
                startActivity(ruleActivity);
            }
        });

        Button be = (Button)findViewById(R.id.bExit);

        be.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

}
