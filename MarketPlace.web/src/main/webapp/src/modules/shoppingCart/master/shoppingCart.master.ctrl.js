(function (ng) {
    var mod = ng.module('shoppingCartMasterModule');

    mod.controller('shoppingCartMasterCtrl', ['$scope', 'shoppingCartMasterService', 'shoppingCartModel', '$location', 'itemService', 'productService', function ($scope, svc, model, $location, svcItem, svcProduct) {
            svc.extendController(this, $scope, model, 'shoppingCartMaster', 'ShoppingCart Master');
            this.fetchRecords();
            $scope.total = 0;
            var self = this;
            $scope.goToGallery = function () {
                $location.path('/product');
            };
            /*
             * Metodo suma.
             */
            this.calculateTotal = (function () {
                svcItem.fetchRecords().then(function (data) {
                    for (var i = 0; i < data.length; i++) {                   
                            $scope.total = (data[i].quantity) + $scope.total;
                    }
                });

            })();



        }]);

    mod.controller('itemChildCtrl', ['masterUtils', '$scope', 'itemModel', function (masterSvc, $scope, model) {
            masterSvc.extendCompChildCtrl(this, $scope, model, 'item', 'shoppingCart');
        }]);
})(window.angular);
