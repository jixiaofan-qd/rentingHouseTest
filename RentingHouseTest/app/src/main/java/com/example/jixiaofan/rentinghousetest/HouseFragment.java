package com.example.jixiaofan.rentinghousetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jixiaofan on 2022/7/9.
 */

public class HouseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.house_title_frag, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.house_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        HouseAdapter houseAdapter = new HouseAdapter(initHouses());
        recyclerView.setAdapter(houseAdapter);
        return view;
    }

    private List<House> initHouses() {
        List<House> houseList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            House house1 = new House("太阳园三居室次卧", R.drawable.house1_1);
            houseList.add(house1);
            House house2 = new House("皂君庙两居室主卧", R.drawable.house2_1);
            houseList.add(house2);
            House house3 = new House("双榆树东里三居室全男生", R.drawable.house3_1);
            houseList.add(house3);
        }
        return houseList;
    }


    class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.ViewHolder> {

        private List<House> mHouseList;

        class ViewHolder extends RecyclerView.ViewHolder{

            TextView houseName;
            ImageView houseImage;

            public ViewHolder (View view) {
                super(view);
                houseImage = (ImageView) view.findViewById(R.id.house_image);
                houseName = (TextView) view.findViewById(R.id.house_name);
            }
        }

        public HouseAdapter(List<House> houseList) {
            mHouseList = houseList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            holder.houseImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    House house = mHouseList.get(position);
                    Toast.makeText(v.getContext(), "you click image" + house.getName(), Toast.LENGTH_SHORT).show();
                    DetailedActivity.actionStart(getActivity(),house.getName(),house.getImageId());
                }
            });
            holder.houseName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    House house = mHouseList.get(position);
                    Toast.makeText(v.getContext(), "you click view" + house.getName(), Toast.LENGTH_SHORT).show();
                    DetailedActivity.actionStart(getActivity(),house.getName(),house.getImageId());

                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            House house = mHouseList.get(position);
            holder.houseName.setText(house.getName());
            holder.houseImage.setImageResource(house.getImageId());
        }


        @Override
        public int getItemCount() {
            return mHouseList.size();
        }
    }
}
