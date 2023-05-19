const express = require('express')
const mysql = require('mysql')
const appRouter = express.Router()
const cookieParser = require('cookie-parser')

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

// PAGINA UTENTE
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

appRouter.get('/edit_user', (req, res) => {
    let id = parseInt(req.cookies.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT * FROM users WHERE id = ?', [id], (err, rows) => {
            if (err) throw err
            console.log(rows)
            let dataF =  rows[0].birth_date.getDate() + "/" +  rows[0].birth_date.getMonth() +"/" +rows[0].birth_date.getFullYear()
            console.log(dataF.query)
            rows[0].birth_date = new Date(dataF)
            console.log(rows[0].birth_date)
            res.render('db3/user/edit_user', { user: rows[0] })
        })
    }
})

appRouter.post('/edit_user', (req, res) => {
    console.log("Edit -> ", req.body)

    let user_id = parseInt(req.cookies.id)
    let name = req.body.name
    let surname = req.body.surname
    let email = req.body.email
    let password = req.body.password
    let telephone = req.body.telephone

    connection.query('UPDATE users ' +
    'SET name = ?, surname = ?, email = ?, password = ?, telephone = ? ' +
    'WHERE id = ?',
    [name, surname, email, password, telephone, user_id], (err, rows) => {
        if (err) throw err
        res.redirect('/user')
    })
})

// ORDINI UTENTE
appRouter.get('/my_orders', (req, res) => {

    let id = parseInt(req.cookies.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT o.*, a.label, a.street_address FROM ecommerce_shoes_2.orders AS o JOIN ecommerce_shoes_2.addresses AS a ON o.address_id = a.id WHERE o.user_id = ?', [id], (err, rows) => {
            if (err) throw err
            let orders = rows
            res.render('db3/user/my_order', { orders: orders, user: req.cookies })
        })
    }
})

appRouter.get('/order_details/:id', (req, res) => {
    let id = parseInt(req.cookies.id)
    let order = parseInt(req.params.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT * FROM order_items WHERE order_id = ?', [order], (err, rows) => {
            if (err) throw err
            let details = rows

            if (details.length > 0) {
                res.render('db3/user/order_detail', { items: details, user: req.cookies })
            } else {
                res.redirect('/user//my_orders')
            }

        })
    }
})

// INDIRIZZI UTENTE
appRouter.get('/my_addresses', (req, res) => {
    let id = parseInt(req.cookies.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT * FROM addresses WHERE user_id = ? AND disabled_at IS NULL', [id], (err, rows) => {
            if (err) throw err
            let addresses = rows
            res.render('db3/user/addresses', { addresses: addresses })
        })
    }
})

appRouter.get('/my_addresses/add_address', (req, res) => {
    let id = parseInt(req.cookies.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        res.render('db3/user/add_address')
    }
})

appRouter.post('/my_addresses/add_address', (req, res) => {

    let user_id = parseInt(req.cookies.id)
    let label = req.body.label
    let name_surname = req.body.name_surname
    let country = req.body.country
    let street_address = req.body.street_address
    let telephone = req.body.telephone
    let zipcode = req.body.zipcode
    let instructions = req.body.instructions
    
    
    connection.query('INSERT INTO addresses '+
    '(label, name_surname, country, street_address, telephone, zipcode, instructions, user_id) '+
    'VALUES (?, ?, ?, ?, ?, ?, ?, ?)', 
    [label, name_surname, country, street_address, telephone, zipcode, instructions, user_id], (err, rows) => {
        if (err) throw err
        res.redirect('/user/my_addresses')
    })
})

appRouter.get('/my_addresses/edit_address/:id', (req, res) => {

    let id = parseInt(req.cookies.id)
    let address_id = parseInt(req.params.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT * FROM addresses WHERE id = ? AND disabled_at IS NULL', [address_id], (err, rows) => {
            if (err) throw err
            if (rows.length > 0) {
                let address = rows[0]
                res.render('db3/user/edit_address', { address: address })
            } else {
                res.redirect('/user/my_addresses')
            }
        })
    }

})

appRouter.post('/my_addresses/edit_address/:id', (req, res) => {

    let address_id = req.params.id
    let label = req.body.label
    let name_surname = req.body.name_surname
    let country = req.body.country
    let street_address = req.body.street_address
    let telephone = req.body.telephone
    let zipcode = req.body.zipcode
    let instructions = req.body.instructions
    let user_id = req.body.user_id

    connection.query('UPDATE addresses ' +
        'SET label = ?, name_surname = ?, country = ?, street_address = ?, '+
        'telephone = ?, zipcode = ?, instructions = ? ' +
        'WHERE id = ? AND user_id = ?',
        [label, name_surname, country, street_address, telephone, zipcode, instructions, address_id, user_id], (err, rows) => {
            if (err) throw err
            res.redirect('/user/my_addresses')
        })
})

appRouter.get('/my_addresses/delete_address/:id', (req, res) => {

    let id = parseInt(req.cookies.id)
    let address_id = parseInt(req.params.id)

    if (isNaN(id)) {
        res.redirect('/signin')
    } else {
        connection.query('SELECT * FROM addresses WHERE id = ? AND disabled_at IS NULL', [address_id], (err, rows) => {
            if (err) throw err
            if (rows.length > 0) {
                let address = rows[0]
                res.render('db3/user/delete_address', { address: address })
            } else {
                res.redirect('/user/my_addresses')
            }
        })
    }

})

appRouter.post('/my_addresses/delete_address/:id', (req, res) => {

    let address_id = req.params.id
    let d = new Date
    
    connection.query('UPDATE addresses ' +
        'SET disabled_at = ? '+
        'WHERE id = ?',
        [d, address_id], (err, rows) => {
            if (err) throw err
            res.redirect('/user/my_addresses')
        })
})

module.exports = appRouter;