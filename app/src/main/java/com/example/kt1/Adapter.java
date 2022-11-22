package com.example.kt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<cayxanh> cayxanhList;

    public Adapter(Context context, int layout, List<cayxanh> cayxanhList) {
        this.context = context;
        this.layout = layout;
        this.cayxanhList = cayxanhList;
    }

    @Override
    public int getCount() {
        return cayxanhList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtten =   (TextView) view.findViewById(R.id.ten);
        TextView txtcapbac = (TextView) view.findViewById(R.id.tentg);
        TextView txtnoicongtac = (TextView) view.findViewById(R.id.dactinh);
        TextView txtsosao = (TextView) view.findViewById(R.id.maula);
        ImageView img = (ImageView) view.findViewById(R.id.hinh);
        cayxanh cayxanh = cayxanhList.get(i);
        txtten.setText(cayxanh.getTenkh());
        txtcapbac.setText(cayxanh.getTentg());
        txtnoicongtac.setText(cayxanh.getDactinh());
        txtsosao.setText(cayxanh.getMaula());
        img.setImageResource(cayxanh.getHinh());
        return view;
    }
}
