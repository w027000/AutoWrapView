/*package com.example.android_test;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
public class TableViewNew extends ViewGroup {
	
	private int mRow = 2;// 行数
	private int mCol = 5;// 列数
	private int mBoder = 2;

	public TableViewNew(Context context) {
		super(context);
	}

	public TableViewNew(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TableViewNew(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public void setRowCol(int row,int col){
		mCol = col;
		mRow = row;
	}
	
	
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int fatherWidthSize = MeasureSpec.getSize(widthMeasureSpec)-mBoder*(mCol+1);
		int fatherHeightSize = MeasureSpec.getSize(heightMeasureSpec)-mBoder*(mRow+1);
		int childWidthMeasureSpecAdd = fatherWidthSize%mCol;
		int childHeightMeasureSpecAdd = fatherHeightSize%mRow;
		int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(fatherWidthSize/mCol,MeasureSpec.EXACTLY);
		int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(fatherHeightSize/mRow,MeasureSpec.EXACTLY);
		
		int size = mCol*mRow;
		for(int i=0; i<size;i++){
			final View child = getChildAt(i);
			int childWidth = childWidthMeasureSpec;
			int childHeight = childHeightMeasureSpec;
			if(i%mCol<childWidthMeasureSpecAdd){
				childWidth+=1; 
			}
			if(i/mCol<childHeightMeasureSpecAdd){
				childHeight+=1; 
			}
			child.measure(childWidth, childHeight);
		}
		super.onMeasure(MeasureSpec.makeMeasureSpec(fatherWidthSize*mCol, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(childHeightMeasureSpec*mRow+mBoder*(mRow+1), MeasureSpec.EXACTLY));
	}
	

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int width = getWidth();
		int height = getHeight();
		int childWidthMeasureSpecAdd = (width-mBoder*(mCol+1))%mCol;
		int childHeightMeasureSpecAdd = (height-mBoder*(mRow+1))%mRow;
		
		final int size = getChildCount();
		for (int i = 0; i < size; i++) {
			final View child = this.getChildAt(i);
			int child_width = child.getMeasuredWidth();
			int child_height = child.getMeasuredHeight();
			int lengthX = 0;
			int lengthY = 0;
			lengthX = i%mCol *child_width + mBoder*(i%mCol+1);
			
			if(i%mCol>=childWidthMeasureSpecAdd){
				lengthX += childWidthMeasureSpecAdd;
			}
			
			lengthY = i/mCol*child_height + mBoder*(i/mCol+1);
			
			if(i/mCol>=childHeightMeasureSpecAdd){
				lengthY += childHeightMeasureSpecAdd;
			}
			
			child.layout(lengthX, lengthY, lengthX+child_width, lengthY+child_height);
		}
	}
	
	public void clearTag(){
		for(int i=0;i<getChildCount();i++){
			getChildAt(i).setTag(false);
			getChildAt(i).setBackgroundColor(Color.WHITE);
		}
	}

}
*/