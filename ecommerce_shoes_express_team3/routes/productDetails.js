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

  connection.query('SELECT * FROM product_details,products WHERE products.id = ? AND product_details.product_id = products.id', [req.query.id], (err, rows) => {
    if (err) {
      console.error(err)
      next(err)
    }
    //console.log('rows: ', rows)
    model.productDetails = rows[0]
    res.render('productDetails', model)
  })
    
})

module.exports=router;
