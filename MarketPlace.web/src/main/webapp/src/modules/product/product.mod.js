(function (ng) {
    var mod = ng.module('productModule', ['CrudModule']);

    mod.constant('productContext', 'products');

    mod.constant('productModel', [{
            name: 'name',
            displayName: 'Name',
            type: 'String',
            required: true
        }, {
            name: 'price',
            displayName: 'Price',
            type: 'Integer',
            required: true
        }, {
            name: 'description',
            displayName: 'Description',
            type: 'String',
            required: true
        }, {
            name: 'type',
            displayName: 'Type',
            type: 'String',
            required: true
        }, {
            name: 'image',
            displayName: 'Image',
            type: 'String',
            required: true
        }]);
})(window.angular);
