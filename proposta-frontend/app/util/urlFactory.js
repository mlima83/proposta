'use strict';

angular.module('proposta-app')
.factory('UrlFactory', [ '$interpolate', function($interpolate) {
	var factory = {};
	var urls = {
        'PROPOSTA_CADASTRAR' : 'api/proposta',
        'PROPOSTA_CONSULTAR' : 'api/proposta/find/{{cpf}}',
        'ESTADO_ALL' : 'api/estado', 
	};
    factory.getPartialURL = function(urlRequired, vars) {
        var partialUrl = urls[urlRequired];
        if (partialUrl && partialUrl.contains('{{') && vars) {
            var exp = $interpolate(partialUrl, false, null, true);
            partialUrl = exp(vars);
        }
        return partialUrl;
    };

    factory.getURL = function(urlRequired, vars) {
        return this.getExternalURL(urlRequired, vars)
    };

    factory.getExternalURL = function(urlRequired, vars) {
        return 'http://127.0.0.1:8080/' + this.getPartialURL(urlRequired, vars);
    };
	return factory;
} ]);