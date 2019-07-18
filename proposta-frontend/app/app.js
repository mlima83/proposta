'use strict';

var app = angular
.module('proposta-app', [
  'ui.router',
  'ngResource',
  'ui.mask'
]);

Array.prototype.pushUnique = function(args) {
	for (var i = 0; i < args.length; i++) {
		if (args[i] && this.indexOf(args[i]) < 0) {
			this.push(args[i]);
		}
	}
};

Array.prototype.last = function() {
	return this[this.length - 1];
};

String.prototype.endsWith = function(suffix) {
	return this.indexOf(suffix, this.length - suffix.length) !== -1;
};

String.prototype.contains = function(it) {
	return this.indexOf(it) != -1;
};