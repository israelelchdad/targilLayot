package com.example.targillayotrelatiandliner;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
//    int img;
    String name;
    String imeg;

//    public int getImg() {
//        return img;
//    }
//
//    public void setImg(int img) {
//        this.img = img;
//    }


    protected Car(Parcel in) {
        name = in.readString();
        imeg = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImeg() {
        return imeg;
    }

    public void setImeg(String imeg) {
        this.imeg = imeg;
    }

    public Car(String name, String imeg) {
        this.name = name;
        this.imeg = imeg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imeg);
    }
}
