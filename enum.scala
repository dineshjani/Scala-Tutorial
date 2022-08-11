object Milkway extends Enumeration{
    //planets is like datatype pf Milkyway
    type Planets =Value
    val ME,V,MA,E,J,S,U,N=Value
    val P=Value(9,"P")
    val Z=Value(10,"Z")
    def main(args:Array[String]):Unit={
        println(s"set of valuse type planet that milkiway holds : ${Milkway.values}")
    }
    def isMilkyway(planets:Milkway.Planets):Unit={
     println(s"planet :${planets} and id : ${planets.id} of milkyway galaxy")
    }
    def isPlanet(planet : String) : Unit={
      val boo = Milkway.values.toList.map(v=>v.toString).contains(planet)
      println(boo)
    }
    isMilkyway(Milkway.ME)
    isMilkyway(Milkway.MA)
    isMilkyway(Milkway.Z)
    isPlanet("ME")


}