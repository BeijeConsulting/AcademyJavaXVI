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


const homeRoute = require('./routes/home')
const productRoute = require('./routes/products')
const shoppingCartRoute = require('./routes/shoppingCart')
const orderRoute = require('./routes/order')
const loginRoute = require('./routes/login')
const checkoutRoute = require('./routes/checkout')


 app.use('/', homeRoute)
 app.use('/', productRoute)
 app.use('/', shoppingCartRoute)
 app.use('/', orderRoute)
 app.use('/', loginRoute)
 app.use('/', checkoutRoute)


// function addOrder(totalCheckout,userId,address_id) {
//   return new Promise((resolve) => {
//     console.log(totalCheckout,parseInt(userId),address_id);
//     connection.query(`INSERT INTO orders(transaction,transaction_date,payment_status,status,total_price,created_at,disabled_at,user_id,address_id,coupon_id) values("12345",null,"Pagato","completed",?,localtime(),null,?,?,null)`,[(parseInt(totalCheckout), parseInt(userId),address_id)], (err, order) => {
//       if(err) throw err
//       resolve(order);
//     });
//   });
// }

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})