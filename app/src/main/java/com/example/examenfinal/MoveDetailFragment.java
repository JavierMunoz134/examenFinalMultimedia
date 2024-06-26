package com.example.examenfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenfinal.databinding.FragmentMoveDetailBinding;
import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.PokemonListItem;


public class MoveDetailFragment extends Fragment {

    private FragmentMoveDetailBinding binding;
    MovesViewModel movesViewModel;

    // Se llama cuando el fragmento es creado para que el fragmento instancie su vista
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movesViewModel = new ViewModelProvider(requireActivity()).get(MovesViewModel.class);
    }
    // Se llama para que el fragmento instancie su vista y la muestre en pantalla
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movesViewModel.getSelected().observe(getViewLifecycleOwner(), m -> binding.setMove(m));
    }
    // Se llama para que el fragmento instancie su vista y la muestre en pantalla
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMoveDetailBinding.inflate(inflater, container, false)).getRoot();

    }

}