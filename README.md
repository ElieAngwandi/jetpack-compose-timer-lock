<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/b02320e0-7c7e-4532-bd0b-36de624e2224" />
# Projet de Test

Il s'agit d'une application Android développée avec **Jetpack Compose**, qui démontre l'utilisation de **SharedPreferences** pour le stockage local de données et le rendu conditionnel de l'interface utilisateur basé sur le temps.

## Fonctionnalités

*   **Premier lancement** : Enregistre la date et l’heure actuelles dans SharedPreferences.
*   **Lancements suivants** :
    *   Si l’application est relancée **dans l’heure** suivant le premier lancement, un écran de bienvenue est affiché.
    *   Si elle est relancée **plus d’une heure plus tard**, un écran de mise à jour obligatoire est affiché, bloquant l’accès au contenu principal de l’application.
*   **Fonctionnement hors ligne** : L’application fonctionne entièrement hors connexion, en s’appuyant uniquement sur les SharedPreferences locales.
*   **Interface utilisateur** :
    *   Un écran de bienvenue simple.
    *   Un écran de mise à jour bloquant avec un message et un bouton (actuellement fictif) "Mettre à jour".

## Détails techniques

*   **Framework UI** : Jetpack Compose  
*   **Stockage local** : SharedPreferences  
*   **Langage** : Kotlin  

## Comment exécuter l’application

1.  Cloner le dépôt.
2.  Ouvrir le projet dans **Android Studio**.
3.  Compiler et lancer l’application sur un émulateur ou un appareil physique.

## Démonstration du comportement

1.  **Premier lancement** : Notez l’heure. Vous devriez voir l’écran de bienvenue.
2.  **Relance dans l’heure** : Fermez et rouvrez l’application. Vous verrez toujours l’écran de bienvenue.
3.  **Relance après 1 heure** :
    *   Pour simuler cela, vous pouvez soit attendre une heure, soit **modifier manuellement l’heure de l’appareil** (pour qu’elle avance d’au moins une heure).
    *   Autre option : **désinstaller puis réinstaller l’application**, puis modifier manuellement la date stockée dans SharedPreferences (cela nécessite des outils de débogage ou de modifier le code pour exposer cette fonctionnalité).
    *   Au redémarrage, vous verrez l’écran "Mise à jour requise".

## Structure du projet

*   `app/src/main/java/cd/youngtechdrc/testproject/MainActivity.kt` : Contient la logique principale pour la gestion de SharedPreferences, la vérification de la différence de temps, et l’affichage de l’UI appropriée.
