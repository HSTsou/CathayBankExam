package com.hs.cathaybankexam.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Plant implements Parcelable {
    @SerializedName("F_Name_Latin")
    private String F_Name_Latin;
    @SerializedName("F_pdf02_ALT")
    private String F_pdf02_ALT;
    @SerializedName("F_Location")
    private String F_Location;
    @SerializedName("F_pdf01_ALT")
    private String F_pdf01_ALT;
    @SerializedName("rank")
    private float rank;
    @SerializedName("F_Summary")
    private String F_Summary;
    @SerializedName("F_Pic01_URL")
    private String F_Pic01_URL;
    @SerializedName("_full_count")
    private String _full_count;
    @SerializedName("F_pdf02_URL")
    private String F_pdf02_URL;
    @SerializedName("F_Pic02_URL")
    private String F_Pic02_URL;
    @SerializedName("F_Keywords")
    private String F_Keywords;
    @SerializedName("F_Code")
    private String F_Code;
    @SerializedName("F_Geo")
    private String F_Geo;
    @SerializedName("F_Pic03_URL")
    private String F_Pic03_URL;
    @SerializedName("F_Voice01_ALT")
    private String F_Voice01_ALT;
    @SerializedName("F_AlsoKnown")
    private String F_AlsoKnown;
    @SerializedName("F_Voice02_ALT")
    private String F_Voice02_ALT;
    @SerializedName("F_Name_Ch")
    private String F_Name_Ch;
    @SerializedName("F_Pic04_ALT")
    private String F_Pic04_ALT;
    @SerializedName("F_Name_En")
    private String F_Name_En;
    @SerializedName("F_Brief")
    private String F_Brief;
    @SerializedName("F_Pic04_URL")
    private String F_Pic04_URL;
    @SerializedName("F_Voice01_URL")
    private String F_Voice01_URL;
    @SerializedName("F_Feature")
    private String F_Feature;
    @SerializedName("F_Pic02_ALT")
    private String F_Pic02_ALT;
    @SerializedName("F_Family")
    private String F_Family;
    @SerializedName("F_Voice03_ALT")
    private String F_Voice03_ALT;
    @SerializedName("F_Voice02_URL")
    private String F_Voice02_URL;
    @SerializedName("F_Pic03_ALT")
    private String F_Pic03_ALT;
    @SerializedName("F_Pic01_ALT")
    private String F_Pic01_ALT;
    @SerializedName("F_CID")
    private String F_CID;
    @SerializedName("F_pdf01_URL")
    private String F_pdf01_URL;
    @SerializedName("F_Vedio_URL")
    private String F_Vedio_URL;
    @SerializedName("F_Genus")
    private String F_Genus;
    @SerializedName("F_Function＆Application")
    private String F_Function_Application;
    @SerializedName("F_Voice03_URL")
    private String F_Voice03_URL;
    @SerializedName("F_Update")
    private String F_Update;
    @SerializedName("_id")
    private float _id;

    protected Plant(Parcel in) {
        F_Name_Latin = in.readString();
        F_pdf02_ALT = in.readString();
        F_Location = in.readString();
        F_pdf01_ALT = in.readString();
        rank = in.readFloat();
        F_Summary = in.readString();
        F_Pic01_URL = in.readString();
        _full_count = in.readString();
        F_pdf02_URL = in.readString();
        F_Pic02_URL = in.readString();
        F_Keywords = in.readString();
        F_Code = in.readString();
        F_Geo = in.readString();
        F_Pic03_URL = in.readString();
        F_Voice01_ALT = in.readString();
        F_AlsoKnown = in.readString();
        F_Voice02_ALT = in.readString();
        F_Name_Ch = in.readString();
        F_Pic04_ALT = in.readString();
        F_Name_En = in.readString();
        F_Brief = in.readString();
        F_Pic04_URL = in.readString();
        F_Voice01_URL = in.readString();
        F_Feature = in.readString();
        F_Pic02_ALT = in.readString();
        F_Family = in.readString();
        F_Voice03_ALT = in.readString();
        F_Voice02_URL = in.readString();
        F_Pic03_ALT = in.readString();
        F_Pic01_ALT = in.readString();
        F_CID = in.readString();
        F_pdf01_URL = in.readString();
        F_Vedio_URL = in.readString();
        F_Genus = in.readString();
        F_Function_Application = in.readString();
        F_Voice03_URL = in.readString();
        F_Update = in.readString();
        _id = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(F_Name_Latin);
        dest.writeString(F_pdf02_ALT);
        dest.writeString(F_Location);
        dest.writeString(F_pdf01_ALT);
        dest.writeFloat(rank);
        dest.writeString(F_Summary);
        dest.writeString(F_Pic01_URL);
        dest.writeString(_full_count);
        dest.writeString(F_pdf02_URL);
        dest.writeString(F_Pic02_URL);
        dest.writeString(F_Keywords);
        dest.writeString(F_Code);
        dest.writeString(F_Geo);
        dest.writeString(F_Pic03_URL);
        dest.writeString(F_Voice01_ALT);
        dest.writeString(F_AlsoKnown);
        dest.writeString(F_Voice02_ALT);
        dest.writeString(F_Name_Ch);
        dest.writeString(F_Pic04_ALT);
        dest.writeString(F_Name_En);
        dest.writeString(F_Brief);
        dest.writeString(F_Pic04_URL);
        dest.writeString(F_Voice01_URL);
        dest.writeString(F_Feature);
        dest.writeString(F_Pic02_ALT);
        dest.writeString(F_Family);
        dest.writeString(F_Voice03_ALT);
        dest.writeString(F_Voice02_URL);
        dest.writeString(F_Pic03_ALT);
        dest.writeString(F_Pic01_ALT);
        dest.writeString(F_CID);
        dest.writeString(F_pdf01_URL);
        dest.writeString(F_Vedio_URL);
        dest.writeString(F_Genus);
        dest.writeString(F_Function_Application);
        dest.writeString(F_Voice03_URL);
        dest.writeString(F_Update);
        dest.writeFloat(_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Plant> CREATOR = new Creator<Plant>() {
        @Override
        public Plant createFromParcel(Parcel in) {
            return new Plant(in);
        }

        @Override
        public Plant[] newArray(int size) {
            return new Plant[size];
        }
    };

    public String getF_Name_Latin() {
        return F_Name_Latin;
    }

    public void setF_Name_Latin(String f_Name_Latin) {
        F_Name_Latin = f_Name_Latin;
    }

    public String getF_pdf02_ALT() {
        return F_pdf02_ALT;
    }

    public void setF_pdf02_ALT(String f_pdf02_ALT) {
        F_pdf02_ALT = f_pdf02_ALT;
    }

    public String getF_Location() {
        return F_Location;
    }

    public void setF_Location(String f_Location) {
        F_Location = f_Location;
    }

    public String getF_pdf01_ALT() {
        return F_pdf01_ALT;
    }

    public void setF_pdf01_ALT(String f_pdf01_ALT) {
        F_pdf01_ALT = f_pdf01_ALT;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public String getF_Summary() {
        return F_Summary;
    }

    public void setF_Summary(String f_Summary) {
        F_Summary = f_Summary;
    }

    public String getF_Pic01_URL() {
        return F_Pic01_URL;
    }

    public void setF_Pic01_URL(String f_Pic01_URL) {
        F_Pic01_URL = f_Pic01_URL;
    }

    public String get_full_count() {
        return _full_count;
    }

    public void set_full_count(String _full_count) {
        this._full_count = _full_count;
    }

    public String getF_pdf02_URL() {
        return F_pdf02_URL;
    }

    public void setF_pdf02_URL(String f_pdf02_URL) {
        F_pdf02_URL = f_pdf02_URL;
    }

    public String getF_Pic02_URL() {
        return F_Pic02_URL;
    }

    public void setF_Pic02_URL(String f_Pic02_URL) {
        F_Pic02_URL = f_Pic02_URL;
    }

    public String getF_Keywords() {
        return F_Keywords;
    }

    public void setF_Keywords(String f_Keywords) {
        F_Keywords = f_Keywords;
    }

    public String getF_Code() {
        return F_Code;
    }

    public void setF_Code(String f_Code) {
        F_Code = f_Code;
    }

    public String getF_Geo() {
        return F_Geo;
    }

    public void setF_Geo(String f_Geo) {
        F_Geo = f_Geo;
    }

    public String getF_Pic03_URL() {
        return F_Pic03_URL;
    }

    public void setF_Pic03_URL(String f_Pic03_URL) {
        F_Pic03_URL = f_Pic03_URL;
    }

    public String getF_Voice01_ALT() {
        return F_Voice01_ALT;
    }

    public void setF_Voice01_ALT(String f_Voice01_ALT) {
        F_Voice01_ALT = f_Voice01_ALT;
    }

    public String getF_AlsoKnown() {
        return F_AlsoKnown;
    }

    public void setF_AlsoKnown(String f_AlsoKnown) {
        F_AlsoKnown = f_AlsoKnown;
    }

    public String getF_Voice02_ALT() {
        return F_Voice02_ALT;
    }

    public void setF_Voice02_ALT(String f_Voice02_ALT) {
        F_Voice02_ALT = f_Voice02_ALT;
    }

    public String getF_Name_Ch() {
        return F_Name_Ch;
    }

    public void setF_Name_Ch(String f_Name_Ch) {
        F_Name_Ch = f_Name_Ch;
    }

    public String getF_Pic04_ALT() {
        return F_Pic04_ALT;
    }

    public void setF_Pic04_ALT(String f_Pic04_ALT) {
        F_Pic04_ALT = f_Pic04_ALT;
    }

    public String getF_Name_En() {
        return F_Name_En;
    }

    public void setF_Name_En(String f_Name_En) {
        F_Name_En = f_Name_En;
    }

    public String getF_Brief() {
        return F_Brief;
    }

    public void setF_Brief(String f_Brief) {
        F_Brief = f_Brief;
    }

    public String getF_Pic04_URL() {
        return F_Pic04_URL;
    }

    public void setF_Pic04_URL(String f_Pic04_URL) {
        F_Pic04_URL = f_Pic04_URL;
    }

    public String getF_Voice01_URL() {
        return F_Voice01_URL;
    }

    public void setF_Voice01_URL(String f_Voice01_URL) {
        F_Voice01_URL = f_Voice01_URL;
    }

    public String getF_Feature() {
        return F_Feature;
    }

    public void setF_Feature(String f_Feature) {
        F_Feature = f_Feature;
    }

    public String getF_Pic02_ALT() {
        return F_Pic02_ALT;
    }

    public void setF_Pic02_ALT(String f_Pic02_ALT) {
        F_Pic02_ALT = f_Pic02_ALT;
    }

    public String getF_Family() {
        return F_Family;
    }

    public void setF_Family(String f_Family) {
        F_Family = f_Family;
    }

    public String getF_Voice03_ALT() {
        return F_Voice03_ALT;
    }

    public void setF_Voice03_ALT(String f_Voice03_ALT) {
        F_Voice03_ALT = f_Voice03_ALT;
    }

    public String getF_Voice02_URL() {
        return F_Voice02_URL;
    }

    public void setF_Voice02_URL(String f_Voice02_URL) {
        F_Voice02_URL = f_Voice02_URL;
    }

    public String getF_Pic03_ALT() {
        return F_Pic03_ALT;
    }

    public void setF_Pic03_ALT(String f_Pic03_ALT) {
        F_Pic03_ALT = f_Pic03_ALT;
    }

    public String getF_Pic01_ALT() {
        return F_Pic01_ALT;
    }

    public void setF_Pic01_ALT(String f_Pic01_ALT) {
        F_Pic01_ALT = f_Pic01_ALT;
    }

    public String getF_CID() {
        return F_CID;
    }

    public void setF_CID(String f_CID) {
        F_CID = f_CID;
    }

    public String getF_pdf01_URL() {
        return F_pdf01_URL;
    }

    public void setF_pdf01_URL(String f_pdf01_URL) {
        F_pdf01_URL = f_pdf01_URL;
    }

    public String getF_Vedio_URL() {
        return F_Vedio_URL;
    }

    public void setF_Vedio_URL(String f_Vedio_URL) {
        F_Vedio_URL = f_Vedio_URL;
    }

    public String getF_Genus() {
        return F_Genus;
    }

    public void setF_Genus(String f_Genus) {
        F_Genus = f_Genus;
    }

    public String getF_Function_Application() {
        return F_Function_Application;
    }

    public void setF_Function_Application(String f_Function_Application) {
        F_Function_Application = f_Function_Application;
    }

    public String getF_Voice03_URL() {
        return F_Voice03_URL;
    }

    public void setF_Voice03_URL(String f_Voice03_URL) {
        F_Voice03_URL = f_Voice03_URL;
    }

    public String getF_Update() {
        return F_Update;
    }

    public void setF_Update(String f_Update) {
        F_Update = f_Update;
    }

    public float get_id() {
        return _id;
    }

    public void set_id(float _id) {
        this._id = _id;
    }
}
