package com.example.examenfinal.pokeapi;

import com.example.examenfinal.models.Item;
import com.example.examenfinal.models.ItemList;
import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.MoveList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PokeAPIService {
    String BASE_URL = "https://pokeapi.co/api/v2/";

    // Método para obtener un movimiento por su nombre
    @GET("move/{name}")
    Call<Move> getMoveById(@Path("name") String id);

    // Método para obtener la lista de movimientos
    @GET("move")
    Call<MoveList> getMoveList(@Query("limit") int limit, @Query("offset") int offset);



    // Método para obtener un objeto por su nombre
    @GET("item")
    Call<ItemList> getItemList(@Query("limit") int limit, @Query("offset") int offset);

    // Método para obtener un objeto por su nombre
    @GET("item/{name}")
    Call<Item> getItemByName(@Path("name") String name);
}