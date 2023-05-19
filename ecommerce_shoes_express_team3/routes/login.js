const express=require('express')
const router=express.Router()
const mysql = require('mysql')
const jwt = require('jsonwebtoken')

//per accedere al token secret:
// process.env.KEY;

function generateAccessToken(id) {
  return jwt.sign({user_id: id}, process.env.KEY, { expiresIn: '1800s' });
}

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3'
})

router.use(express.urlencoded({
  extended: true
}))

router.get('/', (req, res) => {
  res.render('login', {error: 'no'})
})

router.post('/', (req, res, next) => {
  let email = req.body.email
  let password = req.body.password
  let query = 'SELECT * FROM users WHERE email = ? AND password = ?'
  connection.query(query, [email, password], function(err, rows) {
    if (err) {
      console.error(err)
      next(err)
    }
    if (rows.length == 1) {
      res.cookie('session', generateAccessToken(rows[0].id));
      res.redirect('/')
    }
    else {
      res.render('login', {error: 'yes'})
    }
  })
})

module.exports=router;
