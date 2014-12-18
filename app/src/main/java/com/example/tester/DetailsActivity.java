package com.example.tester;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends Activity {

	public static String TAG_IMAGE_NAME = "tag_image_name";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		Intent intent = getIntent();
		String imageName = "";

		if(intent != null){
			imageName = intent.getStringExtra(TAG_IMAGE_NAME);
		}

		ImageView img = (ImageView) findViewById(R.id.activity_details_image);
		TextView txt = (TextView) findViewById(R.id.activity_details_txt);

		if(imageName.equals(getString(R.string.penguins))){
			img.setImageDrawable(getResources().getDrawable(R.drawable.penguin));
			txt.setText("https://c2.staticflickr.com/2/1428/622780860_e86bcbb082.jpg");
		}else{
			img.setImageDrawable(getResources().getDrawable(R.drawable.monkey));
			txt.setText("http://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Saimiri_sciureus-1_Luc_Viatour.jpg/640px-Saimiri_sciureus-1_Luc_Viatour.jpg");
		}

		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}
}