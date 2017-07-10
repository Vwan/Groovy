/**
 * Created by wanjia on 17/6/30.
 */

import groovy.json.JsonSlurper

date ="2017-07-10"
src = [
         "42":"超越智商",
        "29":"这才是心理学",
        "234":"超越智商",
        "214":"这才是心理学",
       // "258":"畅销的原理",
        //"259":"畅销的原理"
       // "274":"日常生活中的自我呈现"
]
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
        "13":"十三",
        "14":"十四",
        "15":"十五"
]
mdfile =""
src.each{
    key,value->

        path="/users/wanjia/github.com.vwan/projects/OpenMind/cardbook.omw.com/Vwan.omw.com/"+key+"_"+value+"/"
        new File(path).mkdirs()
        temp = ""
        (1..5).each {
            pageid=it
            url = "https://api.github.com/repos/OpenMindClub/OpenMindWorld/issues/" + key + "/comments?page=" + pageid + "&access_token=781bad8221cd90e34bc80d1530fba392f53e956e"
println url

            content=url.toURL()?.text
            println content
            if(content) {
                json = new JsonSlurper().parseText(content)
                json.each {
                    author = "\n---\n# 撰写: " + it.user.login + "\n"
                   // println author
                    body = it.body
                   // str = replaceChapterNo(author + body, ids)
                   // temp = makeMdFile(str, ids, value)
                    cfile = new File( path+date+"-"+key+"-"+value+".md")
                    fileWriteOrAppend(cfile,author + body)
                }
            }
        }

    }


def fileWriteOrAppend(file,s){

    println s
    if (!file.exists()) file.write(s)
    else file.append(s)
}

