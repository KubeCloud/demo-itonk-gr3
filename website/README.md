# Website
AngularJS website for ONK project.

## Install
Install dependencies and type definitions with npm.
```
npm install
```

## Local or Cluster?
To specify which backend to use, go to /src/app.config.ts
```
namespace app {
    'use strict';

    angular
        .module('app')
        .config(['$urlRouterProvider', ($urlRouterProvider: angular.ui.IUrlRouterProvider) => {
            $urlRouterProvider.otherwise('/');
        }])
        .constant('apiConfigUrl', 'http://localhost:8080/');
        // .constant('apiConfigUrl', 'http://192.168.1.31/');
}
```

## Building
Build the application with the default gulp task.
```
gulp
```

There are several gulp tasks to ease development.
See `gulpfile.js` for details.

## Running the application
Start a local node.js server with npm.
```
npm run start
```

Navigate to http://localhost:8080/
