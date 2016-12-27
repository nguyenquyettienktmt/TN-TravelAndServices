package com.example.meobeou.fireabase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.meobeou.adapter.DataAdapterTravels;
import com.example.meobeou.model.Data;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by qwer on 12/3/2016.
 */
public class DataTravel {

    public static DatabaseReference dataTravel;
    private static ArrayList<Data> listTravel;
    public  static  final  String URL="https://tn-travelandservices-43086.firebaseio.com/AmThuc/Data";
    public  static Firebase firebase;
    private static DataAdapterTravels dataAdapterTravels;

    public static  ArrayList<Data> getDataRecyViewTravel(String key, final RecyclerView ry, final Context context) {

        dataTravel = FirebaseDatabase.getInstance().getReference().child("Travel").child(key);
        //dataTravel = FirebaseDatabase.getInstance().getReference().child("AmThuc").child("DanhSachCT").child(key);
       // Toast.makeText(context,key,Toast.LENGTH_LONG).show();
        dataTravel.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listTravel = new ArrayList<Data>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Data travel;
                    travel = snapshot.getValue(Data.class);
                    travel.setKey(snapshot.getKey());
                    listTravel.add(travel);
                }
                dataAdapterTravels =new DataAdapterTravels(listTravel,context);
                ry.setAdapter(dataAdapterTravels);
                Log.e("dataTravel", listTravel.toString());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return listTravel;

    }

//    public  static  void getData2(){
//
//        firebase=new Firebase(URL);
//        firebase.addValueEventListener(new com.firebase.client.ValueEventListener() {
//            @Override
//            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
//                for (com.firebase.client.DataSnapshot data:dataSnapshot.getChildren()) {
//                    Data  gocBep=data.getValue(Data.class);
//                    Log.e("Dtaaaaa",data.getKey());
//                    listGocBep.add(gocBep );
//                }
//
//                Log.e("Dtaaaaa",listGocBep .toString());
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//    }
}
