package com.example.android.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartupFragment extends Fragment {

    String api ="a0b7d61fbf9a43b9b842c8b6460dff44";
    ArrayList<ModalClass> modalClassArrayList;
    Adapter adapter;
    private RecyclerView recyclerViewOfStartup;
    private String q = "startup";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.startupfragment,null);

        recyclerViewOfStartup = v.findViewById(R.id.startup_recyclerView);
        modalClassArrayList = new ArrayList<>();
        recyclerViewOfStartup.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modalClassArrayList);
        recyclerViewOfStartup.setAdapter(adapter);

        findNews();

        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getStartupNews(q,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modalClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
