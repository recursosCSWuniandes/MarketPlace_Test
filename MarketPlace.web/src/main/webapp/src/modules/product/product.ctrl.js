(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['$scope', 'productService', 'productModel', 'itemService', 'itemModel', function ($scope, svc, model, svcItem, modelItem) {
            svc.extendController(this, $scope, model, 'product', 'Product');
            this.fetchRecords(); // Consulta todos los records de la entidad Producto
            this.readOnly = true; // Habilita el uso de solo lectura (No permite crear nuevas entidades en el toolbar)
            var self = this;
            $scope.addToCar = function (currentRecord) {
                alert('Added to Cart');
                var item = {name: 'Order',
                    product: currentRecord,
                    shoppingCart: { id: 1, name: "The Client Car"}};
                svcItem.saveRecord(item);
                console.log(item);
            };

            this.addToCartList = function () {
                alert('Added to Cart');
            };


            /*
             * Metodo que agrega una acción al toobar.
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
