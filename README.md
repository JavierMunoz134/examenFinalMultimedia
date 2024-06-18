# examenFinalMultimedia
 
## Descripción

La aplicación Pokémon Base App es una herramienta interactiva que permite a los usuarios explorar los movimientos y los ítems de los juegos de Pokémon. Utiliza la API de PokeAPI para obtener y mostrar la información relevante.

## Características

### Detalle de los movimientos

La aplicación muestra un listado de los movimientos que pueden realizar los Pokémon en un Recycler View. Al seleccionar un movimiento, los usuarios pueden ver detalles adicionales, incluyendo:

- Accuracy: La precisión del movimiento.
- Pokémon: Un listado de todos los Pokémon que pueden aprender el movimiento.

La interfaz de usuario sigue un diseño específico, con un layout de Constraint Layout y una distribución vertical uniforme de los elementos.

### Listado de ítems y detalles de los ítems

La aplicación también proporciona un listado de los ítems disponibles en los juegos de Pokémon. Este listado se implementa utilizando el patrón de diseño MVVM y un Recycler View. Al seleccionar un ítem, los usuarios pueden ver detalles adicionales, incluyendo:

- Nombre: El nombre del ítem.
- Categoría: La categoría del ítem.
- Coste: El coste del ítem.
- Efectos: Todos los efectos del ítem (campo short_effect) en modo texto.
- Imagen: La imagen (sprites default) del ítem.

## Recursos de la API

La aplicación utiliza los siguientes endpoints de la API de PokeAPI para obtener la información necesaria:

- Movimientos: https://pokeapi.co/api/v2/move
- Detalles del movimiento: https://pokeapi.co/api/v2/move/1/
- Ítems: https://pokeapi.co/api/v2/item
- Detalles del ítem: https://pokeapi.co/api/v2/item/1/
