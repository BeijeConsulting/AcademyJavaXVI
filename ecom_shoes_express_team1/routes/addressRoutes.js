const express = require('express');
const router = express.Router();
const addressController = require('../Controllers/AddressController');

router.get('/', addressController.address);
router.post('/delete/:id', addressController.deleteAddress);

module.exports = router;