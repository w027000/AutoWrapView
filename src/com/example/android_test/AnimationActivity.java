package com.example.android_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class AnimationActivity extends Activity{
	
	private ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_item);
		
		iv = (ImageView) findViewById(R.id.iv);
		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 1000);
				animation.setDuration(500);// 设置动画持续时间
				animation.setFillAfter(true);
				animation.setFillBefore(false);
				animation.setAnimationListener(new AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
					}

				});
				iv.startAnimation(animation);
			}
		});
	}
	
}
