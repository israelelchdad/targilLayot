package com.example.targillayotrelatiandliner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ActivityOther extends AppCompatActivity {
    public static int RUSULT_CODE = 1;
    public static String key_bundle = "listcarr";
    ArrayList<Car> carlsList;
    public static final String BROADCAST_FILTER = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Bundle getBundle = this.getIntent().getExtras();
         carlsList = getBundle.getParcelableArrayList("listcar");
        chngelist(carlsList);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(key_bundle,  carlsList);
        Intent data = new Intent(BROADCAST_FILTER);
        data.putExtras(bundle);
        sendBroadcast(data);
    }

    private void chngelist(ArrayList<Car>carArrayList) {
        carArrayList.get(0).setName("chengenamfromactivity");

        ArrayList<Car> ARCAR = carArrayList;


    }
//    @Override
//    public void onBackPressed() {
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList(key_bundle,  carlsList);
//        Intent data = new Intent();
//        data.putExtras(bundle);
//        setResult(RUSULT_CODE, data);
//        super.onBackPressed();
//    }
}
