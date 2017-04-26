/**
 * @author wadehe
 */
var ssRequire = require.config({
    paths: {
        jquery: '../lib/jquery.min',
        hello : 'hello'
    },
    shim : {
        jquery : {
            exports : 'jquery'
        }
    }
});

ssRequire(['jquery','hello'],function($, hello){
    $('#submit').click(function() {
        hello.sayHello("xx");
    });
});
