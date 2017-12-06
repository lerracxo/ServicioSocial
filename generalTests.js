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

const connectionURL = 'postgres://oscar:serviciosocial@localhost:5432/testing'
const conn = 'postgres://cjddxguyxsniml:0cd5fcc2c06001da41e47ff37fcb25d13b1b728a4fc456a7fa1734873ee56fd9@ec2-54-163-235-175.compute-1.amazonaws.com:5432/d6ggemgpssr18a'


