package com.example.meobeou.fireabase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.meobeou.adapter.DataAdapterFoods;
import com.example.meobeou.model.Data;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by qwer on 12/5/2016.
 */
public class DataDetailFoods {
    public static DatabaseReference dataFoods;
    private static ArrayList<Data> listFoods;
    public  static  final  String URL="https://tn-travelandservices-43086.firebaseio.com/AmThuc/Data";
    public  static Firebase firebase;
    private static DataAdapterFoods dataAdapter;

        public static void getDataRecyViewDetailFoods(String key, final RecyclerView ry, final Context context) {

        dataFoods = FirebaseDatabase.getInstance().getReference().child("AmThuc").child("DanhSachCT").child(key);
        dataFoods.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listFoods = new ArrayList<Data>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Data food;
                    food = snapshot.getValue(Data.class);
                    food.setKey(snapshot.getKey());
                    listFoods.add(food);
                }
                dataAdapter =new DataAdapterFoods(listFoods,context,0);
                ry.setAdapter(dataAdapter);
                Log.e("dtaa", listFoods.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
