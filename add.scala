object Add{
    //def function_name ([parameter_list]) : [return_type] =
    def functoadd(a:Int,b:Int) : Int ={
    return a+b;
    }
    def main(args: Array[String]){
        println("sum of given two number",functoadd(4,5))
    }
}
// val lambda_exp = (variable:Type) => Transformation_Expression