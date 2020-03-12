package com.example.projet;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Main
 *
 * @author Emeric Mottier
 * @version 2.0
 */
public class PagePlay extends AppCompatActivity {

	private int lon, lar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_page_play);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		DisplayMetrics metrics = new DisplayMetrics();   //for all android versions
		int[] diceImages = new int[] { R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6 };
		ImageView leftDice = findViewById(R.id.imageDie);
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		lon  = metrics.widthPixels;
		lar = metrics.heightPixels;
		Button buttons[][] = new Button[4][4];
		for(int i=1 ; i<5 ; i++) {
			for(int j=0;j<4;j++) {
				String buttonID = "b" + i + j;
				int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
				buttons[i-1][j] = ((Button) findViewById(resID));
			}
		}
		Button de = ((Button) findViewById(R.id.de));
		Button next = ((Button) findViewById(R.id.next));

		Jeu jeu= new Jeu(lon,lar,next,de,diceImages,leftDice);
		jeu.init(buttons);
		jeu.jouer();

		Button bReturn = (Button)findViewById(R.id.bRetour);

		bReturn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			hideSystemUI();
		}
	}

	private void hideSystemUI() {
		// Enables regular immersive mode.
		// For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
		// Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
		View decorView = getWindow().getDecorView();
		decorView.setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_IMMERSIVE
						// Set the content to appear under the system bars so that the
						// content doesn't resize when the system bars hide and show.
						| View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						// Hide the nav bar and status bar
						| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_FULLSCREEN);
	}

	// Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
	private void showSystemUI() {
		View decorView = getWindow().getDecorView();
		((View) decorView).setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
	}

}
