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

    public  static interface OnCarClickListener{ void onCarClick(Car car, int position);}


    private OnCarClickListener listener;

    private int selectedPosition = RecyclerView.NO_POSITION;

    private ArrayList<Car> cars;

   public CarAdapter(ArrayList<Car> cars, OnCarClickListener listener){
       this.cars = cars;
       this.listener = listener;
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
        Car car = cars.get(position);
        holder.bind2(car);
        if (car.isSelected()){
            holder.binding.getRoot().setBackgroundResource(R.drawable.selected_item_backround);
        } else {
            holder.binding.getRoot().setBackgroundResource(R.drawable.default_item_backround);
        }

        holder.binding.getRoot().setOnClickListener(v -> {
            if (selectedPosition != RecyclerView.NO_POSITION){
                cars.get(selectedPosition).setSelected(false);
                notifyItemChanged(selectedPosition);
            }
            selectedPosition = position;
            car.setSelected(true);
            notifyItemChanged(selectedPosition);
            listener.onCarClick(car, position);
        });
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
