package com.example.android_test;



import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	private LinearLayout layoutView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
//		layoutView = (LinearLayout) findViewById(R.id.frequent_choice_view_ball);
//		for(int i = 0; i < 3; i++){
//			View view = LayoutInflater.from(this).inflate(R.layout.item, null);
//			AutoWrapViewNew wrapView = (AutoWrapViewNew) view.findViewById(R.id.many_view_item_auto_view);
//			TextView manyTv= (TextView) view.findViewById(R.id.many_view_item_tv);
//			View line_view = view.findViewById(R.id.rule_line);
//	
//			for(int j=0;j<13;j++){
//				CheckBox checkBox = new CheckBox(this);
//				checkBox.setText("" +j);
//				checkBox.setId(j);
//				checkBox.setBackgroundResource(R.drawable.ball_red);
//				wrapView.addView(checkBox);
//			}
//			
//			
//			wrapView.setId(i);
//			wrapView.setIsCenter(true);
//			wrapView.setTopAndBotton(10);
//			wrapView.setRightAndLeftSpace(10);
//			line_view.setVisibility(View.VISIBLE);
//			layoutView.addView(view);
			
//		}
		
//		setContentView(R.layout.activity_main_table);
		
		
		setContentView(R.layout.activity_main);
		layoutView = (LinearLayout) findViewById(R.id.frequent_choice_view_ball);
		View view = LayoutInflater.from(this).inflate(R.layout.table_item, null);
		final TableViewNew wrapView = (TableViewNew) view.findViewById(R.id.many_view_item_auto_view);
		wrapView.setRowCol(2, 5);
		for(int j=0;j<10;j++){
			final TextView textView = new TextView(this);
			textView.setText("" +j);
			textView.setId(j);
			textView.setGravity(Gravity.CENTER);
			textView.setTag(false);
			textView.setBackgroundColor(Color.WHITE);
//			if(j == 0){
//				textView.setBackgroundResource(R.drawable.table_left_top_shape_white);
//			}else if(j == 4){
//				textView.setBackgroundResource(R.drawable.table_right_top_shape_white);
//			}else if(j == 5){
//				textView.setBackgroundResource(R.drawable.table_left_botton_shape_white);
//			}else if(j == 9){
//				textView.setBackgroundResource(R.drawable.table_right_botton_shape_white);
//			}else{
//				textView.setBackgroundColor(Color.WHITE);
//			}
//			
//			textView.setOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					if(!(Boolean)textView.getTag()){
//						textView.setTag(true);
//						textView.setBackgroundColor(Color.RED);
//					}else{
//						textView.setTag(false);
//						textView.setBackgroundColor(Color.WHITE);
//					}
//				}
//			});
			wrapView.addView(textView);
		}
		layoutView.addView(view);
	}
}
