(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['$scope', 'productService', 'productModel', 'itemService', 'shoppingCartService', '$modal', '$location', function ($scope, svc, model, svcItem, svcShoppingCart, $modal, $location) {
            svc.extendController(this, $scope, model, 'product', 'Product');
            this.fetchRecords(); // Consulta todos los records de la entidad Producto
            this.readOnly = true; // Habilita el uso de solo lectura (No permite crear nuevas entidades en el toolbar)
            var self = this;
            var modalTemplate = 'src/modules/product/templates/modal.html';
            $scope.currentRecord;
            $scope.shoppingCart = {name: "The Client Car"};

            $scope.addToCar = function (currentRecord) {
                $scope.currentRecord = currentRecord;
                self.openModal();

            };

            this.addToCartList = function () {
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
                    var addToCar = function (shoppingCar) {
                        var item = {
                            name: result.name,
                            quantity: result.quantity,
                            product: $scope.currentRecord,
                            shoppingCart: shoppingCar
                        };
                        svcItem.saveRecord(item);
                        alert('Added to Shopping Cart');
                    };

                    svcShoppingCart.fetchRecords().then(function (data) {
                        if (data.length > 0) {
                            var shoppingCar = {id: data[0].id, name: data[0].name};
                            addToCar(shoppingCar);
                        } else {
                            svcShoppingCart.saveRecord($scope.shoppingCart).then(function (data) {
                                var shoppingCar = {id: data.id, name: data.name};
                                addToCar(shoppingCar);
                            });
                        }

                    });
                });
            };

            /*
             * Metodo que agrega la accion ir a Carro de compras al toolbar.
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
            $scope.ctrl = {  status: false };
            $scope.currentRecord = currentRecord;
            $scope.item = {name: "order", quantity: 0};
            $scope.ok = function (quantity, name) {
                if (quantity !== null && quantity > 0) {
                    $scope.ctrl = { status: false };
                    $scope.item.name = name;
                    $scope.item.quantity = quantity;
                    $modalInstance.close($scope.item);
                }else{
                    $scope.ctrl = { status: true, type: "danger", msg: "You must enter a valid number" };
                }
                
            };

            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
            $scope.close = function(){
                $scope.ctrl.status = false;
            };

        }]);
})(window.angular);
