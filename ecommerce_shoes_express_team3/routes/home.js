const express=require('express')
const router=express.Router()
const mysql = require('mysql')
const jwt = require('jsonwebtoken')

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

router.get('/', (req, res, next) => {
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
    type = ''
    if (filter === 'Uomini') {
      type = 'M'
    }
    else {
      type = 'W'
    }
    connection.query('SELECT p.id, img.image_path, p.name, p.description_it FROM product_images AS img, products AS p WHERE img.image_number = 0 AND img.product_id = p.id AND p.type = ?', [type], (err, products) => {
      if (err) {
        console.error(err)
        next(err)
      }
      model.products = products
      res.render('home', model)
    })
  }
  else {
    connection.query('SELECT p.id, img.image_path, p.name, p.description_it FROM product_images AS img, products AS p WHERE img.image_number = 0 AND img.product_id = p.id', (err, products) => {
      if (err) {
        console.error(err)
        next(err)
      }
      model.products = products
      res.render('home', model)
    })
  }
})

module.exports=router;
