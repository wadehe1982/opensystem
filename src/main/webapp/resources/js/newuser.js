/**
 *
 */
var ssRequire = require.config({
    baseUrl : '/resources/js/',
    paths : {
        'jquery' : 'lib/jquery',
        'underscore' : 'lib/underscore',
        'backbone' : 'lib/backbone'
    },
    shim : {
        'underscore' : {
            exports : '_'
        },
        'backbone' : {
            deps : ['jquery', 'underscore'],
            exports : 'backbone'
        }
    }
});

ssRequire(['jquery', 'underscore', 'backbone'], function($, _, backbone) {
    $(function() {
        $('#b').click(function() {
            var userName = $('#username').val();
            var password = $('#password').val();
            var address1 = $('#a1').val();
            var address2 = $('#a2').val();
            var zipcode = $('#zipcode').val();
            var button = $('#b');

            var para = {
                id : '',
                userName : userName,
                password : password,
                address : {
                    addressId : "",
                    address1 : address1,
                    address2 : address2,
                    zipcode : zipcode
                }
            };
            var user = JSON.stringify(para);
            button.prop('disabled', true);
            $.ajax({
                contentType : 'application/json',
                data : user,
                dataType : 'json',
                method : 'POST',
                url : 'save',
                success : function(result) {
                    alert("success" + result);
                    button.prop('disabled', false);
                },
                error : function(e) {
                    alert(e);
                    button.prop('disabled', false);
                }
            });

        });
    });
});
