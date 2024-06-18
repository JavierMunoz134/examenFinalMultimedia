package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Item;
import com.example.examenfinal.models.ItemListDetail;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

// Clase ItemsViewModel con su respectivo método para obtener la lista de objetos ItemListDetail

public class ItemsViewModel extends AndroidViewModel {
    MutableLiveData<Item> selectedItemMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<ItemListDetail>> listElementosMutableLiveData = new MutableLiveData<>();
    ItemListDetail selected;

    public ItemsViewModel(@NonNull Application application) {
        super(application);
        PokeAPI.getItemList(listElementosMutableLiveData);
    }

    MutableLiveData<List<ItemListDetail>> getAll(){
        return listElementosMutableLiveData;
    }

    public void select(ItemListDetail itemListDetails) {
        selected = itemListDetails;
    }

    public MutableLiveData<Item> getSelected() {
        PokeAPI.getItem(selected.getName(), selectedItemMutableLiveData);
        return selectedItemMutableLiveData;
    }
}