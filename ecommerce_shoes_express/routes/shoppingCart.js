const express=require('express')
const router=express.Router()
const mysql = require('mysql')

const connection = mysql.createConnection({
    host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
    user: 'admin',
    password: 'FJf7MWgOsW1M5AbKql9g',
    database: 'ecommerce_shoes_4'
  })

  router.use(express.urlencoded({
    extended: true
  }))



 router.get('/shoppingcart', (req, res) => {

    let user = req.cookies.user
  
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    const id = user.id
    
    connection.query('SELECT * FROM product_details as details JOIN shopping_cart_item as item ON details.id=item.product_details_id JOIN products as p ON details.product_id=p.id where item.user_id= ?',[id], (err, items) => {
        if (err) throw err
        //console.log('rows',items);
        
        connection.query('SELECT SUM(listed_price * item.quantity) as somma FROM shopping_cart_item as item JOIN product_details as details ON item.product_details_id=details.id JOIN products as p ON details.product_id=p.id where item.user_id=?;',[id], (err, row)=> {
          if (err) throw err
          res.render('shopping_cart', {  total: row[0].somma, items:items,user:user, filter:{}})
      });
    });
  })
  
 router.post('/details/addItem' , (req,res) =>{
    console.log('addItem POST');
    let user = req.cookies.user
    const { productDetails, quantity } = req.body;
  
    if (typeof user === 'undefined'){
      res.redirect('/login')
      return
    }else{
      connection.query('INSERT INTO shopping_cart_item (user_id, product_details_id, quantity) VALUES (?,?,?)',[user[0].id, parseInt(productDetails), parseInt(quantity)], (err) => {
        if(err) throw err
        res.redirect('/shoppingcart')
      })
     } 
  })


  router.get('/delete/:id/:quantity',(req, res) =>{
    let user = req.cookies.user
    console.log("GET /delete/id/quantity");
    const id = req.params.id
    console.log('id', id);
    let quantity = req.params.quantity
    console.log(quantity);
    quantity -= 1
    console.log(quantity);
    console.log(user[0].id);
    if (quantity >= 1) {
      connection.query('UPDATE shopping_cart_item SET quantity = ? WHERE product_details_id = ? AND user_id = ?',[quantity,id, user[0].id], (err, row)=> {
        if(err) throw err;
        console.log(row);
        res.redirect('/shoppingcart')
      })
    }else{
      connection.query('DELETE FROM shopping_cart_item WHERE product_details_id = ? AND user_id = ?',[id, user[0].id], (err, row)=> {
        if(err) throw err;
        console.log(row);
        res.redirect('/shoppingcart')
      })
    }
  
  }) 



  module.exports=router;