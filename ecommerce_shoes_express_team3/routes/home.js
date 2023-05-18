const express=require('express')
const router=express.Router()
const mysql = require('mysql')
const jwt = require('jsonwebtoken')
const dotenv = require('dotenv')

dotenv.config()

//per accedere al token secret:
// process.env.KEY;

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
  let token = req.cookies.session
  let model = {}
  if (token !== undefined){
    jwt.verify(token, process.env.KEY, function(err, decoded) {
      if (!err) {
        model.user = decoded.user_id
      }
    })
  }
  filter = req.query.type;
  if (filter !== undefined && (filter === 'Uomini' || filter === 'Donne')) {
    model.filter = filter
  }
  res.render('home', model)//, {error: 'no'})
})

module.exports=router;
