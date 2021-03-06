package com.thoughtworks.mobile.awayday.fragments.hotel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import static android.graphics.drawable.Drawable.createFromStream;
import static com.thoughtworks.mobile.awayday.util.DensityUtil.toPx;

public class ImageAdapter extends BaseAdapter {

    public static final int DEFAULT_THUMBNAIL_WIDTH_IN_DP = 270;
    public static final int DEFAULT_THUMBNAIL_HEIGHT_IN_DP = 216;

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView resultView;
        if (convertView == null) {
            resultView = new ImageView(parent.getContext());
        } else {
            resultView = (ImageView) convertView;
        }
        String fileName = "hotel/thumbs/hotel_" + position + ".jpg";

        final Drawable imageDrawable = getDrawableOf(parent.getContext(), fileName);
        resultView.setImageDrawable(imageDrawable);
        resultView.setPadding(10, 10, 10, 10);
        resultView.setBackgroundColor(Color.WHITE);

        final int width = toPx(parent.getResources(), DEFAULT_THUMBNAIL_WIDTH_IN_DP);
        final int height = toPx(parent.getResources(), DEFAULT_THUMBNAIL_HEIGHT_IN_DP);
        resultView.setLayoutParams(new Gallery.LayoutParams(width, height));
        resultView.setScaleType(ImageView.ScaleType.FIT_XY);

        return resultView;
    }

    private Drawable getDrawableOf(Context context, String fileName) {
        InputStream stream = null;
        try {
            stream = context.getAssets().open(fileName);
            return createFromStream(stream, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
