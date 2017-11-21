const express = require('express')
const path = require('path')
const app = express()
const bodyParser = require('body-parser')
const routes = require('./api/routes/Routes')

const port = process.env.PORT || 3000

global.project = {
  projectDir: path.dirname(require.main.filename),
  publicDir: path.dirname(require.main.filename) + '/public/',
  uploadDir: path.dirname(require.main.filename) + '/files/',
  secret: 'secret'
}

app.set('superSecret', 'secretVar'); // secret variable

console.log('directory to public', project.projectDir)
console.log('directory to public', project.publicDir)

app.use(express.static(project.publicDir))
app.use('/files',express.static(project.uploadDir))

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())

routes(app)

app.listen(port)

console.log('App listening on port : ' + port)