package com.example.examenfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.databinding.FragmentItemListRecyclerBinding;
import com.example.examenfinal.databinding.ViewholderItemListBinding;
import com.example.examenfinal.models.ItemListDetail;

import java.util.List;

public class ItemListRecyclerFragment extends Fragment {
    private FragmentItemListRecyclerBinding binding;
    private ItemsViewModel itemsViewModel;
    private NavController navController;

    // Se llama para que el fragmento instancie su vista y la muestre en pantalla
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentItemListRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    // Se llama cuando la vista del fragmento es creada para que el fragmento instancie su vista
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemsViewModel = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
        navController = Navigation.findNavController(view);
        ItemAdapter itemAdapter = new ItemAdapter();
        binding.itemRecyclerView.setAdapter(itemAdapter);

        // Se llama para obtener la lista de objetos ItemListDetail y mostrarlos en el RecyclerView
        itemsViewModel.getAll().observe(getViewLifecycleOwner(), itemAdapter::setList);
    }

    // Clase ItemAdapter con su respectivo método onCreateViewHolder y onBindViewHolder para inflar la vista y mostrar los elementos en el RecyclerView
    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        List<ItemListDetail> itemsList;

        // Método para inflar la vista de los elementos del RecyclerView
        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(ViewholderItemListBinding.inflate(getLayoutInflater(), parent, false));
        }
        // Método para mostrar los elementos en el RecyclerView
        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            ItemListDetail element = itemsList.get(position);
            holder.binding.setItem(element);
            holder.itemView.setOnClickListener(v -> {
                itemsViewModel.select(element);
                navController.navigate(R.id.action_itemListRecyclerFragment_to_itemsDetailsFragment);
            });
        }

        // Método para obtener la cantidad de elementos en la lista
        @Override
        public int getItemCount() {
            return itemsList != null ? itemsList.size() : 0;
        }

        // Método para obtener la lista de objetos ItemListDetail
        public void setList(List<ItemListDetail> itemList){
            this.itemsList = itemList;
            notifyDataSetChanged();
        }
    }
    // Clase ItemViewHolder con su respectivo atributo y constructor para obtener la vista de los elementos del RecyclerView
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderItemListBinding binding;

        // Constructor de la clase ItemViewHolder
        public ItemViewHolder(ViewholderItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}