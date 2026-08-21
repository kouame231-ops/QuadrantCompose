package com.example.quadrantcompose

// Imports nécessaires : chaque ligne "importe" une fonction ou une classe
// dont on a besoin pour construire l'interface avec Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background                 // Modificateur pour définir une couleur de fond
import androidx.compose.foundation.layout.Arrangement          // Permet de définir l'espacement/positionnement des enfants (ex : centrage)
import androidx.compose.foundation.layout.Column               // Composable pour empiler des éléments verticalement
import androidx.compose.foundation.layout.Row                  // Composable pour aligner des éléments horizontalement
import androidx.compose.foundation.layout.fillMaxSize          // Modificateur : occupe toute la taille disponible
import androidx.compose.foundation.layout.padding              // Modificateur : ajoute une marge intérieure
import androidx.compose.material3.Scaffold                     // Structure de base d'un écran Material Design
import androidx.compose.material3.Text                         // Composable pour afficher du texte
import androidx.compose.runtime.Composable                     // Annotation qui déclare une fonction "Composable"
import androidx.compose.ui.Alignment                           // Permet d'aligner un élément horizontalement/verticalement
import androidx.compose.ui.Modifier                            // Type utilisé pour personnaliser l'apparence des composables
import androidx.compose.ui.graphics.Color                      // Permet de définir des couleurs personnalisées
import androidx.compose.ui.res.stringResource                  // Charge un texte depuis le fichier strings.xml
import androidx.compose.ui.text.font.FontWeight                // Permet de définir l'épaisseur de la police (ex : gras)
import androidx.compose.ui.text.style.TextAlign                // Définit l'alignement du texte (gauche, centre, justifié...)
import androidx.compose.ui.tooling.preview.Preview              // Annotation pour afficher un aperçu dans Android Studio
import androidx.compose.ui.unit.dp                             // Unité de mesure pour les tailles/marges (density-independent pixels)
import com.example.quadrantcompose.ui.theme.QuadrantComposeTheme // Thème visuel généré automatiquement pour l'application

// Point d'entrée de l'application : c'est la première classe exécutée au lancement
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Permet à l'app de s'afficher derrière la barre de statut (plein écran)

        // setContent définit le contenu de l'écran en utilisant Jetpack Compose
        setContent {
            // Applique le thème visuel de l'application (couleurs, typographie...)
            QuadrantComposeTheme {
                // Scaffold fournit une structure d'écran standard Material Design
                // innerPadding correspond aux marges automatiques (ex : barre de statut)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Affiche notre écran personnalisé, en lui passant le padding automatique
                    QuadrantScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Fonction Composable réutilisable qui représente UNE carte d'information (un quadrant)
// On la réutilise 4 fois avec des contenus et des couleurs différents
@Composable
fun ComposableInfoCard(
    title: String,          // Le titre affiché en gras (ex : "Text composable")
    description: String,    // La description sous le titre
    backgroundColor: Color, // La couleur de fond propre à ce quadrant
    modifier: Modifier = Modifier
) {
    // Column empile le titre et la description verticalement, à l'intérieur du quadrant
    Column(
        modifier = modifier
            .fillMaxSize()                 // Le quadrant occupe tout l'espace qui lui est attribué
            .background(backgroundColor)   // Applique la couleur de fond du quadrant
            .padding(16.dp),                // Marge intérieure de 16dp sur les 4 côtés
        verticalArrangement = Arrangement.Center,          // Centre le contenu verticalement
        horizontalAlignment = Alignment.CenterHorizontally // Centre le contenu horizontalement
    ) {
        // Titre du quadrant, en gras
        Text(
            text = title,
            fontWeight = FontWeight.Bold,               // Texte en gras, comme demandé par l'exercice
            modifier = Modifier.padding(bottom = 16.dp) // Marge de 16dp sous le titre
        )
        // Description du quadrant, texte justifié
        Text(
            text = description,
            textAlign = TextAlign.Justify // Texte aligné des deux côtés (justifié)
        )
    }
}

// Fonction Composable principale : assemble les 4 quadrants en une grille 2x2
@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
    // Column principale : empile 2 lignes (Row) l'une en dessous de l'autre
    Column(modifier = modifier.fillMaxSize()) {

        // --- Ligne du HAUT ---
        // weight(1f) fait que cette Row occupe la moitié de la hauteur de l'écran
        Row(modifier = Modifier.weight(1f)) {
            // Quadrant 1 (haut-gauche) : Text composable
            ComposableInfoCard(
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.text_composable_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f) // Occupe la moitié de la largeur de la Row
            )
            // Quadrant 2 (haut-droite) : Image composable
            ComposableInfoCard(
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.image_composable_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

        // --- Ligne du BAS ---
        Row(modifier = Modifier.weight(1f)) {
            // Quadrant 3 (bas-gauche) : Row composable
            ComposableInfoCard(
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.row_composable_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            // Quadrant 4 (bas-droite) : Column composable
            ComposableInfoCard(
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.column_composable_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// Aperçu (Preview) : permet de voir le résultat dans Android Studio
// sans avoir besoin de lancer l'application sur un téléphone émulateur
@Preview(showBackground = true)
@Composable
fun QuadrantScreenPreview() {
    QuadrantComposeTheme {
        QuadrantScreen()
    }
}