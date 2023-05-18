const express = require('express')
const mysql = require('mysql')
const appRouter = express.Router()
//const cookieParser = require('cookie-parser');

// DATABASE
const connection = mysql.createConnection({
    host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
    user: 'admin',
    password: 'FJf7MWgOsW1M5AbKql9g',
    database: 'ecommerce_shoes_2'
})

appRouter.use(express.json())
appRouter.use(express.urlencoded({ extended: true }))

//
appRouter.get('/all', (req, res) => {
    connection.query('SELECT * FROM products', (err, rows) => {
        if (err) throw err
        let products = rows;
        res.render('db3/index', { products: products , user:req.cookies})
    })

})

appRouter.get('/:id', (req,res) => {
    console.log("Parametro -> ", req.params)
    connection.query('SELECT * FROM product_details WHERE product_id = ?', [req.params.id], (err, rows) =>{
        if (err) throw err
        let details = rows;
        res.render('db3/product', { details: details , user:req.cookies})
    })

})

module.exports = appRouter;
