const db = require('../db');

exports.getCheckout = (req, res) => {
    const { id } = req.params;

    if (typeof user === 'undefined') {
     user = {}
    }else{
      user = user[0]
    }
    connection.query('SELECT * FROM addresses as a where a.user_id= ?',[id], (err, rows) => {
        if (err) throw err
        res.render('checkout', {  addresses: rows, user:user, filter:{}})
    
      
    })
};
exports.postCheckout = async (req, res) => {
    //console.log(req.body);
    let user = req.cookies.user
    const name = req.body.name;
    const label = req.body.label;
    const country = req.body.country;
    const street = req.body.street;

    if (typeof user === 'undefined') {
        user = {}
    } else {
        user = user[0]
    }
    const userId = user.id;
    const telephone = user.telephone;
    let address_id;


    if (req.body.name === '') {
        address_id = req.body.addresses;
    } else {
        address_id = await addAddress(name, label, country, street, telephone, userId)
        address_id = address_id.insertId
    }

    let totalCheckout = await getTotalCheckout(userId);
    totalCheckout = totalCheckout[0].somma

    db.query('INSERT INTO orders(transaction,transaction_date,payment_status,status,total_price,created_at,disabled_at,user_id,address_id,coupon_id) values("12345",null,"Pagato","completed",?,localtime(),null,?,?,null)', [totalCheckout, userId, address_id], (err, order) => {
        if (err) throw err
        console.log('order', order);
        connection.query(`delete from shopping_cart_item WHERE user_id=?`, [userId], (err) => {
            if (err) throw err
        })
    })
    // })

    res.redirect('/checkout');
};
function addAddress(name,label,country,street,telephone,id) {
    return new Promise((resolve) => {
      db.query('INSERT INTO addresses(created_at,disabled_at,label,name_surname,country,street_address,telephone,zipcode,instructions,user_id) VALUES (localtime(),null,?,?,?,?,?,0000,null,?)',[name,label,country,street,telephone,id],(err, rows) => {
        if (err)  throw err;
        resolve(rows);
      });
    });
  }
  
  function getTotalCheckout(userId) {
    return new Promise((resolve) => {
      db.query('SELECT SUM(listed_price * item.quantity) as somma FROM shopping_cart_item as item JOIN product_details as details ON item.product_details_id=details.id JOIN products as p ON details.product_id=p.id where item.user_id=?',[userId], (err, sum) => {
        if (err)  throw err;
        resolve(sum);
      });
    });
  }