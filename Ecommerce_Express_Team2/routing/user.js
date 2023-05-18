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

appRouter.use(cookieParser());
appRouter.use(express.json())
appRouter.use(express.urlencoded({ extended: true }))

//
appRouter.get('/all', (req, res) => {

    connection.query('SELECT * FROM users', (err, rows) => {
        if (err) throw err
        console.log('rows: ', rows)
    })

})


appRouter.get('/', (req, res) => {
    let id = parseInt(req.cookies.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT * FROM users WHERE id = ?', [id], (err, rows) => {
            if (err) throw err
            res.render('db3/user/user_page', { user: rows[0] })
        })
    }

})

appRouter.get('/my_orders', (req, res) => {

    let id = parseInt(req.cookies.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT o.*, a.label, a.street_address FROM ecommerce_shoes_2.orders AS o JOIN ecommerce_shoes_2.addresses AS a ON o.address_id = a.id WHERE o.user_id = ?', [id], (err, rows) => {
            if (err) throw err
            let orders = rows
            res.render('db3/user/my_order', { orders : orders , user: req.cookies })
        })
    }
})

module.exports = appRouter;