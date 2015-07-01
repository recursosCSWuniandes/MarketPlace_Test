(function(angular){
    var mod = angular.module('shoppingCartModule');
    
    mod.service('shoppingCartService', ['CRUDBase','shoppingCartContext', function(CRUDBase, context){
            CRUDBase.extendService(this, context);
    }]);
})(window.angular);
