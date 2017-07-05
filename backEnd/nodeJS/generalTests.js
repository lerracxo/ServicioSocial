/**
 * Created by oscar on 6/7/17.
 */

main().then((results) => {
  console.log(results)
})

console.log('Este codigo es async')

function main () {
  return new Promise((resolve, reject) => {
    console.log('Right Rail - invokeResult')
    resolve('Hola :D')
  })

}