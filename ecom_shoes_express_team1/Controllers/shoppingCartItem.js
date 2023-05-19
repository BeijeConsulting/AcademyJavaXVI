const db = require('../db');


exports.getCartItems = (req, res) => {
    // Extract the user_id from the session
    const userId = req.session.userId;

    // Check if user_id is available
    if (!userId) {
        res.status(400).send('User is not logged in');
        return;
    }

    // Retrieve items from the user's cart in the database
    const getCartItemsQuery = 'SELECT * FROM product_details as details JOIN shopping_cart_item as item ON details.id=item.product_details_id JOIN products as p ON details.product_id=p.id where item.user_id= ?';
    db.query(getCartItemsQuery, [userId], (err, items) => {
        if (err) throw err

        db.query('SELECT SUM(listed_price * item.quantity) as somma FROM shopping_cart_item as item JOIN product_details as details ON item.product_details_id=details.id JOIN products as p ON details.product_id=p.id where item.user_id=?;', [userId], (err, row) => {
            if (err) throw err
            console.log('row', row[0].somma);
            res.render('shopping_cart', { total: row[0].somma, items: items, filter: {} })
        });
    });
};

exports.addItem = (req, res) => {
    // Extract the user_id from the session
    const userId = req.session.userId;
    // Extract item details from the form in the request body
    const { productDetails, quantity } = req.body;

    if (!userId) {
        res.redirect('/login')
        return
    }
    // Check if all necessary details are available
    if (!userId || !productDetails || !quantity) {
        res.status(400).send('Required item details are missing');
        return;
    }

    // Add item to cart in the database
    const addItemQuery = 'INSERT INTO shopping_cart_item (user_id, product_details_id, quantity) VALUES (?,?,?)';
    db.query(addItemQuery, [userId, productDetails, quantity], (err, result) => {
        if (err) {
            console.error(err);
            res.status(500).send('Error adding item to shopping cart');
        } else {
            res.redirect('/cart');
        }
    });
};

exports.updateItem = (req, res) => {
    const userId = req.session.userId;
    const { id } = req.params;
    const { productDetails, quantity } = req.body;

    if (!userId) {
        res.redirect('/login')
        return
    }
    
    console.log('id', id);
    quantity -= 1
    if (quantity >= 1) {
        db.query('UPDATE shopping_cart_item SET quantity = ? WHERE product_details_id = ? AND user_id = ?', [quantity, id, userId], (err, row) => {
            if (err) throw err;
            res.redirect('/cart')
        })
    } else {
        db.query('DELETE FROM shopping_cart_item WHERE product_details_id = ? AND user_id = ?', [id, userId], (err, row) => {
            if (err) throw err;
            res.redirect('/cart')
        })
    }
};