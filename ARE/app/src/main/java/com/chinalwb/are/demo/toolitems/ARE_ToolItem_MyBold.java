package com.chinalwb.are.demo.toolitems;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chinalwb.are.Util;
import com.chinalwb.are.demo.R;
import com.chinalwb.are.styles.IARE_Style;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Bold;

public class ARE_ToolItem_MyBold extends ARE_ToolItem_Bold {
    private int inActiveImage = -1;

    public ARE_ToolItem_MyBold(int activeImage, int inActiveImage) {
        super(activeImage, inActiveImage);
        this.inActiveImage = inActiveImage;
    }

    @Override
    public View getView(Context context) {
        if (null == context) {
            return mToolItemView;
        }
        if (mToolItemView == null) {
            ImageView imageView = new ImageView(context);
            int size = Util.getPixelByDp(context, 40);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            imageView.setLayoutParams(params);
            imageView.setImageResource(inActiveImage);
            imageView.bringToFront();
            mToolItemView = imageView;
        }

        return mToolItemView;
    }
}
