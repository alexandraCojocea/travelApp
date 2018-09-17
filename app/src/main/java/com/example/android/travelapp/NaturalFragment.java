package com.example.android.travelapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class NaturalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.string.attraction_natural_name_one, R.string.attraction_natural_location_one,
                R.drawable.attraction_one, R.string.attraction_natural_map_one));
        attractions.add(new Attraction(R.string.attraction_natural_name_two, R.string.attraction_natural_location_two,
                R.drawable.attraction_two, R.string.attraction_natural_map_two));
        attractions.add(new Attraction(R.string.attraction_natural_name_three, R.string.attraction_natural_location_three,
                R.drawable.attraction_three, R.string.attraction_natural_map_three));
        attractions.add(new Attraction(R.string.attraction_natural_name_four, R.string.attraction_natural_location_four,
                R.drawable.attraction_four, R.string.attraction_natural_map_four));
        attractions.add(new Attraction(R.string.attraction_natural_name_five, R.string.attraction_natural_location_five,
                R.drawable.attraction_five, R.string.attraction_natural_map_five));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.natural_color);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Attraction attraction = attractions.get(position);
                int mapId = attraction.getAttractionMapId();
                String attractionTitle = getContext().getString(mapId);
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + attractionTitle);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(getActivity(), R.string.google_error, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
}
