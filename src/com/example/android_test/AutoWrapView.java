package com.example.android_test;

import java.util.ArrayList;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.widget.CheckBox;

public class AutoWrapView extends ViewGroup {

	/**
	 * @author jianhua 2014Âπ?1Êú?8Êó?
	 */

	private int VIEW_MARGIN_HEIGHT = 0;
	private int VIEW_MARGIN_WIDTH = 0;//
	private boolean mIsCenter = false;
	private boolean mIs = false;
	private int mChildW = ScreenUtil.dip2px(getContext(), 40);
	private int mChildH = ScreenUtil.dip2px(getContext(), 40);
	private int mNumber = 0;

	public AutoWrapView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public AutoWrapView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public AutoWrapView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int fatherWidthSize = MeasureSpec.getSize(widthMeasureSpec);
		int fatherHeightSize = MeasureSpec.getSize(heightMeasureSpec);
		int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(mChildW,MeasureSpec.EXACTLY);
		int childheightMeasureSpec = MeasureSpec.makeMeasureSpec(mChildH, MeasureSpec.EXACTLY);
		int childRowWidth = 0;
		int childRowHeight = 0;
		int rowCount = 0;
		int row = 1;
		for (int index = 0; index < getChildCount(); index++) {
			final View child = getChildAt(index);
			child.measure(childWidthMeasureSpec, childheightMeasureSpec);
			childRowWidth += (mChildW + VIEW_MARGIN_WIDTH);
			if (childRowWidth > fatherWidthSize) {
				row++;
				childRowWidth = 0;
				if (row == 2) {
					rowCount = index;
				}
			}
		}
		if (row == 1) {// ‰∏çË∂≥‰∏?°å
			rowCount = getChildCount();
		}else if(row > 1 && childRowWidth > mChildW){
			row ++;
		}
		if (mIsCenter && rowCount != 0 && !mIs) {
			mIs = true;
			VIEW_MARGIN_WIDTH = (fatherWidthSize - (mChildW * rowCount)) / (rowCount - 1);
		}
		if(mNumber != 0){
			VIEW_MARGIN_WIDTH = (fatherWidthSize - (mChildW * mNumber)) / (mNumber - 1);
		}
		childRowHeight = ( (mChildH *row)  + VIEW_MARGIN_HEIGHT);
		super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(childRowHeight-(row-1)*VIEW_MARGIN_HEIGHT,MeasureSpec.EXACTLY));
	}
	

	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		final int count = getChildCount();
		int row = 0;// which row lay you view relative to parent
		int lengthX = 0; // right position of child relative to parent
		int lengthY = 0; // bottom position of child relative to parent
		for (int i = 0; i < count; i++) {
			final View child = this.getChildAt(i);
			int width = child.getMeasuredWidth();
			int height = child.getMeasuredHeight();
			lengthY = row * (height + VIEW_MARGIN_HEIGHT) + VIEW_MARGIN_HEIGHT + height /*+ arg2*/;
			lengthX = lengthX + width + (i != 0 ? VIEW_MARGIN_WIDTH : 0);
			// if it can't drawing on a same line , skip to next line
			if (lengthX > (arg3 - arg1)) {
				lengthX = width;
				row++;
				lengthY = row * (height + VIEW_MARGIN_HEIGHT) + VIEW_MARGIN_HEIGHT + height /*+ arg2*/;
			}
			child.layout(lengthX - width, lengthY - height, lengthX, lengthY);
		}
	}

	public void setIsCenter(boolean isCenter) {
		mIsCenter = isCenter;
	}

	public void setMyTop(int value) {
		VIEW_MARGIN_HEIGHT = ScreenUtil.dip2px(getContext(), value);
	}

	public void setMyBetween(int value) {
		VIEW_MARGIN_WIDTH = ScreenUtil.dip2px(getContext(), value);
	}

	public void setChildSize(int w,int h){
		mChildW = ScreenUtil.dip2px(getContext(), w);
		mChildH = ScreenUtil.dip2px(getContext(), h);
	}
	
	public void setNumber(int number){
		mNumber = number;
	}
	
	
	/**
	 * ÂèñÂæóÈÄâ‰∏≠ÁöÑÁªìÊû?
	 * 
	 * @return
	 */
	public ArrayList<Integer> getSelect() {
		try {
			result.clear();
			for (int i = 0; i < getChildCount(); i++) {
				CheckBox checkBox = (CheckBox) getChildAt(i);
				if (checkBox.isChecked()) {
					result.add(i);
				}
			}
		} catch (Exception e) {
			result.clear();
			e.printStackTrace();
		}
		return result;
	}

	private ArrayList<Integer> result = new ArrayList<Integer>();
}