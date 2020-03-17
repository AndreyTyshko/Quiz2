package com.example.fragmentapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fragmentapp.R;

public class CheckBoxFragment  extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState) {
        View viewHierarhy = inflater.inflate(R.layout.checkbox_fragment, container, false);
        return viewHierarhy;
    }
}
