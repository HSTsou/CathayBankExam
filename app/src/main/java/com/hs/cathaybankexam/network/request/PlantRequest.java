package com.hs.cathaybankexam.network.request;

import com.hs.cathaybankexam.network.responce.PlantResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlantRequest {
    String PRE_STR = "apiAccess";

    @GET(PRE_STR)
    Single<PlantResponse> getPlantData(
            @Query("scope")
                    String scope,
            @Query("rid")
                    String rid,
            @Query("q")
                    String q,
            @Query("limit")
                    int limit,
            @Query("offset")
                    int offset
    );

}
