const express = require('express')
const mysql = require('mysql')

const app = express()
const port = 3000
const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_2'
})

app.set('view engine', 'ejs')

app.get('/users', (req, res) => {

    //connection.connect()
    
    connection.query('SELECT * FROM users', (err, rows) => {
        if (err) throw err
        console.log('rows: ', rows)
        //res.render('contacts', { contacts: rows })
    })

    console.log('end connection...')
    //connection.end()
    
  })
//app.get('/addresses', (req, res) => {
//    console.log('end connection...')
//    //connection.end()
//}

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})