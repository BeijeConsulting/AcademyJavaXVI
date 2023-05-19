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
    res.cookie('id', id, { maxAge: 90000, httpOnly: true });

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT p.brand, p.name, s.product_details_id, d.size, d.selling_price, s.quantity, s.id '+
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



appRouter.post('/remove_all', (req, res) => {
    let id = parseInt(req.cookies.id)

    connection.query('DELETE FROM shopping_cart_item WHERE user_id = ?', 
        [id], (err, rows) => {
        if (err) throw err
        res.redirect('/shopping_cart')
    })
})

appRouter.get('/remove_cart_item/:id', (req, res) => {
    let id = parseInt(req.cookies.id)
    let shopping_cart_item_id = parseInt(req.params.id)

    connection.query('DELETE FROM shopping_cart_item WHERE id = ? AND user_id = ?',
        [shopping_cart_item_id, id], (err, rows) => {
            if (err) throw err
        
        res.redirect('/shopping_cart')
        })
})

appRouter.post('/add_shopping_cart_item', (req, res) => {
    let id = parseInt(req.cookies.id)
    let product_details_id = parseInt(req.body.product_details_id)
    let quantity = parseInt(req.body.quantity)

    connection.query('INSERT INTO shopping_cart_item (user_id, product_details_id, quantity) VALUES (?, ?, ?)',
        [id, product_details_id, quantity], (err, rows) => {
            if (err) throw err
        res.redirect('/shopping_cart')
        })
})

appRouter.get('/order', (req, res) => {
    let id = parseInt(req.cookies.id)
    let order_date = new Date()
    let order_status = 'completed'
    var cartItemsx = ""
    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT p.brand, p.name, s.product_details_id, d.size, d.selling_price, s.quantity, s.id , p.color '+
        'FROM shopping_cart_item AS s '+
        'JOIN product_details AS d ON s.product_details_id = d.id '+
        'JOIN products AS p ON d.product_id = p.id '+
        'WHERE s.user_id = ?', 
            [id], (err, rows) => {
            if (err) throw err
            cartItemsx = rows
            console.log(cartItemsx)
            //res.render('db3/user/shopping_cart', { cartItems: cartItems, user:req.cookies })
        })
    }
    let cartItems = cartItemsx
    //inserimento ordine
    console.log(cartItems)
    if (!isNaN(cartItems)) {
        connection.query('INSERT INTO orders (transaction, transaction_date, status, payment_status, total_price, user_id, address_id) VALUES (?, ?, ?, ?, ?, ?, ?) ' ,
            ["mastercard", order_date, order_status, "completed", 100, id, 1], (err, rows) => {
                if (err) throw err
                order_id = rows.insertId
                console.log("\ninserimento ordine:")
                console.log(rows)
            
            
        })
        console.log("test vuoto?:")
        console.log(cartItems) //probabilmente è vuoto
        //aggiunta order items
        for (let i = 0; i < cartItems.length; i++) {
            connection.query('INSERT INTO order_items (quantity, price, order_id, product_details_id, size, name, color) VALUES (?, ?, ?,  ?, ?, ?, ?) ',
                [cartItems[i].quantity, cartItems[i].selling_price, order_id, cartItems[i].product_details_id, cartItems[i].size, cartItems[i].name, cartItems[i].color], (err, rows) => {
                console.log("\naggiunta order items:")
                console.log(rows)
                    if (err) throw err
            })
        }
        //Non diminuisce la quantity per poter fare i test

        //svuota carrello
        connection.query('DELETE FROM shopping_cart_item WHERE user_id = ? ', 
            [id], (err, rows) => {
                
                console.log("\nsvuota carrello:")
                console.log(rows)
            if (err) throw err
        })
    }
    res.redirect('/shopping_cart')

    
})



module.exports = appRouter;
