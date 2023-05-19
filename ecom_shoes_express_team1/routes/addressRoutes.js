const express = require('express');
const router = express.Router();
const addressController = require('../Controllers/AddressController');

router.get('/', addressController.address);
router.post('/delete/:id', addressController.deleteAddress);
router.get('/edit/:id', addressController.showUpdateForm);
router.post('/update/:id', addressController.updateAddress);
router.get('/create', addressController.createForm);
router.post('/create', addressController.createAddress);


module.exports = router;