package com.example.android_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my);
	}
	
	public void button1OnClick(View view) {
		startActivity(new Intent().setClass(this, MainActivity.class));
	}
	
	public void button2OnClick(View view) {
		startActivity(new Intent().setClass(this, AnimationActivity.class));
	}
	
}
