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
  res.render('db3/signin')
})

app.post('/signin', (req, res) => {
  let password = req.body.password;
  let email = req.body.email;
  connection.query('SELECT * FROM users WHERE email = ? AND password = ?', [email, password], (err, rows) => {
    if (err) throw err
    res.cookie('id', parseInt(rows[0].id), { maxAge: 900000, httpOnly: true });
    res.redirect('/user')
  }) //sistemare credenziali errate

})


app.get('/users', (req, res) => {

  connection.query('SELECT * FROM users', (err, rows) => {
    if (err) throw err
    console.log('rows: ', rows)
  })

})


app.get('/user', (req, res) => {
  let id = parseInt(req.cookies.id)

  connection.query('SELECT * FROM users WHERE id = ?', [id], (err, rows) => {
    if (err) throw err
    res.render('db3/user/user_page', { user: rows[0] })
  })

})

app.post('/signup', (req, res) => {
  let password = req.body.password;
  let email = req.body.email;
  let name = req.body.name;
  let telephone = req.body.telephone;
  let birth_date = req.body.birthdate;
  let surname = req.body.surname;
  connection.query('INSERT INTO users (name, surname, email, password, telephone, birth_date) VALUES (?, ?, ?, ?, ?, ?)', [name, surname, email, password, telephone, birth_date], (err, rows) => {
    if (err) throw err
    console.log('rows: ', rows)
    //res.render('contacts', { contacts: rows })
  })

})

app.get('/products', (req, res) => {
  connection.query('SELECT * FROM products', (err, rows) => {
    if (err) throw err
    //console.log('rows: ', rows)
    let products = rows;
    res.render('db3/index', { products: products })
    //res.render('contacts', { contacts: rows })
  })

})

// LISTEN
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})