(function (ng) {
    var mod = ng.module('clientModule');

    mod.controller('clientCtrl', ['$scope', 'clientService', 'clientModel', 'shoppingCartService', function ($scope, svc, model, shoppingCartService) {
            svc.extendController(this, $scope, model, 'client', 'Client');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
