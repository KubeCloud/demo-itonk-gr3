/// <reference path="../../../typings/main.d.ts" />
namespace app.services {
    'use strict';

    export interface IDataService {
    }

    export class DataService implements IDataService {
        apiUrl: string = 'http://localhost/';

        constructor(private $http: angular.IHttpService) {
        }

        getPageTexts(id: string): angular.IHttpPromise<any> {
            return this.$http.get(this.apiUrl + 'texts/' + id + '.json');
        }
    }

    angular
        .module('app.services')
        .factory('dataService', ['$http', ($h: angular.IHttpService) => new DataService($h)]);
}
