const express = require('express')
const path = require('path')
const app = express()
const port = 3000

//app.use('/static', express.static('public'))
app.use('/static', express.static(path.join(__dirname, 'public')))

//app.use('/views', express.static(path.join(__dirname, 'views')))

app.set('view engine', 'ejs')

app.get('/', (req, res) => {
  res.render('index', { title: 'Test Pug', message: 'Hello Von Neumann!', user: {name: 'Pippo'} })
})

app.get('/list', (req, res) => {
  let users = ['Pippo', 'Pluto', 'Paperino', 'Paperina']
  res.render('list', { usersList: users })
})

/*app.set('view engine', 'pug')
app.get('/', (req, res) => {
  res.render('index', { title: 'Test Pug', message: 'Hello Von Neumann!' })
})*/

app.get('/ciao', (request, response) => {
  response.send('CIAO')  
})

app.get('/hello', (req, res) => {
  res.send('Hello World!')
})

app.get('/add', (req, res) => {
  console.log(req.query);
  let array = [5, 8];
  console.log(array);
  console.log(req.query);
  let somma = parseInt(req.query.a1) + parseInt(req.query.a2);
  res.send('result: ' + somma)
})


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})