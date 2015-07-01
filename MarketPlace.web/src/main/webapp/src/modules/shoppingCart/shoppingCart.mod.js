(function (ng) {
    var mod = ng.module('shoppingCartModule', ['CrudModule']);

    mod.constant('shoppingCartContext', 'shoppingCarts');

    mod.constant('shoppingCartModel', [{
            name: 'name',
            displayName: 'Name',
            type: 'String',
            required: true
        }]);
})(window.angular);
