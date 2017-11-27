/**
 * Created by oscar on 6/7/17.
 */

const request = require('request')

function getQuote () {
  return new Promise(function (resolve, reject) {
    request('http://ron-swanson-quotes.herokuapp.com/v2/quotes', function (error, response, body) {
      resolve(body)
    })
  })
}

async function main () {
  let quote = await getQuote()
  return quote
}


async function exec(){
  console.log('main:', await main())
}

exec()