/**
 *
 */
var ssRequire = require.config({
    baseUrl : '/opensys/resources/js/',
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
        $('#CheckedAll').click(function() {
            var checkboxs = $('td input:checkbox');
            checkboxs.prop('checked', this.checked);
        });
        $('td input:checkbox').click(function() {
            var tmp = $('td input:checkbox');
            $('#CheckedAll').prop('checked', tmp.length == tmp.filter(':checked').length);
        });

        $('#all').click(function() {
            var checked = $('td input:checked');
            if (checked.length < 1) {
                window.alert("please select users!");
                return;
            }
            var ids = checked.map(function() {
                return ($(this).data('id'));
            }).get();
            var tmpIds = checked.map(function() {
                return ($(this).data('id'));
            }).get().join(',');
            console.log(tmpIds);
            var button = $('#all');
            button.prop('disabled', true);
            $.ajax({
                contentType : 'application/json',
                data : JSON.stringify(ids),
                dataType : 'json',
                method : 'POST',
                url : '/opensys/user/bulk-update',
                success : function(result) {
                    window.alert("the selected user was inactivated!");
                    location.href = "/opensys/user/list";
                },
                error : function(e) {
                    alert(e);
                    button.prop('disabled', false);
                    return;
                }
            });
        });

    });
});
