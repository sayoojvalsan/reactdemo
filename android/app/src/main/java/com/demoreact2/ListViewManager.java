package com.demoreact2;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class ListViewManager extends SimpleViewManager<RecyclerView>{
    public static final String REACT_CLASS = "MyListView";


    @Override
    public String getName() {
        return REACT_CLASS;
    }


    @Override
    protected RecyclerView createViewInstance(ThemedReactContext reactContext) {
        RecyclerView recyclerView = new RecyclerView(reactContext);
        String[] arr = new String[10];
        for(int i = 0 ; i < 10; i ++){
            arr[i] = String.valueOf(i);
        }
        CustomAdapter customAdapter = new CustomAdapter(arr);
        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(reactContext));
        return recyclerView;
    }


}