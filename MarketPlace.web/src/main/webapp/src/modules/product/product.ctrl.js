(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['$scope', 'productService', 'productModel', function ($scope, svc, model) {
            svc.extendController(this, $scope, model, 'product', 'Product');
            this.fetchRecords(); // Consulta todos los records de la entidad Producto
            this.readOnly = true; // Habilita el uso de solo lectura (No permite crear nuevas entidades en el toolbar)
            var self = this;
            $scope.addToCar = function () {
                alert('Added to Cart');
            };
            
            this.addToCartList = function(){
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
