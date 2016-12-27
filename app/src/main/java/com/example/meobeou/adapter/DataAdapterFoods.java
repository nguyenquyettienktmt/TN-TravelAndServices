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
import com.example.meobeou.view.ChiTiet;
import com.example.meobeou.model.Data;
import com.example.meobeou.tn_travelandservices.R;
import com.example.meobeou.view.ActivityDetailFoods;

import java.util.ArrayList;

/**
 * Created by qwer on 12/5/2016.
 */
public class DataAdapterFoods extends RecyclerView.Adapter<DataAdapterFoods.RecyclerViewHolder> {
    private ArrayList<Data> _arrExamplan;
    private Context _context;
   // private ArrayList<Data> _DetailFoods;
    private  int flag;

    public DataAdapterFoods(ArrayList<Data> examResults, Context context,int flag) {
        this._arrExamplan = examResults;
        this._context = context;
        this.flag=flag;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_detail_foods, parent, false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        final Data dataFoods =_arrExamplan.get(position);
        //holder.title.setText(data.getKey());
        holder.title.setText(dataFoods.getTitle());
        Glide.with(_context).load(dataFoods.getImage()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imgHinh);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    Intent intent=new Intent(_context, ActivityDetailFoods.class);

                    intent.putExtra(ActivityDetailFoods.KEY_DATA_Foods, dataFoods);
                    _context.startActivity(intent);
                }
                else{
                    Intent intent=new Intent(_context, ChiTiet.class);

                    intent.putExtra(ActivityDetailFoods.KEY_DATA_Foods, dataFoods);
                    _context.startActivity(intent);
                }
//                switch (flag){
//                    case 1: Intent intent=new Intent(_context, ActivityDetailFoods.class);
//
//                        intent.putExtra(ActivityDetailFoods.KEY_DATA, data);
//                        _context.startActivity(intent);
//                        break;
//                    case 2: Intent intent2=new Intent(_context, ChiTiet.class);
//
//                        intent2.putExtra(ActivityDetailFoods.KEY_DATA, data);
//                        _context.startActivity(intent2);
//                }

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
