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
  res.render('register')
})

router.post('/', (req, res, next) => {
  let name = req.body.name
  let surname = req.body.surname
  let telephone = req.body.telephone
  let birthdate = req.body.birthdate
  let email = req.body.email
  let password = req.body.password
  let query = 'INSERT INTO users (name, surname, email, password, telephone, birth_date) VALUES (?, ?, ?, ?, ?, ?)'
  connection.query(query, [name, surname, email, password, telephone, birthdate], function(err, rows) {
    if (err) {
      console.error(err)
      next(err)
    }
    else {
      res.cookie('session', generateAccessToken(rows.insertId));
      res.redirect('/')
    }
  })
})

module.exports=router;
