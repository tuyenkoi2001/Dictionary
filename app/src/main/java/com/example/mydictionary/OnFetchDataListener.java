package com.example.mydictionary;

import com.example.mydictionary.Models.APIrespond;

public interface OnFetchDataListener {
    void onFetchData(APIrespond apiRespond, String message);
    void onError(String message);
}
