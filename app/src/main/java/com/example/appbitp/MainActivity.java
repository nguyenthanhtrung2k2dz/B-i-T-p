package com.example.appbitp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_list1;
    ArrayList<String> danhsach;
    Button btn_them,btn_sua;
    EditText edt_tenmonhoc;

    int vitri=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        xuly();
    }
    private void anhxa() {
        lv_list1 = (ListView) findViewById(R.id.lv_list1);
        btn_them = (Button) findViewById(R.id.btn_them);
        edt_tenmonhoc = (EditText) findViewById(R.id.edt_tenmonhoc);
        btn_sua = (Button) findViewById(R.id.btn_sua);
    }

    private void xuly() {
        danhsach = new ArrayList<String>();
        danhsach.add("Lập trình trên thiết bị di động");
        danhsach.add("ứng dụng thuật toán");
        danhsach.add("các phương pháp hình thức");
        danhsach.add("phân tích thiết kế hệ thống");
        danhsach.add("phân tích quản lý yêu cầu");

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1
                ,danhsach);
        lv_list1.setAdapter(adapter);

//        lv_list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, danhsach.get(i), Toast.LENGTH_SHORT).show();
//            }
//        });
        lv_list1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String a;
                a=danhsach.get(i);
                danhsach.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Xóa Môn "+ a +" Thành Công", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                danhsach.add(edt_tenmonhoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lv_list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_tenmonhoc.setText(danhsach.get(i));
                vitri=i;

            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                danhsach.set(vitri,edt_tenmonhoc.getText().toString());
                adapter.notifyDataSetChanged();

            }
        });

    }

}