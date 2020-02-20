package com.example.targillayotrelatiandliner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AdapterOfCar extends RecyclerView.Adapter<AdapterOfCar.shuki> {
    public LayoutInflater inflater;
    public ArrayList<Car> cars;

    Activity activity;

    public AdapterOfCar(Context context, ArrayList<Car> cars) {
        this.inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.cars = cars;
    }
    @NonNull
    @Override
    public shuki onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  inflater.inflate( R.layout.iteemofcar,parent,false);

        return new shuki(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull shuki holder, int position) {
        holder.setholder(cars.get(position));

    }



    @Override
    public int getItemCount() {
        return cars.size();
    }
    public class shuki extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageCar;
        TextView textcar;
        ProgressBar myprogres;
        Car mycar;
        Bitmap bmp = null;

        public shuki(@NonNull View itemView) {
            super(itemView);
            imageCar = itemView.findViewById(R.id.imgcar);
            textcar = itemView.findViewById(R.id.textcar);
            myprogres = itemView.findViewById(R.id.progresitem);


        }
        public  void setholder(Car car){
            mycar = car;
            textcar.setText(car.getName());
            textcar.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            myprogres.setVisibility(View.VISIBLE);

//            imageCar.setImageResource(mycar.getImg());

            Thread thread =new Thread(new Runnable() {
                @Override
                public void run() {
                    URL url = null;
                    try {
                        url = new URL(mycar.getImeg());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
//                    Bitmap bmp = null;
                    try {

                        bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            imageCar.setImageBitmap(bmp);
                           myprogres.setVisibility(View.GONE);


                        }
                    });


                }
            });
             thread.start();

//            imageCar.setImageResource(mycar.getImeg());

        }
    }
}
