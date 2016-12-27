package com.example.meobeou.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.meobeou.model.Data;
import com.example.meobeou.tn_travelandservices.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qwer on 12/3/2016.
 */
public class GoogleMapAPI extends FragmentActivity implements OnMapReadyCallback {
    public  static  final  String KEY_DATA="key_data";
    private ImageView imgHInh;
    private TextView txtDes,txttitle;
    private GoogleMap mMap;
    private ProgressDialog progressDialog;
    Double getVidogg,getKinhdogg;
    Spinner spinner;
    ArrayList<String> dsType;
    ArrayAdapter<String> adapterType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmapsapi);
        addControls();
        addEvent();

        final Data data = (Data) getIntent().getSerializableExtra(KEY_DATA);
//        Log.e("x1",data.toString());

        getVidogg = Double.parseDouble(data.getVido());
        getKinhdogg = Double.parseDouble(data.getKinhdo());
        Log.e("getdata",getVidogg.toString());
        Log.e("xxx",getKinhdogg.toString());
        txttitle.setText("Địa Điểm: "+data.getTitle().toString());
        txtDes.setText(data.getDesc().toString());
        txtDes.setMovementMethod(new ScrollingMovementMethod());
    }

    private void addControls() {
        //imgHInh = (ImageView) findViewById(R.id.img_google);
        txttitle = (TextView)findViewById(R.id.txt_title);
        txtDes = (TextView) findViewById(R.id.desc_google);
        spinner = (Spinner) findViewById(R.id.spinner);

    }

    private void addEvent() {
        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1);
        fragment.getMapAsync(GoogleMapAPI.this);

        dsType = new ArrayList<>();
        dsType.addAll(Arrays.asList(getResources().getStringArray(R.array.arrayType)));
        adapterType = new ArrayAdapter<String>(GoogleMapAPI.this, android.R.layout.simple_spinner_item, dsType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterType);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xuLydoichedohienthi(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Thông báo");
        progressDialog.setMessage("đang load map...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

    }
    public void xuLydoichedohienthi(int position){
        switch (position) {
            case 0:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case 3:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case 4:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
        }

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        final Data data = new Data();
        mMap = googleMap;

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                progressDialog.dismiss();
                LatLng location = new LatLng(getVidogg, getKinhdogg);
               mMap.addMarker(new MarkerOptions().position(location).title(data.getTitle()));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16));
                //mMap.setInfoWindowAdapter(new CustomInforAdapter(GoogleMapAPI.this,data));
                //marker.showInfoWindow();
            }
        });
    }
}
