const express = require('express');
const router = express.Router();
const cartController = require('../Controllers/shoppingCartItem');

// Route to get all products
router.get('/', productController.getAllProducts);

//Route to get product details by ID
router.get('/:id', productDetails.getProductDetailsById);

// Route to get a product by its ID
router.get('/:id', productController.getProductById);

// Route to create a new product
router.post('/', productController.createProduct);

// Route to update a product
router.put('/:id', productController.updateProduct);

// Route to delete a product
router.delete('/:id', productController.deleteProduct);

module.exports = router;