package json

import vm.Machines

/**
 * Created by wanjia on 3/23/2017.
 */
class myJsonBuilder {

    def vm = [
            new Machines("name":"chs1","ip":"1.1.1.1"),
            new Machines("name":"chs1","ip":"1.1.1.1")
    ]
    def addrList = [
            ["city": "shanghai", "country": "china", "zip": 123],
            ["city": "newyork", "country": "US", "zip": 1232],
            ["city": "paris", "country": "france", "zip": 33]
    ]

    def produceJson() {

            def builder = new groovy.json.JsonBuilder()
            def root = builder {
                vms vm.collect {
                    [
                    name: it.getName(),
                    ip: it.getIp(),
                    // Named arguments are valid values for objects too
                    address: addrList,
                    status: 'online'//, 'off'
                            ]
                }
            }
            new File("src/main/resources/test.json").write(builder.toPrettyString())
       }
    }

