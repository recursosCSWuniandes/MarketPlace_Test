(function (ng) {
    var mod = ng.module('shoppingCartMasterModule', ['shoppingCartModule', 'itemModule', 'masterModule']);

    mod.constant('shoppingCartMasterContext', 'shoppingCarts');
})(window.angular);
