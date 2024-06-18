package com.example.examenfinal.pokeapi;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Item;
import com.example.examenfinal.models.ItemList;
import com.example.examenfinal.models.ItemListDetail;
import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.MoveList;
import com.example.examenfinal.models.MoveListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Clase PokeAPI con sus respectivos métodos para obtener la lista de movimientos y objetos
public class PokeAPI {

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static final PokeAPIService service = retrofit.create(PokeAPIService.class);

    public static void getMoveList(MutableLiveData<List<MoveListItem>> moveList){
        Call<MoveList> pokeCall = service.getMoveList(844, 0);
        pokeCall.enqueue(new Callback<MoveList>() {
            @Override
            public void onResponse(@NonNull Call<MoveList> call, @NonNull Response<MoveList> response) {
                if (response.isSuccessful()) {
                    MoveList list = response.body();
                    if (list != null) {
                        moveList.setValue(list.getResults());
                    }

                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }
            // Método para obtener la lista de movimientos
            @Override
            public void onFailure(@NonNull Call<MoveList> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }

    // Método para obtener un movimiento por su nombre

    public static void getMove(String name, MutableLiveData<Move> move) {
        Call<Move> pokeCall = service.getMoveById(name);
        pokeCall.enqueue(new Callback<Move>() {
            @Override
            public void onResponse(@NonNull Call<Move> call, @NonNull Response<Move> response) {
                if (response.isSuccessful()) {
                    Move p = response.body();
                    if (p != null) {
                        move.setValue(p);
                    }
                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Move> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }

    // Método para obtener la lista de objetos

    public static void getItemList(MutableLiveData<List<ItemListDetail>> listItems) {
        Call<ItemList> pokeCall = service.getItemList(844, 0);
        pokeCall.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(@NonNull Call<ItemList> call, @NonNull Response<ItemList> response) {
                if (response.isSuccessful()) {
                    ItemList list = response.body();
                    if (list != null) {
                        listItems.setValue(list.getResults());
                    }

                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ItemList> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }

    // Método para obtener un objeto por su nombre

    public static void getItem(String name, MutableLiveData<Item> item) {
        Call<Item> pokeCall = service.getItemByName(name);
        pokeCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(@NonNull Call<Item> call, @NonNull Response<Item> response) {
                if (response.isSuccessful()) {
                    Item obj = response.body();
                    if (obj != null) {
                        item.setValue(obj);
                    }
                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

         // Método para obtener un objeto por su nombre

            @Override
            public void onFailure(@NonNull Call<Item> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }
}