package com.example.examenfinal.databinding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DataBinding {

    // Cargar imagen con Glide para el ImageView de la paleta de colores

    @BindingAdapter("paletteImage")
    public static void bindLoadImagePalette(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}