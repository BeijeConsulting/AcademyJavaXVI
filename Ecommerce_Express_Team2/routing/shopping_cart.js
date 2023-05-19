const express = require('express')
const mysql = require('mysql')
const appRouter = express.Router()
const cookieParser = require('cookie-parser');

// DATABASE
const connection = mysql.createConnection({
    host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
    user: 'admin',
    password: 'FJf7MWgOsW1M5AbKql9g',
    database: 'ecommerce_shoes_2'
})

appRouter.use(cookieParser())
appRouter.use(express.json())
appRouter.use(express.urlencoded({ extended: true }))

//
appRouter.get('/', (req, res) =>{
    let id = parseInt(req.cookies.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT p.brand, p.name, d.id, d.size, d.selling_price, d.quantity '+
        'FROM shopping_cart_item AS s '+
        'JOIN product_details AS d ON s.product_details_id = d.id '+
        'JOIN products AS p ON d.product_id = p.id '+
        'WHERE s.user_id = ?', 
            [id], (err, rows) => {
            if (err) throw err
            let cartItems = rows
            res.render('db3/user/shopping_cart', { cartItems: cartItems, user:req.cookies })
        })
    }
})



module.exports = appRouter;
