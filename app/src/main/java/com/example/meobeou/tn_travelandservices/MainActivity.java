package com.example.meobeou.tn_travelandservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TabHost;

import com.example.meobeou.CamNang.Style_Phuot;
import com.example.meobeou.CamNang.VanHoaThaiNguyen;
import com.example.meobeou.CamNang.VaoBep;
import com.example.meobeou.fireabase.DataFoods;
import com.example.meobeou.fireabase.DataTravel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private TabHost tab;
    private Button btnVHTN, btnVB,btnMV,btnSK,btnTT;
    private RecyclerView mFoodList,mTravelsList,mCamNangList;
    WebView webView;

    private DatabaseReference mFood,mGocTamSu,mTravel,mLamDep,mMeoVat,mSucKhoe,mThoiTrang;
    private String TAG = "MainActivity";
    private RecyclerView rYData,rYData1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //mFood = FirebaseDatabase.getInstance().getReference().child("AmThuc");
            mFood = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tn-travelandservices-43086.firebaseio.com/AmThuc/DanhSachAT");
            addEvent();
            loadtabs();
            addControl();
            setSize1();
            DataTravel.getDataRecyViewTravel("DetailTravel",rYData,this);
            setSize2();
            DataFoods.getDataRecyViewFood("DanhSachAT",rYData1,this);
        }
        catch (Exception ex)
        {
            Log.e(TAG, "1" +  ex.toString());
        }
    }

    View.OnClickListener enventClick = new View.OnClickListener() {
        @Override
        public void onClick(View agr0) {
//            try {
                Bundle bundle = new Bundle();
                switch (agr0.getId()) {
                    case R.id.buttonVanHoaTN: {
                        Intent vanHoaTN = new Intent(MainActivity.this, VanHoaThaiNguyen.class);
                        startActivity(vanHoaTN);
                        break;
                    }
                    case R.id.buttonVaoBep: {
                        Intent vaobep = new Intent(MainActivity.this, VaoBep.class);
                        startActivity(vaobep);
                        break;
                    }
                    case R.id.buttonMeoVat: {
                        bundle.putInt("camnang", 3);
                       // intent.putExtra("MyPackage", bundle);
                       // startActivity(intent);
                        break;
                    }
                    case R.id.buttonSucKhoe: {
                        bundle.putInt("camnang", 4);
                       // intent.putExtra("MyPackage", bundle);
                      //  startActivity(intent);
                        break;
                    }
                    case R.id.buttonThoiTrang: {
                        Intent intentStyle = new Intent(MainActivity.this, Style_Phuot.class);
                        startActivity(intentStyle);
                        break;
                    }
                }
            }
//            catch (Exception ex){
//                Log.e(TAG, "2" +  ex.toString());
//            }
//        }
    };
    private void addControl() {
        try {
            btnMV.setOnClickListener(enventClick);
            btnSK.setOnClickListener(enventClick);
            btnTT.setOnClickListener(enventClick);
            btnVB.setOnClickListener(enventClick);
            btnVHTN.setOnClickListener(enventClick);
        }
        catch (Exception ex){
            Log.e(TAG, "3" +  ex.toString());
        }
    }

    private void addEvent() {
        try {
            webView = (WebView) findViewById(R.id.webViewStyle);
            mCamNangList = (RecyclerView) findViewById(R.id.camnag_lists);
            btnVHTN = (Button) findViewById(R.id.buttonVanHoaTN);
            btnVB = (Button) findViewById(R.id.buttonVaoBep);
            btnMV = (Button) findViewById(R.id.buttonMeoVat);
            btnSK = (Button) findViewById(R.id.buttonSucKhoe);
            btnTT = (Button) findViewById(R.id.buttonThoiTrang);
        }
        catch (Exception ex){
            Log.e(TAG, "4" +  ex.toString());
        }
    }
    public void setSize1(){
        rYData= (RecyclerView) findViewById(R.id.rYData);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rYData.setLayoutManager(linearLayoutManager);
    }
    public void setSize2(){
        rYData1= (RecyclerView) findViewById(R.id.rYData1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rYData1.setLayoutManager(linearLayoutManager);
    }
    private void loadtabs() {

        try {

            tab = (TabHost)findViewById(R.id.tabHost);
            tab.setup();
            TabHost.TabSpec spec;

            //Creat tab1
            spec = tab.newTabSpec("t1");
            spec.setContent(R.id.tab1);
            spec.setIndicator("Cẩm Nang");
            tab.addTab(spec);

            //Creat tab2
            spec = tab.newTabSpec("t2");
            spec.setContent(R.id.tab2);
            spec.setIndicator("Du Lịch");
            tab.addTab(spec);

            //Creat tab3
            spec = tab.newTabSpec("t3");
            spec.setContent(R.id.tab3);
            spec.setIndicator("Ẩm Thực");
            tab.addTab(spec);
            tab.setCurrentTab(1); // mac dinh tab 1 dc chay 0,1,2

            tab.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.background2);
            tab.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.background4);
            tab.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.background5);
        }
        catch (Exception ex){
            Log.e(TAG,"5" + ex.toString() );

        }
    }
    // thao tac voi csdl.


    @Override
    protected void onStart() {
        super.onStart();

//            FirebaseRecyclerAdapter<foods, FoodViewHolder> travelsRecyclerAdapter = new FirebaseRecyclerAdapter<foods, FoodViewHolder>(
//                    foods.class,
//                    R.layout.foods_list,
//                    FoodViewHolder.class,
//                    mTravel
//            ) {
//                @Override
//                protected void populateViewHolder(FoodViewHolder viewHolder, foods model, final int position) {
//                    viewHolder.setTitle(model.title);
//                    viewHolder.setImage(getApplicationContext(), model.image);
//                    viewHolder.mView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//
//                            String post_key_DL = getRef(position).getKey();
//                            Toast.makeText(MainActivity.this,post_key_DL, Toast.LENGTH_SHORT).show();
//                            Intent DuLichNext = new Intent(MainActivity.this, ChiTiet_DL.class);
//                            DuLichNext.putExtra("DuLich_id", post_key_DL);
//                            startActivity(DuLichNext);
//                            //startActivity(new Intent(MainActivity.this, followTheRegion.class));
//                        }
//                    });
//                }
//            };
//            mTravelsList.getRecycledViewPool().clear();
//            mTravelsList.setAdapter(travelsRecyclerAdapter);
//            travelsRecyclerAdapter.notifyDataSetChanged()
//
//            FirebaseRecyclerAdapter<foods, FoodViewHolder> foodsRecyclerAdapter = new FirebaseRecyclerAdapter<foods, FoodViewHolder>(
//                    foods.class,
//                    R.layout.item_detail_foods,
//                    FoodViewHolder.class,
//                    mFood
//            ) {
//                @Override
//                protected void populateViewHolder(FoodViewHolder viewHolder, foods model, final int position) {
//                    viewHolder.setTitleAT(model.title);
//                    viewHolder.setImageAT(getApplicationContext(), model.image);
//                    viewHolder.mView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            try {
//                                String post_key = getRef(position).getKey();
//                                Intent amthucNext = new Intent(MainActivity.this, amthuc_next.class);
//                                amthucNext.putExtra("AmThuc_id", post_key);
//                                startActivity(amthucNext);
//                            } catch (Exception ex) {
//                                Log.e(TAG, "Lỗi ở đây" + ex.toString());
//                            }
//                        }
//                    });
//                }
//            };
//            mFoodList.getRecycledViewPool().clear();
//            mFoodList.setAdapter(foodsRecyclerAdapter);
//            foodsRecyclerAdapter.notifyDataSetChanged();
//
//        }
//
//
//    //ham fix list.
//    public static class FoodViewHolder extends RecyclerView.ViewHolder {
//
//            View mView;
//            public FoodViewHolder(View itemView) {
//            super(itemView);
//            mView = itemView;
//        }
//        public void setTitle(String title){
//            TextView post_title = (TextView)mView.findViewById(R.id.post_title);
//            post_title.setText(title);
//        }
//        public void setImage(Context txt, String image){
//            ImageView post_image = (ImageView)mView.findViewById(R.id.post_image);
//            Picasso.with(txt).load(image).into(post_image);
//        }
//        public void setTitleAT(String title){
//            TextView post_titleAT = (TextView)mView.findViewById(R.id.txt_title);
//            post_titleAT.setText(title);
//        }
//        public void setImageAT(Context txt, String image){
//            ImageView post_imageAT = (ImageView)mView.findViewById(R.id.img_hinh);
//            Picasso.with(txt).load(image).into(post_imageAT);
//        }
    }
    // tao menu tren thanh cong cu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }
}
