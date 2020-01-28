package com.hs.cathaybankexam.network.request;

import com.hs.cathaybankexam.network.responce.AreaResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AreaRequest {
    String PRE_STR = "opendata/datalist/apiAccess";

    @GET(PRE_STR)
    Single<AreaResponse> getAreaData(
            @Query("scope")
                    String scope,
            @Query("rid")
                    String rid,
            @Query("limit")
                    int limit,
            @Query("offset")
                    int offset
    );

}
