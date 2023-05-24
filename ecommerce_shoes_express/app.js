const express = require('express')
const app = express()
const port = 3000
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const dotenv = require('dotenv')

dotenv.config()


app.use(cookieParser());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.set('view engine', 'ejs')


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

 
 const homeRouteApi = require('./api/home')
 const productRouteApi = require('./api/products')
 const shoppingCartRouteApi = require('./api/shoppingCart')
 const orderRouteApi = require('./api/order')
const loginRouteApi = require('./api/login')
const checkoutRouteApi = require('./api/checkout')

/*
Manca : Qualcosa login - POST Checkout
*/
 app.use('/api', homeRouteApi)
 app.use('/api', productRouteApi)
 app.use('/api', shoppingCartRouteApi)
 app.use('/api', orderRouteApi)
 app.use('/api', loginRouteApi)
 app.use('/api', checkoutRouteApi)

 const cb0 = function (req, res, next) {
  console.log('CB0')
  next()
}

const cb1 = function (req, res, next) {
  console.log('CB1')
  next()
}

app.get('/example/d', [cb0, cb1], (req, res, next) => {
  console.log('the response will be sent by the next function ...')
  next()
}, (req, res) => {
  res.send('Hello from D!')
})


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