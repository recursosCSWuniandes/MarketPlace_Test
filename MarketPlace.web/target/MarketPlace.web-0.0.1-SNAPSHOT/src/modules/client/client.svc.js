(function(angular){
    var mod = angular.module('clientModule');
    
    mod.service('clientService', ['CRUDBase','clientContext', function(CRUDBase, context){
            CRUDBase.extendService(this, context);
    }]);
})(window.angular);
