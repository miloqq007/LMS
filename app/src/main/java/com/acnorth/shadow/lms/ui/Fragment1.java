package com.acnorth.shadow.lms.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.acnorth.shadow.lms.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shadow on 2016/6/18.
 */
public class Fragment1 extends Fragment {
    ListView host_list;
    ArrayList<HashMap<Bitmap, String>> mylist = new ArrayList<HashMap<Bitmap, String>>();
    Bitmap bmp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg1, container, false);
        host_list = (ListView) this.getActivity().findViewById(R.id.host_list);
        for (int i = 0; i < 30; i++) {
            HashMap<Bitmap, String> map = new HashMap<Bitmap, String>();
            bmp = 
            map.put(bmp, "This is our test.....");
            mylist.add(map);
        }


        return view;
    }

    class listViewAdapter extends BaseAdapter {
        int count = 30;

        public int getCount() {
            return count;
        }

        public Object getItem(int pos) {
            return pos;
        }

        public long getItemId(int pos) {
            return pos;
        }

        public View getView(int pos, View v, ViewGroup p) {
            TextView view;
            if (v == null) {
                view = LayoutInflater.from(context).inflate(R.layout.fg1, p, false);
            } else {
                view = (TextView) v;
            }
            view.setText("ListItem " + pos);
            view.setTextSize(20f);
            view.setGravity(Gravity.CENTER);
            view.setHeight(60);
            return view;
        }

    }
}
