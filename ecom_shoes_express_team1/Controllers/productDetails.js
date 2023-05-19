const db = require('../db');

exports.getProductDetailsById = (req, res) => {
  const { id } = req.params;
  const productQuery = 'SELECT * FROM products WHERE id = ?';

  db.query(productQuery, [id], (err, productResults) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving product from database');
    } else {
      const product = productResults[0];
      const productDetailsQuery = 'SELECT * FROM product_details WHERE product_id = ?';

      db.query(productDetailsQuery, [id], (err, productDetailsResults) => {
        if (err) {
          console.error(err);
          res.status(500).send('Error retrieving product details from database');
        } else {
          product.productDetails = productDetailsResults;
          res.render('productDetails', {product: product});
        }
      });
    }
  });
};