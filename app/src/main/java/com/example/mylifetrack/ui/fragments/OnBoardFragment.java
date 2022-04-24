package com.example.mylifetrack.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mylifetrack.R;
import com.example.mylifetrack.adapters.OnBoardAdapter;
import com.example.mylifetrack.databinding.FragmentOnBoardBinding;
import com.example.mylifetrack.interfaces.OnItemClick;
import com.example.mylifetrack.models.OnBoardModal;

import java.util.ArrayList;

public class OnBoardFragment extends Fragment implements OnItemClick {
    FragmentOnBoardBinding binding;
    OnBoardAdapter adapter;
    ArrayList<OnBoardModal> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();

    }


    private ArrayList<OnBoardModal> getBoardList() {
        ArrayList<OnBoardModal> list = new ArrayList<>();
        list.add(new OnBoardModal(R.raw.task_anim, "Экономь время", "Дальше"));
        list.add(new OnBoardModal(R.raw.it_anim, "Достигай целей", "Дальше"));
        list.add(new OnBoardModal(R.raw.network_anim, "Развивайся", "Начинаем"));
        return list;
    }

    private void initAdapter() {
        list = getBoardList();
        adapter = new OnBoardAdapter(list, this);
        binding.pager.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.pager);

    }


    @Override
    public void itemClick(int position) {
        if (position == 0 || position == 1) {
            binding.pager.setCurrentItem(binding.pager.getCurrentItem() + 1);
        } else {
            Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        list.clear();
    }
}
