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


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})