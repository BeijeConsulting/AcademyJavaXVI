const express = require('express')
const mysql = require('mysql')
const app = express()
const cookieParser = require('cookie-parser');

// DATABASE
const port = 3000
const connection = mysql.createConnection({
    host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
    user: 'admin',
    password: 'FJf7MWgOsW1M5AbKql9g',
    database: 'ecommerce_shoes_2'
})

app.use(cookieParser());
app.use(express.json())
app.use(express.urlencoded({ extended: true }))

app.set('view engine', 'ejs')

// SIGN IN
app.get('/signin', (req, res) => {
    res.render('db3/signin', { message: null })
})

app.post('/signin', (req, res) => {
    let password = req.body.password;
    let email = req.body.email;
    connection.query('SELECT * FROM users WHERE email = ? AND password = ?', [email, password], (err, rows) => {
        if (err) throw err
        if (rows.length > 0) {
            res.cookie('id', parseInt(rows[0].id), { maxAge: 90000, httpOnly: true });
            res.redirect('/user')
        } else {
            res.render('db3/signin', { message: "Credenziali errate!" })
        }

    })

})


// SIGN UP
app.get('/signup', (req, res) => {
    res.render('db3/signup')
})

app.post('/signup', (req, res) => {
    let name = req.body.name;
    let surname = req.body.surname;
    let email = req.body.email;
    let password = req.body.password;
    let telephone = req.body.telephone;
    let birth_date = req.body.birthdate;

    connection.query('INSERT INTO users (name, surname, email, password, telephone, birth_date) VALUES (?, ?, ?, ?, ?, ?)', [name, surname, email, password, telephone, birth_date], (err, rows) => {
        if (err) throw err
        res.cookie('id', parseInt(rows.insertId), { maxAge: 9000000, httpOnly: true });
        res.redirect('/user')
    })

})

//SIGN OUT
app.get('/signout', (req,res) =>{
    console.log("Signout")
})

//ROUTER
const userRouting = require('./routing/user')
const productRouting = require('./routing/product')
const shoppingCartRouting = require('./routing/shopping_cart')

app.use('/user', userRouting)
app.use('/product', productRouting)
app.use('/shopping_cart', shoppingCartRouting)

// LISTEN
app.listen(port, () => {
    console.log(`Db3 app listening on port ${port}`)
})