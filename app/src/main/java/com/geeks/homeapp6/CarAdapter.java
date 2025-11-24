package com.geeks.homeapp6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.homeapp6.databinding.ItemCarHolderBinding;
import com.geeks.homeapp6.databinding.ItemUserHolderBinding;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ItemCarViewHolder> {

    private ArrayList<Car> cars;

    public CarAdapter(ArrayList<Car> cars){
        this.cars = cars;
    }

    @NonNull
    @Override
    public ItemCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCarHolderBinding binding = ItemCarHolderBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ItemCarViewHolder holder = new ItemCarViewHolder(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCarViewHolder holder, int position) {
        holder.bind2(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ItemCarViewHolder extends RecyclerView.ViewHolder {

        private ItemCarHolderBinding binding;

        public  ItemCarViewHolder(ItemCarHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind2(Car car){
            binding.tvName.setText(car.getName());
            Glide.with(super.itemView).load(car.getAvatar())
                    .centerCrop()
                    .into(binding.AvatarNew);
        }
    }
}
