package com.example.eventtix;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<EventModel> eventModels= new ArrayList<>();
    int[] eventImages = {R.drawable.untold, R.drawable.tiff, R.drawable.ec, R.drawable.uclujcfr, R.drawable.wine, R.drawable.traviata, R.drawable.sport, R.drawable.zileleclujului};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.events);
        setUpEventModels();
        EventAdapter adapter = new EventAdapter(this, eventModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setUpEventModels(){
        String[] eventNameModels = getResources().getStringArray(R.array.event_model_full_txt);
        String[] eventVenueModels = getResources().getStringArray(R.array.event_model_venue_txt);
        String[] eventTypeModels = getResources().getStringArray(R.array.event_model_eventType_txt);
        for(int i=0; i < eventNameModels.length;i++)
        {
            eventModels.add(new EventModel(eventNameModels[i], eventVenueModels[i], eventTypeModels[i], eventImages[i]));
        }
    }
}
