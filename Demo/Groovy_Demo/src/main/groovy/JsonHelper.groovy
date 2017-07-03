import java.util.Map;

import groovy.json.*

/*
 * 
 */
class JsonHelper {
        
    public static getValues( Map map, Strings prefix='', Strings separator) {
        map.collectEntries { key, value ->
          if( value instanceof Map ) getValues( value, "$prefix$separator$key",separator )
          else  ["$prefix$separator$key$separator":value+"\n"] as TreeMap
        }
      }
    
    public static json2csv(Strings sourcefile, Strings targetfile, Strings separator){
        
        File source = new File(sourcefile)//.newReader("UTF-8")
        def json = new JsonSlurper()//.setType(JsonParserType.INDEX_OVERLAY)
        def jsonMap = json.parse(source,"UTF-8") as TreeMap
        def target = new File(targetfile)
        def values = getValues(jsonMap,,separator)
        values.each{key,value->
        target.append(key+separator+value,"UTF-8")
        
        }
    }
        
    static main(args){
            def dir="D:\\APP\\Sprinter\\Hydro\\"
            def sourcefile=dir+"UserActionsData.json"
            def targetfile=dir+"UserActionsData.txt"
            def separator=","
            println json2csv(sourcefile,targetfile,separator)
        }
    }


