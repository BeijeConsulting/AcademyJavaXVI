const express = require('express')
const mysql = require('mysql')

const app = express()
const port = 3000
const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3'
})

app.set('view engine', 'ejs')

//Qui si mettono le costanti con i require (IMPORTANTE: nel path NON ci va .js)
const productsRoute = require('./routes/products')

//e poi qui si chiamano gli app.use con i relativi url base
app.use('/products', productsRoute)


app.listen(port, () => {
    console.log(`Ecommerce listening on port ${port}`)
})