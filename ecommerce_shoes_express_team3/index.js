const express = require('express')
const mysql = require('mysql')
const cookieParser = require('cookie-parser')
const dotenv = require('dotenv')

dotenv.config()

const app = express()
const port = 3000
const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3'
})

app.set('view engine', 'ejs')
app.use(cookieParser())

//Qui si mettono le costanti con i require (IMPORTANTE: nel path NON ci va .js)
const homeRoute = require('./routes/home')
const loginRoute = require('./routes/login')
const logoutRoute = require('./routes/logout')
const registerRoute = require('./routes/register')
const shoppingCartRoute = require('./routes/cart')

//e poi qui si chiamano gli app.use con i relativi url base
app.use('/', homeRoute)
app.use('/cart', shoppingCartRoute)
app.use('/login', loginRoute)
app.use('/logout', logoutRoute)
app.use('/register', registerRoute)

app.use((req, res, next) => {
  res.status(404).render('404')
 })

app.use((error, req, res, next) => {
  console.error(error.stack);
  res.status(500).render('500');
})

app.listen(port, () => {
    console.log(`Ecommerce listening on port ${port}`)
})