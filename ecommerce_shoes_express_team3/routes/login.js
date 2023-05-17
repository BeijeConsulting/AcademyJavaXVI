const express=require('express')
const router=express.Router()
const mysql = require('mysql')

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3'
})

router.use(express.urlencoded({
  extended: true
}))

router.get('/', (req, res) => {
  res.render('login', {error: 'no'})
})

router.post('/', (req, res, next) => {
  let email = req.body.email
  let password = req.body.password
  let query = 'SELECT * FROM users WHERE email = ? AND password = ?'
  connection.query(query, [email, password], function(err, rows) {
    if (err) throw err
    if (rows.length == 1) {
      res.redirect('/')
    }
    else {
      res.render('login', {error: 'yes'})
    }
  })
})

/*
router.get('/', (req, res) => {
  //connection.connect()

  connection.query('SELECT * FROM products', (err, rows) => {
      if (err) throw err
      console.log('rows: ', rows)
      res.render('products', { products: rows })
  })

  console.log('end connection...')
  //connection.end()
    
}) */

module.exports=router;
