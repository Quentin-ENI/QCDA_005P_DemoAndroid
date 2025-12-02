package fr.eni.ecole.module02demonstration

//Constructeur
class Desk(val height: Int, val width: Int, val depth: Int){
    fun raise(){
        println("Lever le bureau")
    }
    fun lower(){
        println("Baisser le bureau")
    }
}

// Classes immuables
data class User(
    var userName: String,
    var firstName: String,
    var lastName: String,
    var gender: String
)

open class Mobilier(var name : String, var price : Int){
    fun acheter(){
        println("Paiement de $price accepté")
    }
}

class Armoire(marque:String) : Mobilier("Armoire $marque", 1230){
    fun rangerDossier(){
        println("C'est rangé !")
    }
}


interface Personnalisable{
    var profondeur : Int
    fun changerCouleur(couleur : String)
    fun changerLargeur(largeur : Int){
        println("Nouvelle largeur largeur")
    }
}

class Bureau(val modele:String, val marque: String)
    : Mobilier("$marque $modele", 1000), Personnalisable {
    var couleur: String = "Blanche"
    var largeur = 170

    override var profondeur = 80

    override fun changerCouleur(couleur: String) {
        this.couleur = couleur
    }

    override fun changerLargeur(largeur: Int) {
        super.changerLargeur(largeur)
        this.largeur = largeur
    }
}


fun main() {
    val desk = Desk(100, 10, 50);
    println(desk);

    val user = User("aliceDu29", "Alice", "Smith", "féminin");

    val johnDoe = User("johnDoe#123432", "John","Doe","Unknown")
    val newJohnDoe = johnDoe.copy(firstName = "Francis")

    val samePerson = newJohnDoe.equals(johnDoe)

    newJohnDoe.gender = "Male"

    println("last name : ${newJohnDoe.lastName}")

    println(newJohnDoe.toString())

    println(user.firstName);



    val armoire = Armoire("Steelcase")
    armoire.rangerDossier()
    println(armoire.price)
    armoire.price = 100
    println(armoire.price)


    val bureau = Bureau("StokenKase", "IKEA");
    bureau.changerCouleur("Vert");
    println(bureau.couleur)
    bureau.changerLargeur(10);

}