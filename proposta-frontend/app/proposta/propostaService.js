'use strict';

angular.module('proposta-app').service('PropostaService', ['$resource', 'UrlFactory', function ($resource, UrlFactory) {
    this.promisses = {};
    var self = this;

    this.buscar = function (cpf) {
        return $resource(UrlFactory.getURL('PROPOSTA_CONSULTAR', {cpf:cpf})).get().$promise;
    };

    this.getListEstado = function () {
        return $resource(UrlFactory.getURL('ESTADO_ALL')).get().$promise;
    };

    this.save = function (data) {
        return $resource(UrlFactory.getURL('PROPOSTA_CADASTRAR')).save(data).$promise;
    };
}]);