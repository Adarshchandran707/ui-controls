package com.example.alertbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {

        mContext = c;
    }
    public int getCount() {

        return thumbImages.length;
    }
    public Object getItem(int position) {

        return null;
    }
    public long getItemId(int position) {

        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(thumbImages[position]);
        return imageView;
    }

    public Integer[] thumbImages = {
            R.drawable.cl1,
            R.drawable.cl2,
            R.drawable.cl3,
            R.drawable.cl4,
            R.drawable.cl5,
            R.drawable.cl6
    };
}
