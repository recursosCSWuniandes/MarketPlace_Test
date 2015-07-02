(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['$scope', 'productService', 'productModel', 'itemService', 'itemModel', '$modal', function ($scope, svc, model, svcItem, modelItem, $modal) {
            svc.extendController(this, $scope, model, 'product', 'Product');
            this.fetchRecords(); // Consulta todos los records de la entidad Producto
            this.readOnly = false; // Habilita el uso de solo lectura (No permite crear nuevas entidades en el toolbar)
            var self = this;
            $scope.currentRecord;

            $scope.addToCar = function (currentRecord) {
                $scope.currentRecord = currentRecord;
                self.openModal();

            };

            this.addToCartList = function () {
                alert('Added to Cart');
            };


            $scope.ok = function (quantity, currentRecord, name) {
                var item = {name: name,
                    quantity: quantity,
                    product: currentRecord,
                    shoppingCart: {id: 1, name: "The Client Car"}};
                svcItem.saveRecord(item);
            };


            this.openModal = function (size) {

                var modalInstance = $modal.open({
                    animation: $scope.animationsEnabled,
                    templateUrl: 'src/modules/product/templates/modal.html',
                    size: size,
                    controller: 'productCtrl',
                    resolve: {
                        currentRecord: function () {
                            return $scope.currentRecord;
                        }
                    }
                });
            };

            /*
             * Metodo que agrega una accion al toobar.
             * 
             */
            this.globalActions.push({
                name: 'AddtoCart',
                displayName: 'Add to Cart',
                icon: 'shopping-cart',
                fn: function () {
                    self.addToCartList();
                },
                show: function () {
                    return true;
                }
            });



        }]);
})(window.angular);
