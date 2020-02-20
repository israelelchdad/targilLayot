package com.example.targillayotrelatiandliner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    ProgressBar progressBar;
    ImageView yesiva;
    ArrayList<Car> araeycar;
    RecyclerView myrecycleviiew;
    AdapterOfCar myadapter;
    private static int request_Code = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imageView = findViewById(R.id.imgrelativ);
//        imageView.setOnClickListener(this);
        araeycar = dataofcar();
        yesiva =findViewById(R.id.ma_yesiva);
        yesiva.setOnClickListener(this);
        initRecyclView();
        //goneporgres();
    }

    private void initRecyclView() {
         myrecycleviiew = findViewById(R.id.ma_cae_rcv);
        RecyclerView.LayoutManager manager =  new LinearLayoutManager(this);
        myrecycleviiew.setLayoutManager(manager);
        myadapter = new AdapterOfCar(this,araeycar);
        myrecycleviiew.setAdapter(myadapter);

    }

    private  ArrayList<Car> dataofcar() {
        ArrayList<Car> arrcar =new ArrayList<>();
//        arrcar.add(new Car(R.drawable.v2,"volvo 1"));
//        arrcar.add(new Car(R.drawable.v4,"volvo 2"));
//        arrcar.add(new Car(R.drawable.v7,"volvo 3"));
//        arrcar.add(new Car(R.drawable.v4,"volvo 4"));
//        arrcar.add(new Car(R.drawable.v2,"volvo 5"));
//        arrcar.add(new Car(R.drawable.v7,"volvo 6"));
//        arrcar.add(new Car(R.drawable.v2,"volvo 7"));
//        arrcar.add(new Car(R.drawable.v2,"volvo 8 "));

        arrcar.add(new Car("volvo 1","https://upload.wikimedia.org/wikipedia/he/thumb/7/77/VOLVOPV544.JPG/375px-VOLVOPV544.JPG"));
        arrcar.add(new Car("volvo 2","https://upload.wikimedia.org/wikipedia/he/thumb/7/77/VOLVOPV544.JPG/375px-VOLVOPV544.JPG"));
        arrcar.add(new Car("volvo 3","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Volvo_340DL_darksilver_hl.jpg/375px-Volvo_340DL_darksilver_hl.jpg"));
        arrcar.add(new Car("volvo 4","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Volvo_340DL_darksilver_hl.jpg/375px-Volvo_340DL_darksilver_hl.jpg"));
        arrcar.add(new Car("volvo 5","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Volvo_340DL_darksilver_hl.jpg/375px-Volvo_340DL_darksilver_hl.jpg"));
        arrcar.add(new Car("volvo 6","https://upload.wikimedia.org/wikipedia/he/thumb/7/77/VOLVOPV544.JPG/375px-VOLVOPV544.JPG"));
        arrcar.add(new Car("volvo 7","https://upload.wikimedia.org/wikipedia/he/thumb/7/77/VOLVOPV544.JPG/375px-VOLVOPV544.JPG"));
        arrcar.add(new Car("volvo 8","https://upload.wikimedia.org/wikipedia/he/thumb/7/77/VOLVOPV544.JPG/375px-VOLVOPV544.JPG"));



        return arrcar;
    }


    @Override
    protected void onResume() {
        super.onResume();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressBar = findViewById(R.id.progres);
                progressBar.setVisibility(View.GONE);
                // Actions to do after 5 seconds
            }
        }, 5000);
        registerReceiver(mReceiver, new IntentFilter(ActivityOther.BROADCAST_FILTER));
    }

//    private void goneporgres() {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                progressBar = findViewById(R.id.progres);
//                progressBar.setVisibility(View.GONE);
//                // Actions to do after 5 seconds
//            }
//        }, 5000);
//    }



    @Override
    public void onClick(View v) {
//        progressBar = findViewById(R.id.progres);
//        progressBar.setVisibility(View.GONE);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listcar", araeycar);
        Intent intent = new Intent(this,ActivityOther.class);
        intent.putExtras(bundle);
//        startActivityForResult(intent, request_Code);
        startActivity(intent);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == request_Code && resultCode == ActivityOther.RUSULT_CODE ){
//        ArrayList<Car> araeycar2 = data.getExtras().getParcelableArrayList(ActivityOther.key_bundle);
//            araeycar.clear();
//            araeycar.addAll(araeycar2);
//            myadapter.notifyDataSetChanged();
//            int size = araeycar.size();
//            AdapterOfCar myadapter = new AdapterOfCar(this,araeycar);
//            myrecycleviiew.setAdapter(myadapter);

        }
    }
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Do what you need in here
            ArrayList<Car> araeycar2 = intent.getExtras().getParcelableArrayList(ActivityOther.key_bundle);
            araeycar.clear();
            araeycar.addAll(araeycar2);
            myadapter.notifyDataSetChanged();
        }
    };



    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
