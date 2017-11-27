'use strict'

const formidable = require('formidable')
const path = require('path')
const fs = require('fs')

exports.uploadFile = function (req, fileNameWOext) {
    console.log('uploading a file')
    return new Promise((resolve, reject) => {
        const form = new formidable.IncomingForm()
        form.multiples = false
        form.uploadDir = project.uploadDir
        let fileName
        form.on('file', function (field, file) {
            fileName = fileNameWOext + getExtension(file.name)
            fs.renameSync(file.path, path.join(form.uploadDir, fileName))
            console.log('Nombre archivo: ', fileName)
        })
        form.on('error', function (err) {
            console.log('UPLOAD FILE: An error has occur: \n', err)
            reject(err)
        })
        form.on('end', function () {
            resolve(fileName)
        })
        form.parse(req)
    })
}

exports.removeFile = function (file){
    console.log('Archivo a eliminar', file)
    fs.unlinkSync(file)//.catch(console.error)
}


function getExtension(fileName) {
    return '.' + fileName.split('.').pop().replace(/[ ]+/g, '')
}