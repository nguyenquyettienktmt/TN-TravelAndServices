package com.example.meobeou.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.meobeou.model.Data;
import com.example.meobeou.tn_travelandservices.R;
import com.example.meobeou.view.ActivityDetailTravels;
import com.example.meobeou.view.GoogleMapAPI;

import java.util.ArrayList;

/**
 * Created by qwer on 12/3/2016.
 */


public class DataAdapterTravels extends RecyclerView.Adapter<DataAdapterTravels.RecyclerViewHolder>{
    private ArrayList<Data> _arrExamplan;
    private Context _context;

    public DataAdapterTravels(ArrayList<Data> examResults, Context context) {
        this._arrExamplan = examResults;
        this._context = context;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_detail_travels, parent, false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {

        final Data data =_arrExamplan.get(position);
        //holder.title.setText(data.getKey());
        holder.title.setText(data.getTitle());
        Glide.with(_context).load(data.getImage()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imgHinh);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(_context, GoogleMapAPI.class);
                intent.putExtra(ActivityDetailTravels.KEY_DATA, data);
                _context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return _arrExamplan.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView imgHinh;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            imgHinh = (ImageView) itemView.findViewById(R.id.img_hinh);
        }
    }
}

