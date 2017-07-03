/**
 * Created by wanjia on 17/6/30.
 */

@Grab(group='org.ccil.cowan.tagsoup', module='tagsoup', version='1.2' )
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.2')

import groovyx.net.http.HTTPBuilder

//url="curl https://api.github.com/user/repos?access_token=9c7d8cd208a4b73747cec766e3948d3f576dd264"

path="/users/wj/github.com.vwan/projects/groovy/resource"
src = [path+"chaoyuezhishang",path+"zhecaishixinlixue"]

src.each
{
    srcfile = it+".htm"
    mdfile = it+".md"
    srcFile = new File(srcfile)

    usr = ""
    pwd=""
    def addr       = "https://github.com/OpenMindClub/OpenMindWorld/issues/42?access_token=9c7d8cd208a4b73747cec766e3948d3f576dd264"

   // String userPassBase64 = "$usr:$pwd".toString().bytes.encodeBase64()
    def github = new HTTPBuilder(addr)
 //   github.auth.basic usr,pwd
 //   def authString = "$usr:$pwd".bytes.encodeBase64().toString()
 //   github.setHeaders([Authorization: "Basic $authString"])
    def content = github.get(path: '/')
println content
    //def authString = "$usr:$pwd".bytes.encodeBase64().toString()
    //def conn = addr.toURL().openConnection()
   // println conn
    //conn.setRequestProperty( "Authorization", "Basic $authString" )
   // if( conn.responseCode == 200 ) {
        println "done handling source file"
        def tagsoupParser = new org.ccil.cowan.tagsoup.Parser()
        def parser = new XmlSlurper(tagsoupParser)
        def xml = parser.parse(content)//srcFile)//("http://stackoverflow.com/")
        divs= xml.depthFirst().findAll{
            it.@class=='timeline-comment-wrapper js-comment-container'//S'd-block comment-body markdown-body js-comment-body'
        }

        newstr = new StringBuilder()


        println divs.size()
        divs.each { div ->
            author = div.depthFirst().find {
                it.name() == "strong"
                it.a.@class == "author"
            }
            newstr.append("---" + "\n")
            newstr.append("# Author: " + author + "\n")
            td = div.depthFirst().find {
                it.name() == "td"
                it.@class == 'd-block comment-body markdown-body js-comment-body'
            }
            println td?.size()
            td?.children().each { node ->
                // println node.name()
                switch (node.name()) {
                    case 'p':
                        convertp(node)
                        break;
                    case 'h1':
                        newstr.append("# " + node.text() + "\n\n")
                        break;
                    case 'h2':
                        newstr.append("## " + node.text() + "\n\n")
                        break;
                    case 'h3':
                        newstr.append("## " + node.text() + "\n\n")
                        break;
                    case 'ul':
                        covertul(node)
                        break;
                    case 'blockquote':
                        convertquote(node.p)
                        break;
                }
            }
            // newstr.append("Author:"+author+"\n")
        }

        //println newstr
        new File(mdfile).write(newstr.toString())

   /* } else {
        println "Something bad happened."
        println "${conn.responseCode}: ${conn.responseMessage}"
    }
*/
}

def covertul(node) {
    node.li.each {
        text = it.p.isEmpty() ? it.text() : it.p.text()
        if (!it.a.isEmpty()) {
            text = text.replace(it.a.text(), "[" + it.a.text() + "](" + it.a.@href + ")")
        }
        newstr.append("- " + text + "\n\n")
        if (it.blockquote) {
            it.blockquote.p.each {
                newstr.append("> " + it.text() + "\n\n")
            }
        }

        if (!it.a.img.isEmpty()) {
            newstr.append("! [" + it.a.img.@alt + "][" + it.a.img.@src + "]")
        }
        if (!it.img.isEmpty()) {
            newstr.append("! [" + it.img.@alt + "][" + it.img.@src + "]")
        }
        if(!it.ul.isEmpty()){
            if (!(it.ul instanceof groovy.util.slurpersupport.NodeChildren)) convertul(it.ul)
        }
    }
}



def convertquote(node) {
    node.each {
        text = it.text()
        if (!it.a.isEmpty()) {
            if (!it.text()) {
                text = text.replace(it.a.text(), "[" + it.a.text() + "](" + it.a.@href + ")\n\n")
            }
        }
        newstr.append("> " + text + "\n\n")
    }

}

def convertp(node) {
    text = node.text()
    if (!node.a.isEmpty()) {
        text = text.replace(node.a.text(), "[" + node.a.text() + "](" + node.a.@href + ")\n\n")
    }
    newstr.append("\n\n" + text + "\n\n")
}
