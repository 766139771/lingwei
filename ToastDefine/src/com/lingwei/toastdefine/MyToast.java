package com.lingwei.toastdefine;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyToast extends Toast {

	public MyToast(Context context) {
		super(context);
		
	}
	
	private static FrameLayout.LayoutParams mLayoutParams;
	public static final int VIEW_WRAP = 1;
	public static final int VIEW_FILL = 2;
	public static final Style StyleWrapPrompt = new Style(0, Color.WHITE, R.color.blue, Toast.LENGTH_SHORT, VIEW_WRAP);
	public static final Style StyleFillPrompt = new Style(0, Color.WHITE, R.color.blue, Toast.LENGTH_SHORT, VIEW_FILL);
	
	public static Toast makeText(Context context, int resId, CharSequence text, Style style) {
		Toast result = new Toast(context);
		
		//获取LayoutInflater对象
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		//由layout文件创建一个View对象
		View v = inflater.inflate(R.layout.toast_msg, null);
		TextView textView = (TextView)v.findViewById(android.R.id.message);
		textView.setText(text);
		
		
		 if(style.textSize > 0) 
	        	textView.setTextSize(style.textSize);
	        textView.setTextColor(style.textColor);
	        textView.setText(text);

	        switch(style.viewType){
	        case VIEW_WRAP:
	        	 GradientDrawable myGrad = (GradientDrawable)v.getBackground();
	             myGrad.setColor(context.getResources().getColor(style.background));
	             result.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 200);
	        	break;
	        case VIEW_FILL:
	        	Log.i("tt", "into");
	        	 v.setBackgroundResource(style.background);
	        	 result.setGravity(Gravity.FILL_HORIZONTAL|Gravity.BOTTOM, 0, 200);
	        	break;
	        }
		
		result.setView(v);
		result.setDuration(style.duration);
		return result;
	}
	
	public static class Style{
		private int textSize;
		private int textColor;
		private int background;
		private int viewType;
		private int duration;
		public Style(int textSize,int textColor,int background,int duration,int viewType){
			this.textSize = textSize;
			this.textColor = textColor;
			this.background = background;
			this.viewType = viewType;
			this.duration = duration;
		}
		public int getTextSize() {
			return textSize;
		}
		public void setTextSize(int textSize) {
			this.textSize = textSize;
		}
		public int getTextColor() {
			return textColor;
		}
		public void setTextColor(int textColor) {
			this.textColor = textColor;
		}
		public int getBackground() {
			return background;
		}
		public void setBackground(int background) {
			this.background = background;
		}
		public int getViewType() {
			return viewType;
		}
		public void setViewType(int viewType) {
			this.viewType = viewType;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		
	}

}