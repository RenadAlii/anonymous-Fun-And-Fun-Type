import kotlin.random.Random
import kotlin.random.nextInt






fun main(args: Array<String>) {


    //Anonymous fun + it keyworld
    val numLeter="Renad ali".count { (it == 'a'|| it == 'd')  }

    println({
      val currentMonth=10
      "Welcome to simvillage,mayor! (copyright $currentMonth)\n numLetter=$numLeter"
    }())
println("------------------------")


    //The fun Type +Implicit return
val greeting:(String)->String={ name -> "hello and good morning $name" }

    //fun arguments
    println(greeting("Abdullah"))
    println("------------------------")


    //Accepting multiple arguments & The fun Type +Implicit return.
    val greetingFun:(String,Int)->String= { numBuildings,playName->
      val currentYear=2018
      println("adding $numBuildings houses")
      "Welcome simVillage,$playName! (copyright $currentYear)"

  }

    //Type inference support
    val greetingFun1={ numBuildings:Int,playName:String ->
        val currentYear=2018
        println("adding $numBuildings houses")
        "Welcome simVillage,$playName! (copyright $currentYear)"

    }

    //Defining a Function That Accepts a Function
    fun runSimulation(playerName:String,greetingFun:(String,Int)->String){
        val numBuilding= Random.nextInt(1..3)
   println(greetingFun(playerName,numBuilding))

    }

   runSimulation("Roa",greetingFun)
    println("-----------Trailing lambda-------------")



//Trailing lambda syntax & fun reference

    val numLeter2="Ali".count {  it == 'd' }

    runSimulation("renad"){playerName,numBuildings ->
        val currentYear=2018
        println("Adding $numBuildings houses")
        "Welcome,$playerName! (copyright $currentYear)"

    }
    println("-----------fun reference-------------")

    runSimulation3("khalid",::printConstructionCost){playerName,numBuildings ->
        val currentYear=2018
        println("Adding $numBuildings houses")
        "Welcome,$playerName! (copyright $currentYear)"
    }

    println("------------------------")

    runSimulation44()



}
//main end


//fun reference
inline fun runSimulation3( playerName: String,costPrinter:(Int)->Unit, greetingFunction: (String, Int) -> String) {
    val numBuildings = Random.nextInt(1..6) //select randomly from 1 to 6
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}


//fun  type as return type

fun runSimulation44() {
    val greetingFunction=greetingfun()
    println(greetingFunction("roa"))
}
fun greetingfun():(String)->String{
    val strType="hospitals"
    var numBuildin:Int =5
    return{playerName:String->
        numBuildin +=1
        println("adding $numBuildin $strType")
        "welcome $playerName"
        ""
    }
}