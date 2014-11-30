package com.example.android_test;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 2014年11月30日
 * @author jianhua
 */
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

	public void setRowCol(int row, int col) {
		mCol = col;
		mRow = row;
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int fatherWidthSize = MeasureSpec.getSize(widthMeasureSpec);
		int fatherHeightSize = MeasureSpec.getSize(heightMeasureSpec);
		int size = mRow * mCol;
		int widthtemp = (fatherWidthSize - (mCol + 1) * mBoder) % mCol;
		int heighttemp = (fatherHeightSize - (mRow + 1) * mBoder) % mRow;
		int childWidth = (fatherWidthSize - (mCol + 1) * mBoder) / mCol;
		int childHeight = (fatherHeightSize - (mRow + 1) * mBoder) / mRow;
		int widthValue = 0;
		int heightValue = 0;
		int width_add = 0;
		int height_add = 0;
		for (int i = 0; i < size; i++) {
			View child = getChildAt(i);
			if (i % mCol == 0) {
				width_add = 0;
				
				if (height_add >= heighttemp) {
					heightValue = 0;
				} else {
					heightValue = 1;
					height_add++;
				}
				
			}
			if (width_add >= widthtemp) {
				widthValue = 0;
			} else {
				widthValue = 1;
				width_add++;
			}
			child.measure(MeasureSpec.makeMeasureSpec(childWidth + widthValue, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(childHeight + heightValue, MeasureSpec.EXACTLY));
		}
		super.onMeasure(MeasureSpec.makeMeasureSpec(widthMeasureSpec, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(heightMeasureSpec, MeasureSpec.EXACTLY));
	}

	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		int lengthX = 0;
		int lengthY = 0;
		final int size = getChildCount();
		for (int i = 0; i < size; i++) {
			final View child = this.getChildAt(i);
			int width = child.getMeasuredWidth();
			int height = child.getMeasuredHeight();
			if (i % mCol == 0) {
				lengthX = mBoder;
				lengthY += mBoder + height;
			}
			lengthX = lengthX + width;
			child.layout(lengthX - width, lengthY - height, lengthX, lengthY);
			lengthX += mBoder;
		}
	}

	public void clearTag() {
		for (int i = 0; i < getChildCount(); i++) {
			getChildAt(i).setTag(false);
			getChildAt(i).setBackgroundColor(Color.WHITE);
		}
	}

}
