(function (ng) {
    var mod = ng.module('itemModule');

    mod.controller('itemCtrl', ['$scope', 'itemService', 'itemModel', 'productService', 'shoppingCartService', function ($scope, svc, model, productService, shoppingCartService) {
            svc.extendController(this, $scope, model, 'item', 'Item');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
