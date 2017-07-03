/**
 * Created by wanjia on 17/6/30.
 */

import groovy.json.JsonSlurper

url="https://api.github.com/repos/OpenMindClub/OpenMindWorld/issues/42/comments?access_token=9c7d8cd208a4b73747cec766e3948d3f576dd264"

path="/users/wanjia/github.com.vwan/projects/groovy/htmlToMd/resource/"
src = ["42":"chaoyuezhishang","29":"zhecaishixinlixue"]

src.each{
    key,value->

        newstr = new StringBuilder()

        mdfile = path+"issue_"+key+"_"+value+".md"
    println mdfile
    content = url.toURL().text
    println content
    json = new JsonSlurper().parseText(content)
    json.each{
        author = it.user.login
        println author
        newstr.append("---")
        newstr.append("Author:" + author +"\n")
        body = it.body
        newstr.append(body+"\n")
    }

    new File(mdfile).write(newstr.toString())


}

