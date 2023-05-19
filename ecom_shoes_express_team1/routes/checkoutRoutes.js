
const express = require('express');
const router = express.Router();
const checkoutController = require('../Controllers/checkoutController');


router.get('/', checkoutController.getCheckout);

router.post('/', checkoutController.postCheckout);

module.exports = router;