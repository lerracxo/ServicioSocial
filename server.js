const express = require('express')
const path = require('path')
const app = express()
const bodyParser = require('body-parser')
const routes = require('./api/routes/Routes')

const dao = require('./api/database/DAO')
const queries = require('./api/database/Queries')

const port = process.env.PORT || 3000
global.project = {
  projectDir: path.dirname(require.main.filename),
  publicDir: path.dirname(require.main.filename) + '/public/',
  uploadDir: path.dirname(require.main.filename) + '/files/',
  secret: 'secret'
}

app.set('superSecret', 'secretVar') // secret variable

console.log('directory to public', project.projectDir)
console.log('directory to public', project.publicDir)

app.use(express.static(project.publicDir))
app.use('/files', express.static(project.uploadDir))

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())

routes(app)

app.listen(port)

console.log('App listening on port : ' + port)

dao.query(queries.test).catch(console.log).then(console.log)