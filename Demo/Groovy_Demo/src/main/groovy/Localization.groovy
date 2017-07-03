import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

import java.text.SimpleDateFormat
/**
 * Created by wanjia on 2016/4/4.
 */
class Localization {
    static String newFileDir = "d:/temp/";//LocalizationDictionary.archive.xml
    static  String notFoundStr="NOT FOUND IN THE TRANSLATION BUNDLE, PLEASE MANUALLY UPDATE"
    static String tmxDir = "D:\\APP\\MC\\bundle\\tmx\\"
    //static String tmxFile = tmxDir + "QTP001_chs.tmx"
    static Map langlist = ["chs":"zh-CN","jpn":"ja-JP","deu":"de-DE","fra":"fr-FR","kor":"ko-KO","rus":"ru-RU"]//,"kor":"ko-KO"]
    //static Map langlist = ["chs":"zh","jpn":"ja","deu":"de","fra":"fr","kor":"ko"]//,"kor":"ko-KO"]
    static List nonTranslatedList=["Mobile","PropsGrid"]

    static void main(args) {
        def codedir = "D:\\APP\\MC\\Auatomation\\UFT-UI\\uft-ui-record-spy\\UFT-UI-SPY\\Model";
       // def locale = "ja-JP"
        def newFileName = newFileDir + "LocalizationDictionary.archive.xml"
        File newFile = new File(newFileName)
        def enStrings =getAllSourceStringsFromCode(codedir) //["Object Spy"]//
        enStrings.remove("确定")
   //     println enStrings.size()
        def map =[:]
        def lang="jpn"
        enStrings.add("BROWSER");
        enStrings.each {
            def targetlist = new ArrayList()
            def srcStr = it;
            langlist.each {psllang, locale->
                def flag = false
                def target =""
                new File(tmxDir).listFiles().any{
                    if (it.canonicalPath.contains(("_" + psllang + ".tmx"))) {
                        def filename= it.canonicalPath
                    //    println filename
                        if (nonTranslatedList.contains(srcStr)){
                            target=srcStr
                        }
                        else{
                            target = getLocalizedString(filename, srcStr)
                        }
                        println "$srcStr is "+isAllUppercase((srcStr).toString())
                            if (isAllUppercase(srcStr)){
                                // convert target string to all uppercase
                                println locale;
                                println target;
                               target =  target.toUpperCase(new java.util.Locale(locale));
                                println target;
                            }
                    //    println target
                            if (target!=notFoundStr){//target != "" && target !=null) {
                                flag=true
                            }
                        }
                 //   println target
                    if (flag==true) { true}
                    }
                targetlist.add(target)
            }
            map.put(srcStr, targetlist)
        }
        println map
            def xml = generateLocalizationDictionarySingle(map)
           //  println archive.xml
        // backup file
        println newFileName
        if (newFile.exists()) {
            println newFileName+".backupOn."+new SimpleDateFormat("yyyy-mm-dd").format(new Date())
            newFile.renameTo(new File(newFileName+".backupOn."+new SimpleDateFormat("yyyy-mm-dd").format(new Date())))
        }
        new File(newFileName).write(xml)

       // println getLocalizedString("D:\\APP\\MC\\bundle\\tmx\\QTP004_chs.tmx","Object Spy")
        }


    static String getLocalizedString(String filename, String sourceStr) {
        def xml = new XmlSlurper().parse(new File(filename))
        def target="";
        def targetStr = xml.body.tu.find {
            it.tuv.collect { it.seg }[0] ==~ "(?i)"+ sourceStr
        }.tuv[1].text()
        if (targetStr=="" || targetStr==null){
            targetStr=notFoundStr
        }
          return targetStr
    }

    static public String generateLocalizationDictionary(String srcStr, String targetStr, String lang) {
        def builder = new StreamingMarkupBuilder()
        builder.encoding = 'UTF-8'
        def xml = builder.bind {
            mkp.xmlDeclaration()
            //namespaces << [prefix:'http://']
            body {
                    tu {
                        tuv("lang": "en-US") {
                            seg srcStr
                        }
                        tuv("lang": lang) {
                            seg targetStr
                        }
                    }
                }
            }

      xml =  println XmlUtil.serialize(xml)
   //     println archive.xml
        return xml
    }


    static public String generateLocalizationDictionary(Map strmap, String lang) {
        def builder = new StreamingMarkupBuilder()
        builder.encoding = 'UTF-8'
        def xml = builder.bind {
            mkp.xmlDeclaration()
            //namespaces << [prefix:'http://']
            body {
                strmap.each {k,v->
                    tu {
                       // tuv("lang": "en-US") {
                            "en" k
                       // }
                     //   tuv("lang": lang) {
                            lang v
                        }
                    }
                }
            }

        xml =  XmlUtil.serialize(xml)
      //  println archive.xml
        return xml
    }

    // strmap [en:[lang]]
    static public String generateLocalizationDictionarySingle(Map strmap) {
        def builder = new StreamingMarkupBuilder()
        builder.encoding = 'UTF-8'
        def xml = builder.bind {
            mkp.xmlDeclaration()
            //namespaces << [prefix:'http://']
            body {
                strmap.each {k,v->
                    int i=0;
                    tu {
                            "en" k
                        langlist.each{k1,v1->
                      //      println "v1 is $v1"
                      //      println "k1 is $k1"
                      //      println v[i]
                                "$v1" v[i]
                            i++
                            }

                        }

                    }

            }
        }
        xml =  XmlUtil.serialize(xml)
        //  println archive.xml
        return xml
    }

    static public List getAllSourceStringsFromCode(String dir){
        def list = new ArrayList();
        def filter = ".PropertyNames.Name"
        new File(dir).traverse {
            if (it.isFile() && it.canonicalPath.contains(".cs")){
                it.eachLine {
                    if (it.contains(filter)){
                        def str = it.split(filter+",")
                        str = str[1].replaceAll("\\);","")
                        if (str.contains("\"")){ // str is not yet resourced
                        str = str.replaceAll('"',"")
                        list << str.stripIndent()
                    }
                    }
                }
            }
        }
        return list.unique()
    }

    static public boolean isAllUppercase (String str){
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if (!c.isUpperCase() & c!=' ') {
                    return false;
                }
            }
            //str.charAt(index)
            return true;
        }

}
