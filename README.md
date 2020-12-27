# Application Android : Galaxies les plus connues (présentation via un compte utilisateur) 
Cette application permet à un utilisateur de créer un compte et de s'identifier pour accéder à la présentation des galaxies.

---
## L'application possède les fonctionnalités suivantes :
* affichage d'écran de login lors du démarage

<img src="https://github.com/Rroguet/Android4A/blob/master/screen/Login.PNG" width="200">

* création d'un nouveau compte si l'utilisateur n'en possède pas (les comptes sont stockés dans une base de données sur le téléphone)

<img src="https://github.com/Rroguet/Android4A/blob/master/screen/Creation_compte.PNG" width="200">

* affichage d'un avis de creation de compte ou d'un message d'erreur après identification de l'utilisateur

<img src="https://github.com/Rroguet/Android4A/blob/master/screen/Exemple_erreur.PNG" width="200">

* liste de sélection des galaxies

<img src="https://github.com/Rroguet/Android4A/blob/master/screen/Liste.PNG" width="200">

* détail de la galaxie sélectionnée dans la liste (un bouton permet de revenir à la liste) 

<img src="https://github.com/Rroguet/Android4A/blob/master/screen/Description.PNG" width="200">

## L'application utilise une API pour accéder aux données :
* appel d'une api rest située dans le répertoire git (api créée à partir des informations trouvées sur wikipedia)

[Lien vers l'api](https://github.com/Rroguet/Android4A/blob/master/galaxies.json)

## Autres informations
* le design en adéquation avec les galaxies est réalisé sur android 
* l'application est développée en Kotlin
* elle respecte les principes d'architecture MVVM, Clean Architecture et utilise des Singletons
* des tests unitaires sont présent sur le package usecase
