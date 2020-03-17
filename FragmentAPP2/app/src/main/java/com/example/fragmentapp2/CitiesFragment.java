package com.example.fragmentapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class CitiesFragment extends ListFragment  {

    boolean isExistCoattofarms;
    int currentPosition = 0;




    @Override
    public  View onCreateViev(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_list,container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Cities,
                                                            android.R.layout.simple_list_item_activated_1);

    setListAdapter(adapter)

    View detailFrame = getActivity().findViewById(R.id.coat_of_arms);

    isExistCoattofarms  = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

    if (savedInstanceState !=null){
        currentPosition=SaveInstanceState.getInt("CurrentCity",0);
    }

}
