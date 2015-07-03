(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['$scope', 'productService', 'productModel', 'itemService', 'shoppingCartService', '$modal', '$location', function ($scope, svc, model, svcItem, svcShoppingCart, $modal, $location) {
            svc.extendController(this, $scope, model, 'product', 'Product');
            this.fetchRecords(); // Consulta todos los records de la entidad Producto
            this.readOnly = false; // Habilita el uso de solo lectura (No permite crear nuevas entidades en el toolbar)
            var self = this;
            var modalTemplate = 'src/modules/product/templates/modal.html';
            $scope.currentRecord;
            $scope.shoppingCart = {name: "The Client Car"};

            $scope.addToCar = function (currentRecord) {
                $scope.currentRecord = currentRecord;
                self.openModal();

            };

            this.addToCartList = function () {
                alert('Go to Shopping Car');
                $location.path('/shoppingCart/master');
            };

            this.openModal = function (size) {

                var modalInstance = $modal.open({
                    animation: $scope.animationsEnabled,
                    templateUrl: modalTemplate,
                    size: size,
                    controller: 'modalAddCarCtrl',
                    resolve: {
                        currentRecord: function () {
                            return $scope.currentRecord;
                        }
                    }
                });

                modalInstance.result.then(function (result) {
                    var shoppingCar;
                    svcShoppingCart.fetchRecords().then(function (data) {
                        if (data.length > 0) {
                            shoppingCar = {id: data[0].id, name: data[0].name};
                            addToCar();
                        } else {
                            svcShoppingCart.saveRecord($scope.shoppingCart).then(function (data) {
                                shoppingCar = {id: data.id, name: data.name};
                                addToCar();
                            });
                        }
                        var addToCar = function () {
                            var item = {
                                name: result.name,
                                quantity: result.quantity,
                                product: $scope.currentRecord,
                                shoppingCart: shoppingCar
                            };
                            svcItem.saveRecord(item);
                            alert('Added to Shopping Cart');
                        };
                    });
                });
            };

            /*
             * Metodo que agrega una accion al toobar.
             */
            this.globalActions.push({
                name: 'AddtoCart',
                displayName: 'My Shopping Car',
                icon: 'shopping-cart',
                fn: function () {
                    self.addToCartList();
                },
                show: function () {
                    return true;
                }
            });


        }]);

    mod.controller('modalAddCarCtrl', ['$scope', '$modalInstance', 'currentRecord', function ($scope, $modalInstance, currentRecord) {

            $scope.currentRecord = currentRecord;

            $scope.ok = function (quantity, name) {
                var item = {name: name, quantity: quantity};
                $modalInstance.close(item);
            };

            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        }]);
})(window.angular);
