const express = require('express');
const router = express.Router();
const cartController = require('../Controllers/shoppingCartItem');

//Route to get all cartItem
router.get('/', cartController.getCartItems);

// Route to create a new cartItem
router.post('/', cartController.addItem);

module.exports = router;