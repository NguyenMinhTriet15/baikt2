package com.example.kt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    ListView lvcx;
    ArrayList<cayxanh> arraycx;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Anhxa();
        adapter = new Adapter(this, R.layout.dong,arraycx);
        lvcx.setAdapter(adapter);
        lvcx.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arraycx.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(Homepage.this, "Đã xóa item", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        lvcx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)
                {
                    Intent it = new Intent(Homepage.this, caytao.class);
                    startActivity(it);
                }
                if (i==1)
                {
                    Intent i1 = new Intent(Homepage.this, cayphong.class);
                    startActivity(i1);
                }
                if (i==2)
                {
                    Intent it1 = new Intent(Homepage.this, caythongnoel.class);
                    startActivity(it1);
                }
                if (i==3)
                {
                    Intent it2 = new Intent(Homepage.this, choderangcua.class);
                    startActivity(it2);
                }
            }
        });
    }

    private void Anhxa() {
        lvcx = (ListView) findViewById(R.id.lvCA);
        arraycx = new ArrayList<>();
        arraycx.add(new cayxanh("Malus domestica","Cây táo tây", "Cây rụng lá", "Màu lá: đỏ", R.drawable.ct));
        arraycx.add(new cayxanh("Acer","Cây phong", "Cây thân gỗ", "Màu lá: đỏ", R.drawable.cp));
        arraycx.add(new cayxanh("Christmas tree","Cây thông noel", "Cây trang trí", "Màu lá: xanh", R.drawable.ctn));
        arraycx.add(new cayxanh("Phyllanthus urinaria","Cây chó đẻ răng cưa", "Cây có hạt tròn", "Màu lá: xanh", R.drawable.cdrc));

    }
}