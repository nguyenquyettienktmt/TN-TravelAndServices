package com.example.meobeou.CustomInForAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.meobeou.model.Data;
import com.example.meobeou.tn_travelandservices.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by qwer on 12/21/2016.
 */
public class CustomInforAdapter implements GoogleMap.InfoWindowAdapter {
    private Context _context;
    Activity context;
    Data datagooglemaps;

    public CustomInforAdapter(Activity context, Data datagooglemaps) {
        this.context = context;
        this.datagooglemaps = datagooglemaps;


    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(R.layout.vao_bep, null);
//        ImageView imgCustomInfoWindow = (ImageView) row.findViewById(R.id.imgCustomInfoWindow);
//        TextView txtCustomInfoWindow = (TextView) row.findViewById(R.id.txtCustomInfoWindow);

      //  Glide.with(context).load(datagooglemaps.getImage()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imgCustomInfoWindow);
      //  txtCustomInfoWindow.setText(datagooglemaps.getTitle());
        return row;
    }

}
