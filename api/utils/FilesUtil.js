'use strict'

const formidable = require('formidable')
const path = require('path')
const fs = require('fs')

exports.uploadFile = function (req, fileNameWOext) {
  console.log('uploading a file')
  return new Promise((resolve, reject) => {
    let fileName
    let form
    try {
      form = new formidable.IncomingForm()
      console.log('control 1')
      form.multiples = false
      console.log('control 1')
      form.uploadDir = project.uploadDir
      console.log('control 1')
      
      console.log('control 1')
      form.on('file', onFile)
      form.on('error', function (err) {
        console.log('UPLOAD FILE: An error has occur: \n', err)
        reject(err)
      })
      form.on('end', function () {
        resolve(fileName)
      })
      form.parse(req)
    }
    catch(error) {
      reject(error)
    }

    function onFile (field, file) {
      try{
        fileName = fileNameWOext + getExtension(file.name)
        fs.renameSync(file.path, path.join(form.uploadDir, fileName))
        console.log('Nombre archivo: ', fileName)
      } catch (error) {
        console.log('Error on OnFile ', error)
      }
    }

  })
}




exports.removeFile = function (file) {
  console.log('File to delete', file)
  try{
    fs.unlinkSync(file)// .catch(console.error) 
  } catch (error) {
    console.log('Error deleting file', error)
  }
}

function getExtension (fileName) {
  return '.' + fileName.split('.').pop().replace(/[ ]+/g, '')
}
