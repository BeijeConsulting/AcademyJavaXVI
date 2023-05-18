const express = require('express')
const app = express()
const port = 3000
const mysql = require('mysql')
app.set('view engine', 'ejs')

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_4'
})


app.get('/', (req, res) => {
  connection.query('SELECT * FROM products limit 3', (err, rows) => {
    if (err) throw err
    console.log('The solution is: ', rows)
    res.render('products', { products: rows })
  })

})

app.get('/index', (req, res) => {
  connection.query('SELECT * FROM products where is_listed = 1', (err, rows) => {
    if (err) throw err
    
    res.render('index', { products: rows , user:{}, filter:{}})
  })

})

app.get('/details/:id', (req, res) => {
  const id = req.params.id
  connection.query('SELECT * FROM products as p join product_details as pd on p.id=pd.product_id  where p.id = ?',[id], (err, rows) => {
      if (err) throw err
      console.log('rows',rows);
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
  connection.query('SELECT * FROM order_items as item JOIN orders as o ON item.order_id=o.id where o.user_id= ?',[id], (err, rows) => {
      if (err) throw err
      console.log('rows',rows);
      res.render('orders', {  orders: rows, user:{}, filter:{}})
  
    
  })

})


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})