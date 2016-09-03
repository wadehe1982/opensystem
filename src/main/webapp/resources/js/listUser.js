/**
 *
 */
var ssRequire = require.config({
    baseUrl : '/opensystem/resources/js/',
    paths : {
        'jquery' : 'lib/jquery',
        'underscore' : 'lib/lodash',
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
            console.log(ids);
            var tmpIds = checked.map(function() {
                return ($(this).data('id'));
            }).get().join(',');
            console.log(tmpIds);
            var button = $('#all');
            button.prop('disabled', true);
            $.ajax({
                contentType : 'application/json;charset=utf-8',
                data : JSON.stringify(ids),
                dataType : 'json',
                method : 'POST',
                url : '/opensystem/user/bulk-update',
                success : function(result) {
                    window.alert("the selected user was inactivated!");
                    location.href = "/opensystem/user/list";
                },
                error : function(e) {
                    alert(e);
                    button.prop('disabled', false);
                    return;
                }
            });
        });
        $('#test').click(function() {
            var ids = new Array();
            ids.push("1");
            ids.push("2");
            console.log(ids);
            var param = {"name":"test_name"};
            $.ajax({
                // contentType : 'application/json',
                data : {name: "xxx",ids: ids},
                dataType : 'json',
                method : 'POST',
                url : '/opensystem/user/test01',
                traditional: true,
                success : function(result) {
                    window.alert(result);
                    // location.href = "/opensystem/user/list";
                },
                error : function(e) {
                    alert(e);
                    return;
                }
            });
        });
        $('#previous').click(function(){
            var pageIndex = $(this).data("page-index");
            var lastPage = Number(pageIndex)- Number(1);
            window.location='/opensystem/user/list2/' + lastPage;
        });
        $('#next').click(function(){
            var pageIndex = $(this).data("page-index");
            var nextPage = Number(pageIndex)+ Number(1);
            window.location='/opensystem/user/list2/' + nextPage;
        });
        $('ul li a[name=btnPages]').click(function(){
            window.alert($(this).data('page-index'));
            location.href = '/opensystem/user/list2/' + $(this).data('page-index');
        });
        var lis = $('#pagination li');
        _.forEach(lis, function(n){
            var index = $(n).data("page-index");
            var current = $(n).data("current-page");
            console.log(n);
            console.log(index);
            console.log(current);
            if(typeof(index) != 'undefined' && typeof(current) != 'undefined' && _.eq(index,current)){
                $(n).addClass('active');
            }
        });

    });
});
