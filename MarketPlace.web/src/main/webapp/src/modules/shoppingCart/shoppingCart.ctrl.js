(function (ng) {
    var mod = ng.module('shoppingCartModule');

    mod.controller('shoppingCartCtrl', ['$scope', 'shoppingCartService', 'shoppingCartModel', function ($scope, svc, model) {
            svc.extendController(this, $scope, model, 'shoppingCart', 'ShoppingCart');
            this.fetchRecords();
        }]);
})(window.angular);
