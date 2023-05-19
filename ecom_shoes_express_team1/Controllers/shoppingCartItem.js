const db = require('../db');
exports.addItem = (req, res) => {
    // Extract the user_id from the session
    const userId = req.session.user_id;

    // Extract item details from the form in the request body
    const { productDetails, quantity } = req.body;

    // Check if all necessary details are available
    if(!userId || !productDetails || !quantity) {
        res.status(400).send('Required item details are missing');
        return;
    }

    // Add item to cart in the database
    const addItemQuery = 'INSERT INTO shopping_cart_items (user_id, product_details_id, quantity) VALUES (?, ?, ?)';
    db.query(addItemQuery, [userId, productDetails, quantity], (err, result) => {
        if (err) {
            console.error(err);
            res.status(500).send('Error adding item to shopping cart');
        } else {
            res.redirect('/cart');
        }
    });
};