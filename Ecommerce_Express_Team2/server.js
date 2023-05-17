const express = require('express')
const mysql = require('mysql')

const app = express()
app.use(express.json())
app.use(express.urlencoded({ extended: true }))

//
const port = 3000
const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_2'
})

app.set('view engine', 'ejs')

app.get('/users', (req, res) => {

    //connection.connect()
    
    connection.query('SELECT * FROM users', (err, rows) => {
        if (err) throw err
        console.log('rows: ', rows)
        //res.render('contacts', { contacts: rows })
    })

    console.log('end connection...')
    //connection.end()
    
  })
  app.get('/user', (req, res) => {

    //connection.connect()
    let id = parseInt(req.query.id);
    console.log('id: ', id)
    connection.query('SELECT * FROM users WHERE id = ?', [id], (err, rows) => {
        if (err) throw err
        console.log('rows: ', rows)
        //res.render('contacts', { contacts: rows })
    })
    console.log('end connection...')
    //connection.end()
    
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

  app.post('/login', (req, res) => {
    console.log(req.body)
    let password = req.body.password;
    let email = req.body.email;
    connection.query('SELECT * FROM users WHERE email = ? AND password = ?', [email, password], (err, rows) => {
        if (err) throw err
        console.log('rows: ', rows)
        //res.render('contacts', { contacts: rows })
    })
   
  })

  app.get('/products', (req, res) => {
    connection.query('SELECT * FROM products', (err, rows) => {
        if (err) throw err
        console.log('rows: ', rows)
        let products = rows;
        res.render('db3/index', { products: products })
        //res.render('contacts', { contacts: rows })
    })
   
  })
//app.get('/addresses', (req, res) => {
//    console.log('end connection...')
//    //connection.end()
//}

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})