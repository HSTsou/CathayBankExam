package com.hs.cathaybankexam.network.responce;

import com.google.gson.annotations.SerializedName;
import com.hs.cathaybankexam.model.Area;

import java.util.List;

public class AreaResponse {

    @SerializedName("result")
    ResultResponse result;

    public ResultResponse getResult() {
        return result;
    }

    public void setResult(ResultResponse result) {
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
        private List<Area> results;

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

        public List<Area> getResults() {
            return results;
        }

        public void setResults(List<Area> results) {
            this.results = results;
        }
    }
}
