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


router.get('/checkout', (req, res) => {

    let user = req.cookies.user
  
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    const id = user.id
    connection.query('SELECT * FROM addresses as a where a.user_id= ?',[id], (err, rows) => {
        if (err) throw err
       res.json({  addresses: rows, user:user, filter:{}})
      //  res.render('checkout', {  addresses: rows, user:user, filter:{}})
    
      
    })
  
  })
  
  router.post('/checkout', async(req, res) => {
    //console.log(req.body);
    let user = req.cookies.user
    const name=req.body.name;
    const label=req.body.label;
    const country=req.body.country;
    const street=req.body.street;
    
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    const userId = user.id;
    const telephone=user.telephone;
    let address_id;
    
  
    if( req.body.name ===  ''){
      console.log("VUOTOs");
      address_id=req.body.addresses;
    } else{
      address_id= await addAddress(name,label,country,street,telephone,userId)
      address_id = address_id.insertId
    }  
    
    let totalCheckout = await getTotalCheckout(userId);
    totalCheckout = totalCheckout[0].somma
  
    connection.query('INSERT INTO orders(transaction,transaction_date,payment_status,status,total_price,created_at,disabled_at,user_id,address_id,coupon_id) values("12345",null,"Pagato","completed",?,localtime(),null,?,?,null)',[totalCheckout,userId,address_id], (err, order) => {
          if (err) throw err
          console.log('order',order); 
      connection.query(`delete from shopping_cart_item WHERE user_id=?`, [userId] ,(err) =>{
        if (err) throw err
      })
       })
  
       
    res.redirect('/checkout');
  })

router.get('/profile', async (req, res) => {
    let user = req.cookies.user
  
    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    let address = await getAddress(user.id);
    console.log(address);
    res.json({user:user, addresses:address})
   // res.render('user', {user:user, addresses:address})
  });
  

  function getAddress(userId) {
    return new Promise((resolve) => {
      connection.query('SELECT * from addresses where user_id = ?',[userId], (err, sum) => {
        if (err)  throw err;
        resolve(sum);
      });
    });
  }
  
  function addAddress(name,label,country,street,telephone,id) {
    return new Promise((resolve) => {
      connection.query('INSERT INTO addresses(created_at,disabled_at,label,name_surname,country,street_address,telephone,zipcode,instructions,user_id) VALUES (localtime(),null,?,?,?,?,?,0000,null,?)',[name,label,country,street,telephone,id],(err, rows) => {
        if (err)  throw err;
        resolve(rows);
      });
    });
  }
  
  function getTotalCheckout(userId) {
    return new Promise((resolve) => {
      connection.query('SELECT SUM(listed_price * item.quantity) as somma FROM shopping_cart_item as item JOIN product_details as details ON item.product_details_id=details.id JOIN products as p ON details.product_id=p.id where item.user_id=?',[userId], (err, sum) => {
        if (err)  throw err;
        resolve(sum);
      });
    });
  }

  
  module.exports=router;