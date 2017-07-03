package ex
/**
 * Created by wanjia on 3/22/2017.
 */
class ex1 {
    static def tellFortures(closure){
        Date date = new Date('1/2/3012');
        def time = date.getTime();
        def postFortune = closure.curry(date,time);
        postFortune "your day is "
        postFortune "they are not bugs"

    }

    static void main(args){
        ex1.tellFortures({date, time, fortune->
            println "date is $date, time is $time, fortune is $fortune"
        })
    }
}
