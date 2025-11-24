package com.geeks.homeapp6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.homeapp6.databinding.ItemUserHolderBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemUserViewHolder> {

    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
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
    public void onBindViewHolder(@NonNull ItemUserViewHolder holder, int position) {
        holder.bind(users.get(position));
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
