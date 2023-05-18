const express = require('express')
const app = express()
const port = 3000
const mysql = require('mysql')
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
app.use(cookieParser());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.set('view engine', 'ejs')

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_4'
})

app.get('/', (req, res) => {

  let user = req.cookies.user
  let type = req.query.type;
  
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

app.get('/', (req, res) => {
  const user = req.cookies.user
  connection.query('SELECT * FROM products where is_listed = 1', (err, rows) => {
    if (err) throw err
    res.render('index', { products: rows , user:user[0], filter:{}})
  })

})

app.get('/details/:id', (req, res) => {
  const id = req.params.id
  connection.query('SELECT * FROM products as p join product_details as pd on p.id=pd.product_id  where p.id = ?',[id], (err, rows) => {
      if (err) throw err
      res.render('product_details', {  details: rows, user:{}, filter:{}})    
  })

})

app.get('/shoppingcart/:id', (req, res) => {
  const id = req.params.id
  connection.query('SELECT * FROM shopping_cart_item as item JOIN product_details as details ON item.product_details_id=details.id JOIN products as p ON details.product_id=p.id where item.user_id= ?',[id], (err, rows) => {
      if (err) throw err
      console.log('rows',rows);
      res.render('shopping_cart', {  items: rows, user:{}, filter:{}})
  
    
  })

})

app.get('/orders/:id', (req, res) => {
  const id = req.params.id
  connection.query('SELECT * FROM order_items as o where o.user_id= ?',[id], (err, rows) => {
      if (err) throw err
      console.log('rows',rows);
      res.render('orders', {  orders: rows, user:{}, filter:{}})
  
    
  })

})


app.get('/login', (req, res) => {
  res.render('login')
});


app.post('/login', (req, res) => {
  const { email, password } = req.body;
  connection.query('SELECT * FROM users  where email = ? AND password = ?',[email, password], (err, user) => {
    if (user.length > 0) {
      res.cookie('user', user, { maxAge: 900000, httpOnly: true });
      res.redirect('/');
    }else{
      res.send('Credenziali errate');
    }
  })
});



app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})