(function (ng) {
    var mod = ng.module('itemModule');

    mod.controller('itemCtrl', ['$scope', 'itemService', 'itemModel', '$location', 'productService', function ($scope, svc, model, $location, svcProduct) {
            svc.extendController(this, $scope, model, 'item', '');
            this.loadRefOptions();
            this.fetchRecords();
            this.readOnly = true;
            $scope.total = 0;
            $scope.proItem = [];
            this.items = this.fetchRecords().then(function (dataItem) {
                for (var i = 0; i < dataItem.length; i++) {
                    var proItem = svcProduct.copyRecord(dataItem[i].product);
                    proItem.route = "products";
                    $scope.proItem.push(proItem);
                }
                return dataItem;
            });
            this.products = this.items.then(function (dataItem) {
                var j = 0;
                for (var i = 0; i < $scope.proItem.length; i++) {
                    svcProduct.fetchRecord($scope.proItem[i]).then(function (dataPro) {
                        $scope.total += (dataPro.price * dataItem[j].quantity);
                        j++;
                    });

                }
            });
            $scope.goToGallery = function () {
                $location.path('/product');
            };
        }]);
})(window.angular);
