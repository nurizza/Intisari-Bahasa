package id.sch.smktelkom_mlg.project2.xirpl42022242835.intisaribahasa;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl42022242835.intisaribahasa.adapter.HotelAdapter;
import id.sch.smktelkom_mlg.project2.xirpl42022242835.intisaribahasa.model.Hotel;

public class MainActivity extends AppCompatActivity implements HotelAdapter.IHotelAdapter {
    public static final String HOTEL = "hotel";

    int itemPos;

    ArrayList<Hotel> mList = new ArrayList<>();

    HotelAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HotelAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }


    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.places);

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Hotel(arJudul[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(HOTEL, mList.get(pos));
        startActivity(intent);

    }
}