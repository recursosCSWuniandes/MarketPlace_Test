(function(angular){
    var mod = angular.module('productModule');
    
    mod.service('productService', ['CRUDBase','productContext', function(CRUDBase, context){
            CRUDBase.extendService(this, context);
    }]);
})(window.angular);
