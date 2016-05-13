/**
 * 
 */
define([ 'jquery', 'underscore', 'backbone' ], function($, _, backbone) {
	function f1() {
		$('#b1').click(function() {
			$.when($.ajax({
				dataType : 'json',
				url : 'find/7'
			}), $.ajax({
				dataType : 'json',
				url : 'address/7'
			})).then(function(result1, result2) {
				var user = result1[0];
				var address = result2[0];
				if (_.isEmpty(user)) {
					window.alert("user is empty!")
					return;
				}
				if (_.isEmpty(address)) {
					window.alert("address is empty!")
					return;
				}
				$('#s').html(address.address1 + '/' + user.userName);
			},function(error1, error2){
				alert(error1);
				alert(error2);
			})
		})
	}
	f1();
	function f2() {
		$('#b2').click(function() {
			_.each([ 1, 2, 3 ], alert);
		})
	}
	f2();
})