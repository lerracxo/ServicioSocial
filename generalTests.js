/**
 * Created by oscar on 6/7/17.
 */

// main().then((results) => {
//   console.log(results)
// })
//
// console.log('Este codigo es async')
//
// function main () {
//   return new Promise((resolve, reject) => {
//     console.log('Right Rail - invokeResult')
//     resolve('Hola :D')
//   })
//
// }

// async function asyncFun () {
//   let value = await Promise
//     .resolve(1)
//     .then(x => x * 3)
//     .then(x => x + 5)
//     .then(x => x / 2);
//   return value;
//
// }
// asyncFun().then(x => console.log(`x: ${x}`));
// console.log('finished')

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
  console.log(quote)
  return quote
}


function exec(){
  main().then(console.log)
  // console.log('main:',main())
}

exec()