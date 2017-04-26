/**
 * @author wadehe
 */
define(['jquery','underscore'],function($,_){
    return {sayHello: function(input){
        if(_.isEmpty(input)){
            window.alert("empty");
        }else{
            window.alert("hello");
        }
    }};
});
