// This is intended to be a wrapper for all messages exchanged from Angular and the Backend

exports.message = function (err, data, msg) {
  this.error = err
  this.data = data
  this.msg = msg
}
