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
  console.log('GET /api');
    const {type} = req.body;
    console.log('GET /api', type);
    let user = req.cookies.user
  
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    if( typeof type === 'undefined'){
      connection.query('SELECT * FROM products where is_listed = 1', (err, rows) => {
        if (err) throw err
        res.json({ products: rows , user:user, filter:type})
        //  res.render('index', { products: rows , user:user, filter:type})
    })
    }else{
      connection.query('SELECT * FROM products where is_listed = 1 and type = ? ' ,[type], (err, rows) => {
        if (err) throw err
        res.json({ products: rows , user:user, filter:type})
          //res.render('index', { products: rows , user:user, filter:type})
      })
    }
    
  
  })

  


  module.exports=router;