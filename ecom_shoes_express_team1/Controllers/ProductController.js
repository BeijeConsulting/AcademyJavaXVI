const db = require('../db');

exports.getAllProducts = (req, res) => {
  db.query('SELECT * FROM products', (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving products from database');
    } else {
      console.log('rows: ', result)
      res.render('product', { products: result })
      //res.send(result);
    }
  });
};

exports.getProductById = (req, res) => {
  const { id } = req.params;
  const query = 'SELECT * FROM products WHERE id = ?';

  db.query(query, [id], (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error retrieving product from database');
    } else {
      res.render('productDetails', {product: result[0]});
    }
  });
};

exports.createProduct = (req, res) => {
  const { name, description, price } = req.body;
  const query = 'INSERT INTO products (name, description, price) VALUES (?, ?, ?)';
  const values = [name, description, price];

  db.query(query, values, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error creating product');
    } else {
      res.send('Product created successfully');
    }
  });
};

exports.updateProduct = (req, res) => {
  const { id } = req.params;
  const { name, description, price } = req.body;
  const query = 'UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?';
  const values = [name, description, price, id];

  db.query(query, values, (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error updating product');
    } else {
      res.send('Product updated successfully');
    }
  });
};

exports.deleteProduct = (req, res) => {
  const { id } = req.params;
  const query = 'DELETE FROM products WHERE id = ?';

  db.query(query, [id], (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error deleting product');
    } else {
      res.send('Product deleted successfully');
    }
  });
};
