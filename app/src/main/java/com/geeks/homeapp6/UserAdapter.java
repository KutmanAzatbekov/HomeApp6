package com.geeks.homeapp6;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.homeapp6.databinding.ItemUserHolderBinding;

import java.util.ArrayList;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemUserViewHolder> {


    public  static interface OnUserClickListener{ void onUserClick(User user, int position);}

    private ArrayList<User> users;

    private OnUserClickListener listener;

    private int selectedPosition = RecyclerView.NO_POSITION;


   public UserAdapter(ArrayList<User> users, OnUserClickListener listener){
       this.users = users;
       this.listener = listener;
   }
    @NonNull
    @Override
    public ItemUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserHolderBinding binding = ItemUserHolderBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ItemUserViewHolder holder = new ItemUserViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemUserViewHolder holder, @SuppressLint("RecyclerView") int position) {
        User user = users.get(position);
        holder.bind(user);
        if (user.isSelected2()){
            holder.binding.getRoot().setBackgroundResource(R.drawable.selected_item_user);
        } else {
            holder.binding.getRoot().setBackgroundResource(R.drawable.default_item_user);
        }

        holder.binding.getRoot().setOnClickListener(v -> {
            if (selectedPosition != RecyclerView.NO_POSITION){
                users.get(selectedPosition).setSelected2(false);
                notifyItemChanged(selectedPosition);
            }
            selectedPosition = position;
            user.setSelected2(true);
            notifyItemChanged(selectedPosition);
            listener.onUserClick(user, position);
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ItemUserViewHolder extends RecyclerView.ViewHolder {

        private ItemUserHolderBinding binding;

        public ItemUserViewHolder(ItemUserHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(User user){
            binding.tvModel.setText(user.getModel());
            binding.tvYear.setText(user.getPrice().toString());
            Glide.with(super.itemView).load(user.getAvatarUrl())
                    .centerCrop()
                    .into(binding.ivAvatar);
        }
    }
}
