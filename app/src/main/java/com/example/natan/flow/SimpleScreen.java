package com.example.natan.flow;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleScreen implements Parcelable {
    @Override public void writeToParcel(Parcel dest, int flags) {
    }

    @Override public int describeContents() {
        return 0;
    }

    public static final Creator<SimpleScreen> CREATOR = new Creator<SimpleScreen>() {
        @Override public SimpleScreen createFromParcel(Parcel in) {
            return new SimpleScreen();
        }

        @Override public SimpleScreen[] newArray(int size) {
            return new SimpleScreen[size];
        }
    };

    @Override public boolean equals(Object o) {
        return o != null && o instanceof SimpleScreen;
    }
}
