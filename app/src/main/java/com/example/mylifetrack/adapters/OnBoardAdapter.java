package com.example.mylifetrack.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylifetrack.databinding.ItemBoardBinding;
import com.example.mylifetrack.interfaces.OnItemClick;
import com.example.mylifetrack.models.OnBoardModal;

import java.util.ArrayList;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.BoardViewHolder> {
    ArrayList<OnBoardModal> list;
    OnItemClick onItemClick;
    public OnBoardAdapter(ArrayList<OnBoardModal> list, OnItemClick listener) {
        this.list = list;
        this.onItemClick = listener;
    }

    @NonNull
    @Override
    public OnBoardAdapter.BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBoardBinding binding =
                ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BoardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardAdapter.BoardViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        ItemBoardBinding binding;

        public BoardViewHolder(@NonNull ItemBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(OnBoardModal onBoardModal) {
            binding.animation.setAnimation(onBoardModal.getAnimation());
            binding.tvText.setText(onBoardModal.getText());
            binding.btnNext.setText(onBoardModal.getButtonText());

            binding.btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    onItemClick.itemClick(getAdapterPosition());
                }

            });


        }
    }
}
