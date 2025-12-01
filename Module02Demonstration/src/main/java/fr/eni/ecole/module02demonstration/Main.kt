package fr.eni.ecole.module02demonstration

import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


fun main() {
    var firstName : String? = "Bob";

    firstName = "Ziggy";

    val lastName : String = "Marley";

    println("Hello $firstName $lastName");

    firstName = null;

    println("Hello $firstName");

    val a = 4;
    val b = 6;

    println("Le résultat de la somme a avec b est ${a + b}.");

    val color = "vert"
    println(color == "vert");

    val message = if(color == "vert") "Le t-shirt est vert" else "Le t-shirt n'est pas vert";
    println(message);

    val idCoffee = 4;

    when(idCoffee) {
        1 -> println("Expresso");
        2 -> println("Americano");
        3 -> println("Latte");
        4 -> println("Pumpkin Chaï Latte");
        else -> println("Pas de café")
    }

    val fruits = arrayOf("Poire", "Pomme", "Cerise", "Fraise");

    for (fruit in fruits) {
        println("J'aime la $fruit");
    }

    for ((index, fruit) in fruits.withIndex()) {
        println("Le fruit $fruit a l'indice $index");
    }


    var index = 0
    while (index < 4) {
        println("On affiche l'indice $index");
        index++;
    }

    do {
        println("On aime le fruit avec l'indice $index");
        index++;
    } while (index < 10)


    // Fonction d'extension
    fun LocalDateTime.showDateTimeInFrench(): String {
        //Création format conversion de date pour affichage
        val formatter = DateTimeFormatter.ofPattern("le d MMMM 'à HH'h'mm", Locale.FRENCH)

        // Formatage du LocalDateTime avec le format donné
        return this.format(formatter)
    }

    // Fonction générique

    //Fonction générique
    fun <T> concatenate(list: List<T>, separator: String = ", "): String {
        val stringBuilder = StringBuilder()
        for ((index, item) in list.withIndex()) {
            //Si ce n'est pas le premier élément, ajouter le séparateur
            if (index > 0) stringBuilder.append(separator)
                stringBuilder.append(item)
        }
        return stringBuilder.toString()
    }

    var vegetables = listOf<String>("Carottes", "Poireaux", "Aubergines", "Pommes de terre")
    var allVegetables = concatenate(vegetables);
    println(allVegetables);

    val userName: String? = null
    //retourner username ou, si null, "John Doe"
    val result = userName ?: "John Doe"
    println(result)
    //Récupérer le nb de caractères si userName non null, opérateur de
    //non nullité
    val size = userName?.length
    println("Nb caractère prénoms ${size}")


    var listProducts = mutableListOf(
        "Bureau avec vérins","Chaise de travail Herman Miller",
        "Bureau Steelcase chêne","Bureau Ikea SEKØVA",
        "Bureau blanc","Chaise Think V1", "Armoire métal haute"
    )

    println(listProducts);

    //Ajout avec l'opérateur +=
    listProducts += "Armoire basse";
    //ou avec la méthode add
    listProducts.add("Canapé accueil")
    val nbOfIkeaDesk = listProducts.filter { it.startsWith("Bureau") }.sortedBy { it }.count { it.contains("Ikea") };
    println(nbOfIkeaDesk);



    val numerator = 10
    val denominator = 0

    try {
        val resultCalculation = numerator / denominator
        println("Le résultat de la division est : $result")
    } catch (e: ArithmeticException) {
        println(e.message);
        println("La division par 0 n'est pas possible.")
    }
}
