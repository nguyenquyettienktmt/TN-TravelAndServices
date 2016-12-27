package com.example.meobeou.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.meobeou.model.Data;
import com.example.meobeou.tn_travelandservices.R;

/**
 * Created by qwer on 12/3/2016.
 */
public class ActivityDetailTravels extends AppCompatActivity {

    public  static  final  String KEY_DATA="key_data";
    private ImageView imgHInh;
    private TextView txtDes;
    private WebView webView;



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        intView();
        Data data = (Data) getIntent().getSerializableExtra(KEY_DATA);

        Glide.with(this).load(data.getImage()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imgHInh);
        txtDes.setText(data.getDesc().toString());
        txtDes.setMovementMethod(new ScrollingMovementMethod());
        //webView.setTextDirection((data.getDesc().toString()));
    }

    private void intView() {
        imgHInh = (ImageView) findViewById(R.id.imgHinh);
        txtDes = (TextView) findViewById(R.id.txtDes);
        //webView = (WebView) findViewById(R.id.webView);
    }
}
