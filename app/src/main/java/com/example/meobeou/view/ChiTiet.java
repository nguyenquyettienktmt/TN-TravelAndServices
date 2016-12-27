package com.example.meobeou.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.meobeou.model.Data;
import com.example.meobeou.tn_travelandservices.R;

public class ChiTiet extends AppCompatActivity {
    private ImageView imgHInh;
    private TextView txtDes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        intView();
        Data data = (Data) getIntent().getSerializableExtra("key_data");
        Glide.with(this).load(data.getImage()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imgHInh);
        txtDes.setText(data.getDesc().toString());
        txtDes.setMovementMethod(new ScrollingMovementMethod());
        Log.e("Dattaaaa",data.toString());

    }
    private void intView() {
        imgHInh = (ImageView) findViewById(R.id.imgHinh);
        txtDes = (TextView) findViewById(R.id.txtDes);
    }
}
