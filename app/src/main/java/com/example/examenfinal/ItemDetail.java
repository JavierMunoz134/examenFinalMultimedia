package com.example.examenfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.examenfinal.databinding.FragmentItemDetailBinding;

public class ItemDetail extends Fragment {

    private FragmentItemDetailBinding binding;
    private ItemsViewModel itemsViewModel;
    // Se llama cuando el fragmento es creado para que el fragmento instancie su vista
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsViewModel = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
    }
    // Se llama cuando la vista del fragmento es creada para que el fragmento instancie su vista
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemsViewModel.getSelected().observe(getViewLifecycleOwner(), obj -> binding.setItem(obj));
    }
    // Se llama para que el fragmento instancie su vista y la muestre en pantalla
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentItemDetailBinding.inflate(inflater, container, false)).getRoot();
    }
}