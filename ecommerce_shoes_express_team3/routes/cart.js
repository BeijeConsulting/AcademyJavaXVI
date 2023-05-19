const express=require('express')
const router=express.Router()
const mysql = require('mysql')
const jwt = require('jsonwebtoken')

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3'
})

router.get('/', (req, res, next) => {
  //connection.connect()
  let token = req.cookies.session
  let model = {}
  if (token === undefined){
    res.redirect('/login')
  }
  else {
    jwt.verify(token, process.env.KEY, function(err, decoded) {
      if (!err) {
        model.user = decoded.user_id
      }
    })
  }

  connection.query('SELECT * FROM shopping_cart_item,product_details,products WHERE shopping_cart_item.user_id = ? AND product_details_id = product_details.id AND product_details.product_id = products.id', [model.user], (err, rows) => {
    if (err) {
      console.error(err)
      next(err)
    }
    //console.log('rows: ', rows)
    model.carts = rows
    res.render('cart', model)
  })

  console.log('end connection...')
  //connection.end()
    
})

module.exports=router;
