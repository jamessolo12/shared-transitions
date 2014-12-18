package com.example.tester;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.activity_main_monkey).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startDetailsActivity(v);
			}
		});

		findViewById(R.id.activity_main_penguin).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startDetailsActivity(v);
			}
		});
	}


	@SuppressLint("NewApi")
	private void startDetailsActivity(View v){
		Intent intent = new Intent(this, DetailsActivity.class);
		ActivityOptions options = null;
		// create the transition animation - the images in the layouts of both activities are defined with android:transitionName="MyTransition"
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.L) {
			options = ActivityOptions.makeSceneTransitionAnimation(this, v, getString(R.string.MyTransitionName));
		}
		intent.putExtra(DetailsActivity.TAG_IMAGE_NAME, (String) v.getTag());
		// start the new activity
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && options != null) {
			this.startActivity(intent, options.toBundle());
		}else{
			startActivity(intent);
		}
	}
}