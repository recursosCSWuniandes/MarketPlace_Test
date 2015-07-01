(function(ng){
    var mod = ng.module('shoppingCartMasterModule');

    mod.service('shoppingCartMasterService', ['masterUtils', 'shoppingCartMasterContext', function(utils, ctx){
            utils.extendService(this, ctx);
    }]);
})(window.angular);
