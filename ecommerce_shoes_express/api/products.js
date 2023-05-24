const express=require('express')
const router=express.Router()
const mysql = require('mysql')

const connection = mysql.createConnection({
    host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
    user: 'admin',
    password: 'FJf7MWgOsW1M5AbKql9g',
    database: 'ecommerce_shoes_4'
  })

  router.use(express.urlencoded({
    extended: true
  }))


  
router.get('/details/:id', (req, res) => {
    let user = req.cookies.user
  
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    const id = req.params.id
    connection.query('SELECT * FROM products as p join product_details as pd on p.id=pd.product_id  where p.id = ?',[id], (err, rows) => {
        if (err) throw err
        res.json({  details: rows, user:user})
      //  res.render('product_details', {  details: rows, user:user, filter:{}})    
    })
  
  })

  module.exports=router;