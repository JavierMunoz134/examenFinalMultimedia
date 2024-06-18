package com.example.examenfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.examenfinal.databinding.FragmentMoveListRecyclerBinding;
import com.example.examenfinal.databinding.ViewholderMoveListBinding;

import com.example.examenfinal.models.MoveListItem;

import java.util.List;

// Clase MoveListRecyclerFragment con su respectivo método para obtener la lista de objetos MoveListItem

public class MoveListRecyclerFragment extends Fragment {
    private FragmentMoveListRecyclerBinding binding;
    private MovesViewModel movesViewModel;
    private NavController navController;

    // Se llama para que el fragmento instancie su vista y la muestre en pantalla
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMoveListRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    // Se llama cuando la vista del fragmento es creada para que el fragmento instancie su vista
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movesViewModel = new ViewModelProvider(requireActivity()).get(MovesViewModel.class);
        navController = Navigation.findNavController(view);
        MovesAdapter movesAdapter = new MovesAdapter();
        binding.recyclerView.setAdapter(movesAdapter);

        // Cuando cambia el viewmodel se actualiza la lista con setList(List<MoveListItem> moveList)
        movesViewModel.getAll().observe(getViewLifecycleOwner(), movesAdapter::setList);
    }

    // Clase MovesAdapter con su respectivo método onCreateViewHolder y onBindViewHolder para inflar la vista y mostrar los elementos en el RecyclerView
    class MovesAdapter extends RecyclerView.Adapter<MoveViewHolder> {
        List<MoveListItem> moveList;

        @NonNull
        @Override
        public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MoveViewHolder(ViewholderMoveListBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {
            MoveListItem element = moveList.get(position);
            holder.binding.setMove(element);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movesViewModel.select(element);
                    navController.navigate(R.id.action_moveListRecyclerFragment_to_moveDetailFragment);
                }
            });
        }

        // Método getItemCount para obtener el número de elementos en la lista
        @Override
        public int getItemCount() {
            return moveList != null ? moveList.size() : 0;
        }

        public void setList(List<MoveListItem> moveList){
            this.moveList = moveList;
            notifyDataSetChanged();
        }
    }
    // Clase MoveViewHolder con su respectivo atributo y constructor para obtener la vista de los elementos del RecyclerView
    static class MoveViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderMoveListBinding binding;

        public MoveViewHolder(ViewholderMoveListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}