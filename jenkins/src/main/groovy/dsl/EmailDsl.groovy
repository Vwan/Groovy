package dsl

import groovy.xml.MarkupBuilder

/**
 * Created by wanjia on 2017/2/28.
 */
class EmailDsl {
    String to
    String from
    String body
    String subject
    File attachment

    static send(closure){
        EmailDsl emailDsl = new EmailDsl()
        closure.delegate = emailDsl
        closure()
    }

    def to(String to){
        this.to=to;
    }

    def from(String from){
        this.from=from
    }

    def body(String body){
        this.body=body
    }

    def subject(String subject){
        this.subject=subject
    }

    def getXml(){
        doXml(this)
    }

    private static doXml(EmailDsl emailDsl){
        def writer= new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.email(){
            to(emailDsl.to)
            from(emailDsl.from)
            body(emailDsl.body)
            subject(emailDsl.subject)
        }
        println writer
    }
}
