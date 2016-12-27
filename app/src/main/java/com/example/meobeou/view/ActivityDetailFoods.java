package com.example.meobeou.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meobeou.fireabase.DataDetailFoods;
import com.example.meobeou.model.Data;
import com.example.meobeou.tn_travelandservices.R;

/**
 * Created by qwer on 12/3/2016.
 */
public class ActivityDetailFoods extends AppCompatActivity {

    public  static  final  String KEY_DATA_Foods="key_data";
    private ImageView imgHInh;
    private TextView txtDes;
    private RecyclerView ry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        intView();
        Data data = (Data) getIntent().getSerializableExtra(KEY_DATA_Foods);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        ry.setLayoutManager(layoutManager);
        // getKey de gưi tới chitiet activity.
        DataDetailFoods.getDataRecyViewDetailFoods(data.getKey(),ry,this);

//        Glide.with(this).load(data.getImage()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imgHInh);
//        txtDes.setText(data.getDesc().toString());



    }

    private void intView() {

        ry= (RecyclerView) findViewById(R.id.ryDetail);
    }
}
