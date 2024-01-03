# Tarea 1 | Entrega Parcial 1

Lea las secciones 2.1 a 2.3 del enunciado e identifique qué elementos debieran
ser traits y cuáles clases.
Escriba además los métodos y variables que considere necesarios, junto con sus
tipos.
Anote los métodos con `def` y las variables con `var` o `val` según corresponda.

Indique de qué trait extiende cada clase.

## 1. Traits

Escriba los traits que considere necesarios para modelar el problema.


### Entity

 - val hpMax: Int
 - var hpCurrent: Int
 - val atkPoints: Int
 - val defPoints: Int
 - val evaPoints: Int 
 - def fight: Boolean *True si gana, False si pierde

 ## Panel

 - var type: String
 - var occupied: Boolean
 - var nextPanel: Boolean



## 2. Clases

Escriba las clases que considere necesarias para modelar el problema.

## Player extends Entity

- var ko: Boolean
- var stars: Int *empieza con una cantidad de estrellas cada turno
- var wins: Int
- var norm: Int *empieza partida con 1
- def normCheck: Boolean
- def throwDice: Int
- def choosePath: Int *por ej: 1 si es al frente, 2 si es izquierda, 3 si es derecha
- val: panelOwned: Int

## WildUnit extends Entity

- var disappear: Boolean
- var appear: Boolean
- var stolenStars: Int

