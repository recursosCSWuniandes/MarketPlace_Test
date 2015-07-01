(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['$scope', 'productService', 'productModel', function ($scope, svc, model) {
            svc.extendController(this, $scope, model, 'product', 'Product');
            this.fetchRecords();
            $scope.addToCar = function(){
              alert('Added to Cart');     
            };
            
            
        }]);
})(window.angular);
