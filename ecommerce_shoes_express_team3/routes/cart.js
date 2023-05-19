const express=require('express')
const router=express.Router()
const mysql = require('mysql')

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3'
})

router.get('/', (req, res) => {
  //connection.connect()

  connection.query('SELECT DISTINCT * FROM shopping_cart_item,product_details,products WHERE shopping_cart_item.product_details_id = product_details.id AND product_details.product_id = products.id', (err, rows) => {
      if (err) throw err
      console.log('rows: ', rows)
      res.render('cart', { carts: rows })
  })

  console.log('end connection...')
  //connection.end()
    
})

module.exports=router;
