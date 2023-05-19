const express=require('express')
const router=express.Router()
const mysql = require('mysql')
const jwt = require('jsonwebtoken')
const dotenv = require('dotenv')

dotenv.config()

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3'
})

router.get('/', (req, res) => {
  //connection.connect()
  let token = req.cookies.session
  let model = {}
  if (token !== undefined){
    jwt.verify(token, process.env.KEY, function(err, decoded) {
      if (!err) {
        model.user = decoded.user_id
      }
    })
  }

  connection.query('SELECT * FROM shopping_cart_item,product_details,products WHERE shopping_cart_item.user_id = ? AND product_details_id = product_details.id AND product_details.product_id = products.id', [model.user], (err, rows) => {
      if (err) throw err
      console.log('rows: ', rows)
      res.render('cart', { carts: rows })
  })

  console.log('end connection...')
  //connection.end()
    
})

module.exports=router;
