(function (ng) {
    var mod = ng.module('shoppingCartModule');

    mod.controller('shoppingCartCtrl', ['$scope', 'shoppingCartService', 'shoppingCartModel','$location', function ($scope, svc, model, $location) {
            svc.extendController(this, $scope, model, 'shoppingCart', 'ShoppingCart');
            this.fetchRecords();         
        }]);
})(window.angular);
