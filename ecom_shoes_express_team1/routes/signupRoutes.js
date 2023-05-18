const express = require('express');
const router = express.Router();
const signupController = require('../Controllers/SignupController');

router.get('/', signupController.signup);
router.post('/', signupController.signupResult);


module.exports = router;