package com.example.jixiaofan.rentinghousetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jixiaofan on 2022/7/10.
 */

public class HouseDetailedFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.house_detailed_frag, container, false);
        return view;
    }

    public void refresh(String houseName, int houseImageId) {
        View visivilityLayout = view.findViewById(R.id.visibility_layout);
        visivilityLayout.setVisibility(View.VISIBLE);

        TextView houseNameText = (TextView) view.findViewById(R.id.house_detailed_name);
        ImageView houseImageText = (ImageView) view.findViewById(R.id.house_detailed_image);
        houseNameText.setText(houseName);
        houseImageText.setImageResource(houseImageId);

    }

}

