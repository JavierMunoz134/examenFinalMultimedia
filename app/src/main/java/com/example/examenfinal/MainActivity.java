package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.examenfinal.databinding.FragmentDrawerBinding;
import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private FragmentDrawerBinding binding;
    // Se llama cuando la actividad es creada para que la actividad instancie su vista y la muestre en pantalla
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MutableLiveData<List<MoveListItem>> moveList = new MutableLiveData<>();
        PokeAPI.getMoveList(moveList);

        setContentView((binding = FragmentDrawerBinding.inflate(getLayoutInflater())).getRoot());
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.moveListRecyclerFragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        // Se llama para configurar la barra de herramientas y el NavigationView

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        binding.toolbar.setTitle("Pokedex");
    }
}