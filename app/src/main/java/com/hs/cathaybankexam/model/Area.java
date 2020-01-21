package com.hs.cathaybankexam.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Area implements Parcelable {
    @SerializedName("E_Pic_URL")
    private String e_Pic_URL;
    @SerializedName("E_Geo")
    private String e_Geo;
    @SerializedName("E_Info")
    private String e_Info;
    @SerializedName("E_no")
    private int e_no;
    @SerializedName("E_Category")
    private
    String e_Category;
    @SerializedName("E_Name")
    private String e_Name;
    @SerializedName("E_Memo")
    private String e_Memo;
    @SerializedName("_id")
    private int _id;
    @SerializedName("E_URL")
    private String e_URL;

    protected Area(Parcel in) {
        e_Pic_URL = in.readString();
        e_Geo = in.readString();
        e_Info = in.readString();
        e_no = in.readInt();
        e_Category = in.readString();
        e_Name = in.readString();
        e_Memo = in.readString();
        _id = in.readInt();
        e_URL = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(e_Pic_URL);
        dest.writeString(e_Geo);
        dest.writeString(e_Info);
        dest.writeInt(e_no);
        dest.writeString(e_Category);
        dest.writeString(e_Name);
        dest.writeString(e_Memo);
        dest.writeInt(_id);
        dest.writeString(e_URL);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Area> CREATOR = new Creator<Area>() {
        @Override
        public Area createFromParcel(Parcel in) {
            return new Area(in);
        }

        @Override
        public Area[] newArray(int size) {
            return new Area[size];
        }
    };

    public String getE_Pic_URL() {
        return e_Pic_URL;
    }

    public void setE_Pic_URL(String e_Pic_URL) {
        this.e_Pic_URL = e_Pic_URL;
    }

    public String getE_Geo() {
        return e_Geo;
    }

    public void setE_Geo(String e_Geo) {
        this.e_Geo = e_Geo;
    }

    public String getE_Info() {
        return e_Info;
    }

    public void setE_Info(String e_Info) {
        this.e_Info = e_Info;
    }

    public int getE_no() {
        return e_no;
    }

    public void setE_no(int e_no) {
        this.e_no = e_no;
    }

    public String getE_Category() {
        return e_Category;
    }

    public void setE_Category(String e_Category) {
        this.e_Category = e_Category;
    }

    public String getE_Name() {
        return e_Name;
    }

    public void setE_Name(String e_Name) {
        this.e_Name = e_Name;
    }

    public String getE_Memo() {
        return e_Memo;
    }

    public void setE_Memo(String e_Memo) {
        this.e_Memo = e_Memo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getE_URL() {
        return e_URL;
    }

    public void setE_URL(String e_URL) {
        this.e_URL = e_URL;
    }


}
