const express = require('express');
const router = express.Router();
const authController = require('../Controllers/AuthController');

router.get('/', authController.login);
router.post('/', authController.loginResult);

module.exports = router;