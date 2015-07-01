(function(angular){
    var mod = angular.module('itemModule');
    
    mod.service('itemService', ['CRUDBase','itemContext', function(CRUDBase, context){
            CRUDBase.extendService(this, context);
    }]);
})(window.angular);
