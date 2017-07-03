/**
 * Created by wanjia on 17/6/30.
 */

import groovy.json.JsonSlurper

date ="2017-07-03"
src = ["42":"超越智商","29":"这才是心理学"]
ids=[
        "1":"一",
        "2":"二",
        "3":"三",
        "4":"四",
        "5":"五",
        "6":"六",
        "7":"七",
        "8":"八",
        "9":"九",
        "10":"十",
        "11":"十一",
        "12":"十二",
        "13":"十三"
]
mdfile =""
src.each{
    key,value->

        path="/users/wanjia/github.com.vwan/projects/OpenMind/cardbook.omw.com/Vwan.omw.com/"+value+"/"
        new File(path).mkdirs()
        temp = ""
        (1..5).each {
            pageid=it
            url = "https://api.github.com/repos/OpenMindClub/OpenMindWorld/issues/" + key + "/comments?page=" + pageid + "&access_token="
println url

            content=url.toURL()?.text
            println content
            if(content) {
                json = new JsonSlurper().parseText(content)
                json.each {
                    author = "\n---\n# 撰写: " + it.user.login + "\n"
                   // println author
                    body = it.body
                    str = replaceChapterNo(author + body, ids)
                    temp = makeMdFile(str, ids, value)
                }
            }
        }
        fileWriteOrAppend(new File(path+date+"-TBD-"+value+".md"),temp)
    }


def replaceChapterNo(str,ids){
    ids.each{
        if (str.contains("第"+it.key+"章")) {
            str = str.replaceAll("第" + it.key + "章", "第" + it.value + "章")
        }
        if (str.contains("Chapter"+it.key)) {
            str = str.replaceAll("Chapter" + it.key, "第" + it.value + "章")
        }
    }
    return str
}

def makeMdFile(str,ids,bookname){
    uncatogeried = ""
    ids.each{
        if(str.substring(0,40).contains("第"+it.value+"章") ){
            key = (it.key.toInteger()<10)?"0"+it.key:it.key
            cfile = new File( path+date+"-"+key+"-"+bookname+".md")
            fileWriteOrAppend(cfile,str)
        }
        isCategoried=false
        ids.each{
            if (str.contains("第"+it.value+"章")){
                isCategoried = true
                return isCategoried
            }
        }
      //  println isCategoried
        if (!isCategoried) uncatogeried += str

    }

    return uncatogeried
}

def fileWriteOrAppend(file,s){

    println s
    if (!file.exists()) file.write(s)
    else file.append(s)
}

