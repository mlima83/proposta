angular.module('proposta-app').controller('PropostaController', [ '$scope', '$stateParams', '$state', 'PropostaService', function ( $scope, $stateParams, $state, PropostaService) {
    var self = this;
    $scope.proposta = {
        cliente :{}
    }
    $scope.estados = [];
    $scope.cpf = '';
    $scope.errors = [];

    $scope.carregarEstados = function () {
        if($scope.estados.length === 0){
            PropostaService.getListEstado()
            .then(function (response) {
                $scope.estados = response.data;
            });
        }
    };

    $scope.clear = function () {
        $scope.searchModel = {
            name : '',
            propostaType_name : ''
        };
        $scope.getPropostas();
    }

    $scope.cadastrar = function(){
        $scope.errors = [];
        PropostaService.save($scope.proposta)
        .then(function (response) {
            if(response.data != null){
                $state.go('resultado', {
                    obj: response.data
                });
            }
        }).catch(function (response) {
            if(response.data != null 
                && response.data.errors != null){
                $scope.errors = response.data.errors;
            }else{
                $scope.errors.push('Ocorreu um erro inesperado, deculpe o transtorno!');
            }
        });
    }

    $scope.buscar = function(){
        PropostaService.buscar($scope.cpf)
        .then(function (response) {
            if(response.data != null){
                $state.go('resultado', {
                    obj: response.data
                });
            }
        }).catch(function (response) {
            if(response.data != null 
                && response.data.errors != null){
                $scope.errors = response.data.errors;
            }else{
                $scope.errors.push('Ocorreu um erro inesperado, deculpe o transtorno!');
            }
        });
    }

    $scope.init = function () {
        if($stateParams.obj){
            $scope.proposta = $stateParams.obj;
        }
        $scope.carregarEstados();
    };

    $scope.init();

}]);