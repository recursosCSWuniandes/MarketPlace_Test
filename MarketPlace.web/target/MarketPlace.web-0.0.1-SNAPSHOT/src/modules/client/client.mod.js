(function (ng) {
    var mod = ng.module('clientModule', ['CrudModule']);

    mod.constant('clientContext', 'clients');

    mod.constant('clientModel', [{
            name: 'name',
            displayName: 'Name',
            type: 'String',
            required: true
        }, {
            name: 'phone',
            displayName: 'Phone',
            type: 'String',
            required: true
        }, {
            name: 'shoppingCart',
            displayName: 'ShoppingCart',
            type: 'Reference',
            service: 'shoppingCartService',
            options: [],
            required: true
        }]);
})(window.angular);
