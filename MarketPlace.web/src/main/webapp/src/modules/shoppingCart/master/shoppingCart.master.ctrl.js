(function (ng) {
    var mod = ng.module('shoppingCartMasterModule');

    mod.controller('shoppingCartMasterCtrl', ['$scope', 'shoppingCartMasterService', 'shoppingCartModel','$location', function ($scope, svc, model,$location) {
            svc.extendController(this, $scope, model, 'shoppingCartMaster', 'ShoppingCart Master');
            this.fetchRecords();
            var self = this;
            this.goToGallery = function(){
                $location.path('/product');
            };
            /*
             * Metodo que agrega una accion al toobar.
             */
            this.globalActions.push({
                name: 'Gallery',
                displayName: 'Gallery',
                icon: 'film',
                fn: function () {
                    self.goToGallery();
                },
                show: function () {
                    return true;
                }
            });
        }]);

    mod.controller('itemChildCtrl', ['masterUtils', '$scope', 'itemModel', function (masterSvc, $scope, model) {
            masterSvc.extendCompChildCtrl(this, $scope, model, 'item', 'shoppingCart');
        }]);
})(window.angular);
