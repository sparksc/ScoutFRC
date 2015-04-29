package edu.erau.scoutfrc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Displays the items in the GridView created in the HomeScreenFragment.java class.
 *
 * Source: http://developer.android.com/guide/topics/ui/layout/gridview.html
 *
 * Created by Cierra
 * @date 4/28/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    /**
     * Create a new ImageView for each item referenced by the Adapter.
     *
     * Sources: http://www.mkyong.com/android/android-gridview-example/
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            /*gridView = new View(mContext);
            gridView = inflater.inflate(R.layout.item_grid_fragment, null);
            TextView textView = (TextView) gridView.findViewById(R.id.text1);
            textView.setText(mThumbIds[position]);*/


            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk,
            R.drawable.robot_clipart_focatk, R.drawable.robot_clipart_focatk
    };
}
