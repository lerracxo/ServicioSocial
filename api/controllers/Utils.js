'use strict'
const axios = require('axios')
const fs = require('fs')
const path = require('path')

const filesUtil = require('../utils/FilesUtil')

const subDir = '/dataUpload/calif/'

module.exports = {
  GET: [
    {endpoint: '/utils/testDownload', method: testDownload},
    {endpoint: '/', method: redirect}
  ],
  POST: [
    {endpoint: '/utils/simpleUpload', method: simpleUpload}
  ],
  DELETE: []
}

function testDownload (req, res) {
  const message = 'this is the file :) '
  const url = 'http://ipv4.download.thinkbroadband.com/100MB.zip'

  const fileName = path.join(project.uploadDir, (subDir+ Date.now()) )


  axios.get(url, {responseType: 'stream'}).then(response => {

    console.log('structure of response', Object.keys(response))
    console.log('headers of response',response.request)
    // console.log('response',response)

    
    response.data.pipe( fs.createWriteStream(fileName))
    console.log('fileName', fileName)
    // fs.writeFilemdSync(fileName, response.data)
    console.log('fileSaved')
    res.status(200)
    res.json('all OK ') //response.response)
  })
  console.log(message)

  // res.json(message)
}

function redirect (req, res) {
  res.redirect('/app')
}

function simpleUpload (req, res) {
  filesUtil.uploadFile(req, subDir + Date.now())
  .then(res.json('OK'))
  .catch(error => res.json(error))
} 