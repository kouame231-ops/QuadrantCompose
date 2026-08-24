# Quadrant Compose



## Description

Application Android développée avec **Jetpack Compose** et **Kotlin**, réalisée dans le cadre du cours *"Créer une mise en page"* (Chapitre 3, exercice *"S'entraîner : Principes de base de Compose"*  Quadrant Compose).

L'application divise l'écran en **4 quadrants égaux**, chacun présentant le nom et la description d'une fonction Composable fondamentale de Jetpack Compose (`Text`, `Image`, `Row`, `Column`).



## Aperçu

L'écran est divisé en 4 parties égales, chacune avec :

* Une couleur de fond différente
* Un titre en gras (nom du composable)
* Une description en texte justifié
* 

## Caractéristiques techniques respectées

|#|Élément|Caractéristique|
|-|-|-|
|1|Chaque quadrant|Padding 16dp sur les 4 côtés (début, fin, haut, bas)|
|2|Chaque quadrant|Contenu centré verticalement et horizontalement|
|3|1er `Text` de chaque quadrant|En gras (`FontWeight.Bold`), padding bottom 16dp|
|4|2e `Text` de chaque quadrant|Taille de police par défaut, alignement `Justify`|

## 

## Couleurs utilisées

|Quadrant|Contenu|Couleur|
|-|-|-|
|Haut-gauche|Text composable|`Color(0xFFEADDFF)`|
|Haut-droite|Image composable|`Color(0xFFD0BCFF)`|
|Bas-gauche|Row composable|`Color(0xFFB69DF8)`|
|Bas-droite|Column composable|`Color(0xFFF6EDFF)`|

## 

## Technologies utilisées

* **Langage** : Kotlin
* **Toolkit UI** : Jetpack Compose
* **IDE** : Android Studio
* **Composants Compose** : `Column`, `Row`, `Text`, `Scaffold`



## Structure du projet

```
app/src/main/java/com/example/quadrantcompose/
 └── MainActivity.kt        # Point d'entrée + ComposableInfoCard + QuadrantScreen

app/src/main/res/
 └── values/
      └── strings.xml        # Chaînes de texte (titres et descriptions des 4 quadrants)
```



## Concepts Compose mis en pratique

* Fonctions `@Composable` réutilisables (composant `ComposableInfoCard` utilisé 4 fois)
* Combinaison de `Column` et `Row` pour créer une grille
* Modificateur `weight()` pour répartir l'espace équitablement entre les éléments
* Couleurs personnalisées avec `Color(0x...)`
* Mise en forme du texte : `FontWeight.Bold`, `TextAlign.Justify`



## Auteur

Kouame Yao Eric

