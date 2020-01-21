package com.hs.cathaybankexam.network.responce;

import com.google.gson.annotations.SerializedName;
import com.hs.cathaybankexam.model.Area;
import com.hs.cathaybankexam.model.Plant;

import java.util.List;

public class PlantResponse {
    @SerializedName("result")
    PlantResponse.ResultResponse result;

    public PlantResponse.ResultResponse getResult() {
        return result;
    }

    public void setResult(PlantResponse.ResultResponse result) {
        this.result = result;
    }

    public class ResultResponse {
        @SerializedName("limit")
        private int limit;
        @SerializedName("offset")
        private int offset;
        @SerializedName("count")
        private int count;
        @SerializedName("sort")
        private String sort;
        @SerializedName("results")
        private List<Plant> results;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public List<Plant> getResults() {
            return results;
        }

        public void setResults(List<Plant> results) {
            this.results = results;
        }
    }
}
