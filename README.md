# examenFinalMultimedia
 

Esta aplicación muestra un listado de los movimientos que pueden realizar los Pokémon en un Recycler View y permite entrar al detalle de cada uno de ellos. Utiliza la API PokeAPI, específicamente los siguientes endpoints:

- https://pokeapi.co/api/v2/move
- https://pokeapi.co/api/v2/move/1/

## Detalle de los movimientos

El detalle de los movimientos (fragment_pokemon_details.xml) se amplía con los siguientes elementos:

- Accuracy.
- Listado de texto con todos los Pokémon que pueden aprender el movimiento.

La visualización se realiza siguiendo las indicaciones de diseño proporcionadas.

## Listado de ítems y detalles de los ítems

Se crea un listado de los ítems de los juegos de Pokémon, similar al ejemplo facilitado, usando MVVM y Recycler View. Al pulsar sobre un ítem, se muestra el detalle del ítem con los siguientes campos:

- El nombre del ítem.
- La categoría del ítem.
- El coste.
- Todos los efectos del ítem (campo short_effect) en modo texto.
- La imagen (sprites default) del ítem.

La información se obtiene de las siguientes URL:

- https://pokeapi.co/api/v2/item
- https://pokeapi.co/api/v2/item/1/