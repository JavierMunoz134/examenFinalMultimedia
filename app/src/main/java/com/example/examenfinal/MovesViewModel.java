package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;
// Clase MovesViewModel con su respectivo método para obtener la lista de objetos MoveListItem

public class MovesViewModel extends AndroidViewModel {
    MutableLiveData<Move> selectedMoveMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<MoveListItem>> listElementosMutableLiveData = new MutableLiveData<>();
    MoveListItem selected;

    // Método para obtener la lista de objetos MoveListItem
    public MovesViewModel(@NonNull Application application) {
        super(application);
        PokeAPI.getMoveList(listElementosMutableLiveData);
    }

    // Método para obtener la lista de objetos MoveListItem
    MutableLiveData<List<MoveListItem>> getAll(){
        return listElementosMutableLiveData;
    }

    //  Método para seleccionar un objeto MoveListItem
    public void select(MoveListItem moveListItem) {
        selected = moveListItem;
    }

    // Método para obtener un objeto Move por su nombre
    public MutableLiveData<Move> getSelected() {
        PokeAPI.getMove(selected.getName(), selectedMoveMutableLiveData);
        return selectedMoveMutableLiveData;
    }
}
