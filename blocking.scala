object blocking{
    
    def something():Int= {
        println("in something fun")
        Thread.sleep(1000)
        5
    }
    def main(args: Array[String]){
        println("in main") 
       println(something())   //untill result will not received untill we connot jump to next line
       println("its blcoking code")   // forn execute this line we can use feature so that next line can be exccuted
    }
}