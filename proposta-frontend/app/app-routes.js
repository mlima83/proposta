'use strict';

angular.module('proposta-app').config(function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.otherwise('/');
  $stateProvider
    .state('cadastrar', {
      url: '/',
      templateUrl: 'proposta/cadastrar.html',
      controller: 'PropostaController'
    })
    .state('consultar', {
      url: '/consultar',
      templateUrl: 'proposta/consultar.html',
      controller: 'PropostaController'
    })
    .state('resultado', {
      url: '/resultado',
      templateUrl: 'proposta/resultado.html',
      controller: 'PropostaController',
      params: {
        obj: null
      }
    });

});