var app = angular.module('contactsApp',['ui.router','ngStorage', 'datetime']);

app.constant('urls', {
    BASE: 'http://localhost/contacts',
    CONTACT_SERVICE_API : 'http://localhost/contacts/api/contacts/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'list',
                controller:'ContactController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, ContactService) {
                        var deferred = $q.defer();
                        ContactService.loadAllContacts().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);
