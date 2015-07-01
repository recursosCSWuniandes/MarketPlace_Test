(function (ng) {
    var mod = ng.module('itemModule');

    mod.controller('itemCtrl', ['$scope', 'itemService', 'itemModel', function ($scope, svc, model) {
            svc.extendController(this, $scope, model, 'item', 'Item');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
