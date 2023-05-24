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



  router.get('/orders', (req, res) => {

    let user = req.cookies.user
  
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    const id = user.id
    connection.query('SELECT * FROM orders as o where o.user_id= ?',[id], (err, rows) => {
        if (err) throw err
        res.json({  orders: rows, user:user, filter:{}})
        // res.render('orders', {  orders: rows, user:user, filter:{}})
  
      
    })
  
  })

  module.exports=router;