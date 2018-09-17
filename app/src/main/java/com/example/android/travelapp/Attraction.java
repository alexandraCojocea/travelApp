package com.example.android.travelapp;

import android.os.Parcel;
import android.os.Parcelable;


public class Attraction implements Parcelable {
    private int mAttractionTitleId;

    private int mAttractionLocationId;

    private int mImageResourceId;

    private int mAttractionMapId;

    public Attraction(int attractionTitleId, int attractionLocationId, int imageResourceId, int attractionMapId) {
        mAttractionTitleId = attractionTitleId;
        mAttractionLocationId = attractionLocationId;
        mImageResourceId = imageResourceId;
        mAttractionMapId = attractionMapId;
    }

    public int getAttractionTitleId() {
        return mAttractionTitleId;
    }

    public int getAttractionLocationId() {
        return mAttractionLocationId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAttractionMapId() {
        return mAttractionMapId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mAttractionTitleId);
        dest.writeInt(this.mAttractionLocationId);
        dest.writeInt(this.mImageResourceId);
        dest.writeInt(this.mAttractionMapId);
    }

    protected Attraction(Parcel in) {
        this.mAttractionTitleId = in.readInt();
        this.mAttractionLocationId = in.readInt();
        this.mImageResourceId = in.readInt();
        this.mAttractionMapId = in.readInt();
    }


    public static final Parcelable.Creator<Attraction> CREATOR = new Parcelable.Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel source) {
            return new Attraction(source);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };
}
