package com.example.mybytime.ui.dashboard;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mybytime.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listViewContainer = (ListView)view.findViewById(R.id.list);

        String[] values = new String[] { "Ебучий заголовок1", "Ебучий заголовок2", "Ебучий заголовок3",
                "Ебучий заголовок4", "Ебучий заголовок5", "Ебучий заголовок6", "Ебучий заголовок7", "Ебучий заголовок8",
                "Ебучий заголовок9"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.custom_text_area, R.id.label, values);
        listViewContainer.setAdapter(adapter);
    }
}