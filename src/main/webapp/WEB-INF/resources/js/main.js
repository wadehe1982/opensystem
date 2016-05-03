/**
 * main JS: entry of requireJS, configure dependent JS library. baseUrl :
 * 'resources/js', baseUrl : 'js/lib',
 */
require.config({
	baseUrl : 'js',
	paths : {
		'jquery' : 'lib/jquery',
		'underscore' : 'lib/underscore',
		'backbone' : 'lib/backbone',
		'test' : 'test'
	},
	shim : {
		'underscore' : {
			exports : '_'
		},
		'backbone' : {
			deps : [ 'jquery', 'underscore' ],
			exports : 'backbone'
		}
	}
});

require([ 'jquery', 'underscore', 'backbone', 'test' ], function($, _,
		backbone, test) {
	console.log(window);
})