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

router.get('/', (req, res) => {
    let type = req.query.type;
    let user = req.cookies.user
  
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    if(typeof type === 'undefined'){
      type = "ogni genere"
      connection.query('SELECT * FROM products where is_listed = 1', (err, rows) => {
        if (err) throw err
          res.render('index', { products: rows , user:user, filter:type})
    })
    }else{
      connection.query('SELECT * FROM products where is_listed = 1 and type = ? ' ,[type], (err, rows) => {
        if (err) throw err
          res.render('index', { products: rows , user:user, filter:type})
      })
    }
    
  
  })

  


  module.exports=router;