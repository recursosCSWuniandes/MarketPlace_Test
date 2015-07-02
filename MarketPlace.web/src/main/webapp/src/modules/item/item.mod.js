(function (ng) {
    var mod = ng.module('itemModule', ['CrudModule']);

    mod.constant('itemContext', 'items');

    mod.constant('itemModel', [{
            name: 'name',
            displayName: 'Name',
            type: 'String',
            required: true
        }, {
            name: 'product',
            displayName: 'Product',
            type: 'Reference',
            service: 'productService',
            options: [],
            required: true
        }, {
            name: 'shoppingCart',
            displayName: 'ShoppingCart',
            type: 'Reference',
            service: 'shoppingCartService',
            options: [],
            required: true
        }, {
            name: 'quantity',
            displayName: 'Quantity',
            type: 'Integer',
            required: true
        }]);
})(window.angular);
