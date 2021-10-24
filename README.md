# TP Maven-JUnit

Pour cet exercice, on veut implémenter une classe immuable Fraction qui représente un nombre rationnel.
Un exemple d’interface pour une telle classe est donné par la classe [`Fraction`](https://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/fraction/Fraction.html) de la bibliothèque [Apache Commons Math](https://commons.apache.org/proper/commons-math/).

La classe fournira l’interface suivante :
*   initialisation avec (i) un numérateur et un dénominateur, (ii) juste avec le numérateur (dénominateur égal à 1) ou (iii) sans argument (numérateur égal 0 et dénominateur égal à 1),
*   conversion en chaîne de caractères ([`toString`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#toString())),
*   les constantes ZERO (0, 1) et UN (1, 1),
*   consultation du numérateur et du dénominateur,
*   consultation de la valeur sous la forme d’un nombre en virgule flottante (double) (`toDouble`),
*   addition de deux fractions (`add`),
*   test d’égalité entre fractions (deux fractions sont égales si elles représentent la même fraction réduite) ([`equals`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)) et [`hashCode`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#hashCode())),
*   comparaison de fractions selon l’ordre naturel ([`compareTo`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html)).

De plus, le projet sera géré avec [Maven](https://maven.apache.org/) et vous utiliserez une approche pilotée par les tests pour la réalisation, i.e. écrivez toujours un test avant le code et pensez au refactoring.
Le framework de tests devra être [JUnit 4](https://junit.org/junit4/) (ou [5](https://junit.org/junit5/) si vous préférez).
Vous rédigerez votre code source en respectant les [conventions de codage](https://google.github.io/styleguide/javaguide.html) proposées par _Google_.
Enfin, la prise en compte des contraintes se fera par de la gestion d’erreurs et des exceptions.


Il pourra éventuellement être nécessaire de [configurer le proxy](http://maven.apache.org/guides/mini/guide-proxies.html) (http://wwwcache.uvsq.fr:3128) pour accéder au dépôt Maven.

À chaque étape, validez vos modifications avec `git` et si nécessaire, exécutez le cycle maven adapté pour vérifier vos manipulations.: 4.0.0
1.  Quelles conventions utilise Maven pour l’arborescence des répertoires ?
    l'arborescence d'un projet Maven est par défaut imposée par Maven
    le fichier pom.xml c'est e fichier POM de description du projet
    Où se trouvent les sources de l'application et les sources des tests ?
1.  Examinez le projet Maven ainsi que le fichier de description et répondez aux questions suivantes :
    1.  Dans quel répertoire se trouvent les fichiers sources du projet ? Les sources des tests ?
        > les fichiers source du projet trouve dans: src/Main/java
        > les fichiers source du test se trouve dans: src/test/java
    1. Quelles sont les coordonnées du projet ?
        > modelVersion 4.0.0
    1. À quoi sert la propriété `project.build.sourceEncoding` ?
        > sert a Choisis l'enconding avec lequel tu veux compiler dans notre cas c'est 'UTF-8'
    1. Quelles versions des sources et de la JVM sont utilisés ?
        > la version 1.7
    1. Quelle version de JUnit est configurée ? À quoi sert la balise `scope` ?
        > La version JUnit : 4.11,L' <scope>élément peut prendre 6 valeurs: compiler , fourni , runtime , test , système et import .
Cette étendue est utilisée pour limiter la transitivité d'une dépendance et également pour affecter le chemin de classe utilisé pour diverses tâches de génération.
    1. À quoi sert la section `pluginManagement` ?
        > plugin Management contient des éléments de plug-in de la même manière, sauf que plutôt que de configurer les informations de plug-in pour cette version de projet particulière, il est destiné à configurer des versions de projet héritant de celle-ci. Cependant, cela ne configure que les plugins qui sont réellement référencés dans l'élément plugins des enfants. Les enfants ont le droit de remplacer les définitions de pluginManagement.

1.  Modifiez la configuration du projet de la façon suivante :
    1.  fixez la version des sources et des .class pour utiliser la version 11 de Java
    1.  utilisez la dernière version stable de JUnit 4 (cf. [MVNRepository](https://mvnrepository.com/))
1.  Ajoutez un fichier `.gitignore` adapté aux projets Maven (cf. [A collection of .gitignore templates](https://github.com/github/gitignore)) et ajoutez-y les fichiers et répertoires de votre IDE.
1.  Quelle commande Maven permet de :
    1.  créer un `jar` du projet ?
        > mvn clean compile Assembly:single
    1. lancer les tests ?
        > mvn test
    1. supprimer tous les fichiers issus de la compilation ?
        > maven clean
1.  Ajoutez une classe `Fraction` et une classe `FractionTest` dans les répertoires et packages appropriés.
    Supprimez les classes d'exemple `App` et `AppTest`.
1.  Énumérez une liste de cas de tests à réaliser en n'oubliant pas les cas d'erreur.
    > assertTrue( true ); assertEquals(obj.getNum(),5); assertNotNull(obj); assertNull(null); assertNotSame(obj, obj1); assertSame(obj, obj1);
1.  Pour chaque cas de test,
    1. écrivez le test JUnit correspondant dans la classe de test,
    1. vérifiez qu’il échoue,
    1. implémentez la fonctionnalité dans la classe,
    1. vérifiez que le test passe,
    1. appliquez un étape de refactoring sur les tests et la classe si nécessaire.
1.  Modifiez le POM pour intégrer la vérification des conventions de codage avec [`checkstyle`](http://maven.apache.org/plugins/maven-checkstyle-plugin/) en utilisant les conventions _Google_.
1.  Ajoutez une méthode `main` qui démontre quelques fonctionnalités de la classe, puis modifiez le POM pour que le jar généré soit exécutable (cf. [Apache Maven JAR Plugin](https://maven.apache.org/plugins/maven-jar-plugin/index.html))
1.  Modifiez la méthode `main` pour que les différents affichages se fassent à l'aide de la bibliothèque de logging [`SLF4J`](http://www.slf4j.org/)
1. En utilisant le plugin [assembly](https://maven.apache.org/plugins/maven-assembly-plugin/) (ou le plugin [shade](https://maven.apache.org/plugins/maven-shade-plugin/)), générez une archive du projet contenant ses dépendances (uber-jar)
