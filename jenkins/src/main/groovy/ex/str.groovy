package ex

/**
 * Created by wanjia on 3/22/2017.
 */

what = new StringBuffer("test") //"test"//
text = "This is a $what"
println text
//what.replace("t","apple") // not working
what.replace(0,4, "apple")
println text

price = {it.write(54.4)}
company = {it.write("google")}
quote="thoday $company cloased at $price"
println quote

stocks = [apple: 123.4, microsoft: 123.3]
stocks.each{key,value->
company = key
    println "company is $company"
price = value
    println quote
}
