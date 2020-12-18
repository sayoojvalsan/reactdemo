package com.demoreact2;

import android.util.Log;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        CustomAdapter customAdapter = new CustomAdapter(Arrays.asList(arr));
        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.setAdapter(customAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(reactContext);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        return recyclerView;
    }

    @ReactProp(name="data")
    public void setData(RecyclerView recyclerView, ReadableArray data) {
        List<String> comments = new ArrayList<>();
        for(int i = 0; i < data.size(); i ++){
            ReadableMap map = data.getMap(i);
            String comment = map.getString("body");
            Log.d("TAG", "comment = " + comment);
            comments.add(comment);
        }
        CustomAdapter adapter = (CustomAdapter) recyclerView.getAdapter();
        adapter.setData(comments);
    }
}



