package Test

import dsl.JenkinsDsl

/**
 * Created by wanjia on 3/8/2017.
 */
class JenkinsDslTest extends  GroovyTestCase{
    void test() {
        def file="D:/GitHub/Jenkins/src/resources/config.txt"
        Binding binding = new Binding();
        JenkinsDsl jenkinsDsl = new JenkinsDsl();
        binding.setVariable("jenkins", jenkinsDsl);
        GroovyShell shell = new GroovyShell(binding);

        Script script = shell.parse(file);
        script.run();

    }
}
