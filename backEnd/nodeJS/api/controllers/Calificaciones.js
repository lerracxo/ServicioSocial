'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')
const filesUtil = require('../utils/FilesUtil')

let subDir = '/calificaciones/'

exports.detailCalif = function (req, res) {
    console.log('params', req.params)
    let param = req.params.id
    pool.query(queries.detailProfesorCalif, [param], function (err, data) {
        if (err)
            res.send(err)
        res.json(data.rows)
    })
}

exports.uploadComprobante = function (req, res) {
    let id = req.params.id

    let fileName = subDir + id
    filesUtil.uploadFile(req, fileName)
        .then((finalName) => addComprobante(id, finalName))
        .then(res.send('success'))
        .catch(console.error)
}

exports.deleteCompobante = function (req, res) {
    getDetail(req.params.id).then((calificacion) => {
        console.log('calificacion obj: ', calificacion)
        deleteConstancia(calificacion)
        filesUtil.removeFile(project.uploadDir + calificacion.comprobante)
    }).then(res.send('success')).catch(console.log)

}

function addComprobante(id, finalName) {
    pool.query(queries.updateCalificacionComprobante, [finalName, id], (err, data) => {
        return err ? err : data
    })
}

function getDetail(id) {
    return new Promise((resolve, reject) => {
        pool.query(queries.detailCalificacion, [id], (err, data) => {
            err ? reject(err) : resolve(data.rows[0])
        })
    })
}

function deleteConstancia(cal) {
    pool.query(queries.deleteCalificacionComprobante, [cal.id], (err, data) => {
        return err ? err : data
    })
}

