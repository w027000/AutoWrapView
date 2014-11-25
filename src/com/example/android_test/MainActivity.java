package com.example.android_test;



import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {
	
	private LinearLayout layoutView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layoutView = (LinearLayout) findViewById(R.id.frequent_choice_view_ball);
		
		for(int i = 0; i < 3; i++){
			View view = LayoutInflater.from(this).inflate(R.layout.item, null);
			AutoWrapViewNew wrapView = (AutoWrapViewNew) view.findViewById(R.id.many_view_item_auto_view);
			TextView manyTv= (TextView) view.findViewById(R.id.many_view_item_tv);
			View line_view = view.findViewById(R.id.rule_line);
	
			for(int j=0;j<13;j++){
				CheckBox checkBox = new CheckBox(this);
				checkBox.setText("" +j);
				checkBox.setId(j);
				checkBox.setBackgroundResource(R.drawable.ball_red);
				wrapView.addView(checkBox);
			}
			
			
			wrapView.setId(i);
			wrapView.setIsCenter(true);
			wrapView.setTopAndBotton(10);
			wrapView.setRightAndLeftSpace(10);
			line_view.setVisibility(View.VISIBLE);
			layoutView.addView(view);
			
		}

	}
}
