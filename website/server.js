/**
 * This setup is inspired by the docker tutorial "Dockerizing a Node.js web app"
 * https://docs.docker.com/engine/examples/nodejs_web_app/
 */

var express = require('express');
var morgan = require('morgan');

var PORT = 8080;

var app = express();

app.use(morgan('dev'));
app.use(express.static(__dirname + '/dist'));

app.listen(PORT);

console.log('Webserver running on port ' + PORT);

exports = module.exports = app;
