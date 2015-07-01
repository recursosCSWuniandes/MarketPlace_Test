(function (ng) {
    var mod = ng.module('shoppingCartMasterModule');

    mod.controller('shoppingCartMasterCtrl', ['$scope', 'shoppingCartMasterService', 'shoppingCartModel', function ($scope, svc, model) {
            svc.extendController(this, $scope, model, 'shoppingCartMaster', 'ShoppingCart Master');
            this.fetchRecords();
        }]);

    mod.controller('itemChildCtrl', ['masterUtils', '$scope', 'itemModel', function (masterSvc, $scope, model) {
            masterSvc.extendCompChildCtrl(this, $scope, model, 'item', 'shoppingCart');
        }]);
})(window.angular);
