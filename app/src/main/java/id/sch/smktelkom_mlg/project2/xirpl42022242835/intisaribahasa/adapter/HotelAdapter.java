package id.sch.smktelkom_mlg.project2.xirpl42022242835.intisaribahasa.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl42022242835.intisaribahasa.R;
import id.sch.smktelkom_mlg.project2.xirpl42022242835.intisaribahasa.model.Hotel;

/**
 * Created by Izza on 21/03/2017.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>{

    IHotelAdapter mIHotelAdapter;
    ArrayList<Hotel> hotelList;
    public HotelAdapter(Context context, ArrayList<Hotel> hotelList){
        this.hotelList = hotelList;
        mIHotelAdapter = (IHotelAdapter) context;
    }
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(HotelAdapter.ViewHolder holder, int position) {
    Hotel hotel = hotelList.get(position);
        holder.tvJudul.setText(hotel.judul);
    }

    @Override
    public int getItemCount() {
        if(hotelList!=null)
            return hotelList.size();
        return 0;
    }
    public interface IHotelAdapter{
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul;

        public ViewHolder(View itemView)
        {
            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doClick(getAdapterPosition());
                }
            });
        }


            }

    }


