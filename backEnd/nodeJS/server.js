var express = require('express'),
  app = express(),
  port = process.env.PORT || 3000,
  // mongoose = require('mongoose'),
  Task = require('./api/models/Model'),
  bodyParser = require('body-parser')

// mongoose.Promise = global.Promise
// mongoose.connect('mongodb://localhost/Tododb')

console.log('directory to public',(__dirname + '/public'))
app.use(express.static(__dirname + '/public'));
app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())

const routes = require('./api/routes/Routes')
routes(app)

app.listen(port)

console.log('App listening on port : ' + port)