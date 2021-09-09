package com.chinalwb.are.styles.toolitems;

import android.content.Context;
import android.media.Image;
import android.text.Editable;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chinalwb.are.AREditText;
import com.chinalwb.are.Constants;
import com.chinalwb.are.R;
import com.chinalwb.are.Util;
import com.chinalwb.are.styles.IARE_Style;
import com.chinalwb.are.styles.toolitems.styles.ARE_Style_Bold;

/**
 * Created by wliu on 13/08/2018.
 */

public class ARE_ToolItem_Bold extends ARE_ToolItem_Abstract {
    private ImageView view = null;
    private int activeImage = -1;
    private int inActiveImage = -1;

    public ARE_ToolItem_Bold(int activeImage, int inActiveImage) {
        this.activeImage = activeImage;
        this.inActiveImage = inActiveImage;
    }

    @Override
    public IARE_ToolItem_Updater getToolItemUpdater() {
        if (mToolItemUpdater == null) {
            mToolItemUpdater = new ARE_ToolItem_UpdaterDefault(this, Constants.CHECKED_COLOR, Constants.UNCHECKED_COLOR);
            setToolItemUpdater(mToolItemUpdater);
        }
        return mToolItemUpdater;
    }

    @Override
    public IARE_Style getStyle() {
        if (mStyle == null) {
            AREditText editText = this.getEditText();
            IARE_ToolItem_Updater toolItemUpdater = getToolItemUpdater();
            mStyle = new ARE_Style_Bold(editText, (ImageView) mToolItemView, toolItemUpdater, activeImage, inActiveImage);
        }
        return mStyle;
    }

    @Override
    public View getView(Context context) {
        if (null == context) {
            return mToolItemView;
        }
        if (mToolItemView == null) {
            ImageView imageView = new ImageView(context);
            int height = Util.getPixelByDp(context, 40);
            int width = Util.getPixelByDp(context, 57);
            int padding = Util.getPixelByDp(context, 10);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            imageView.setLayoutParams(params);
            imageView.setImageResource(inActiveImage);
            imageView.bringToFront();
            imageView.setPadding(padding, padding, padding, padding);
            mToolItemView = imageView;
            view = imageView;
        }

        return mToolItemView;
    }

    @Override
    public void onSelectionChanged(int selStart, int selEnd) {

        boolean boldExists = false;

        AREditText editText = this.getEditText();
        Editable editable = editText.getEditableText();
        if (selStart > 0 && selStart == selEnd) {
            CharacterStyle[] styleSpans = editable.getSpans(selStart - 1, selStart, CharacterStyle.class);

            for (int i = 0; i < styleSpans.length; i++) {
                if (styleSpans[i] instanceof StyleSpan) {
                    if (((StyleSpan) styleSpans[i]).getStyle() == android.graphics.Typeface.BOLD) {
                        boldExists = true;
                    }
                }
            }
        } else {
			//
			// Selection is a range
			CharacterStyle[] styleSpans = editable.getSpans(selStart, selEnd, CharacterStyle.class);

			for (int i = 0; i < styleSpans.length; i++) {

				if (styleSpans[i] instanceof StyleSpan) {
					if (((StyleSpan) styleSpans[i]).getStyle() == android.graphics.Typeface.BOLD) {
						if (editable.getSpanStart(styleSpans[i]) <= selStart
								&& editable.getSpanEnd(styleSpans[i]) >= selEnd) {
							boldExists = true;
						}
					} else if (((StyleSpan) styleSpans[i]).getStyle() == android.graphics.Typeface.BOLD_ITALIC) {
                        if (editable.getSpanStart(styleSpans[i]) <= selStart
                                && editable.getSpanEnd(styleSpans[i]) >= selEnd) {
                            boldExists = true;
                        }
                    }
				}
			}
		}

        if(boldExists){
            view.setImageResource(activeImage);
        }else{
            view.setImageResource(inActiveImage);
        }

        mToolItemUpdater.onCheckStatusUpdate(boldExists);
    }
}
