(function (ng) {

    var mainApp = ng.module('mainApp', [
        'clientModule',
        'itemModule',
        'productModule',
        'shoppingCartModule',
        'shoppingCartMasterModule',
        'ngRoute'
    ]);

    mainApp.config(['$routeProvider', function ($routeProvider) {
            var crudTpl = 'src/shared/crud/crud.tpl.html';
            var crudCtrl = 'ctrl';
            $routeProvider
                .when('/client', {
                    templateUrl: crudTpl,
                    controller: 'clientCtrl',
                    controllerAs: crudCtrl
                })
                .when('/item', {
                    templateUrl: 'src/modules/item/templates/ShoppingCart.html',
                    controller: 'itemCtrl',
                    controllerAs: crudCtrl
                })
                .when('/product', {
                    templateUrl: 'src/modules/product/templates/galery.html',
                    controller: 'productCtrl',
                    controllerAs: crudCtrl
                })
                .when('/shoppingCart', {
                    templateUrl: crudTpl,
                    controller: 'shoppingCartCtrl',
                    controllerAs: crudCtrl
                })
                .when('/shoppingCart/master', {
                    templateUrl: 'src/modules/shoppingCart/templates/ShoppingCart.html',
                    controller: 'shoppingCartMasterCtrl',
                    controllerAs: crudCtrl
                })
                .otherwise('/');
        }]);
})(window.angular);
