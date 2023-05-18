const db = require('../db');

exports.getProductDetailsById = (req, res) => {
    const { id } = req.params;
    const query = 'SELECT * FROM products_details WHERE id = ?';
  
    db.query(query, [id], (err, result) => {
      if (err) {
        console.error(err);
        res.status(500).send('Error retrieving product from database');
      } else {
        res.render('productDetails', {product: result[0]});
      }
    });
  };