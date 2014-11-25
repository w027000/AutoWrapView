package com.example.android_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author jianhua
 * 2014Äê11ÔÂ25ÈÕ23:47:33
 */
public class AutoWrapViewNew extends ViewGroup {
	
	private int mChildW = ScreenUtil.dip2px(getContext(), 40);
	private int mChildH = ScreenUtil.dip2px(getContext(), 40);
	private int mNumber = 5;
	private boolean mIsCenter = true;
	private int mLeftAndRightSpace = 0;
	private int mTopAndBotton = 0;
	
	public AutoWrapViewNew(Context context) {
		super(context);
	}

	public AutoWrapViewNew(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AutoWrapViewNew(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public void setChildViewSize(int width,int height){
		mChildW = ScreenUtil.dip2px(getContext(), width);
		mChildH = ScreenUtil.dip2px(getContext(), height);
	}
	
	public void setValue(int num){
		mNumber = num;
	}
	
	public void setIsCenter(boolean is){
		mIsCenter = is;
	}
	
	public void setRightAndLeftSpace(int value){
		mLeftAndRightSpace = ScreenUtil.dip2px(getContext(), value);
	}
	
	public void setTopAndBotton(int value){
		mTopAndBotton = ScreenUtil.dip2px(getContext(), value);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int fatherWidthSize = MeasureSpec.getSize(widthMeasureSpec);
		int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(mChildW,MeasureSpec.EXACTLY);
		int childheightMeasureSpec = MeasureSpec.makeMeasureSpec(mChildH, MeasureSpec.EXACTLY);
		int size = getChildCount();
		int row = 0;
		if(!mIsCenter){
			mNumber = fatherWidthSize/(mChildW+mLeftAndRightSpace);
		}else{
			mLeftAndRightSpace = (fatherWidthSize - mChildW*mNumber)/(mNumber-1);
		}
		for(int i=0; i<size;i++){
			final View child = getChildAt(i);
			child.measure(childWidthMeasureSpec, childheightMeasureSpec);
			if(i%mNumber == 0){
				row++;
			}
		}
		super.onMeasure(MeasureSpec.makeMeasureSpec(widthMeasureSpec, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec( (mChildH + mTopAndBotton)*row + mTopAndBotton, MeasureSpec.EXACTLY));
	}

	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		int row = 0;
		int lengthX = 0;
		int lengthY = 0; 
		final int size = getChildCount();
		for (int i = 0; i < size; i++) {
			final View child = this.getChildAt(i);
			int width = child.getMeasuredWidth();
			int height = child.getMeasuredHeight();
			if(i%mNumber == 0){
				row ++;
				lengthX = 0;
				System.out.println("mNumber-->" + mNumber + "  row-->" + row);
			}
			lengthX = i%mNumber * (width + mLeftAndRightSpace);
			lengthY = (height + mTopAndBotton)*row;
			child.layout(lengthX, lengthY-height, lengthX+width, lengthY);
			
		}
	}

}
