const express = require('express');
const router = express.Router();
const profileController = require('../Controllers/ProfileController');

router.get('/', profileController.profile);

router.post('/logout', profileController.logout);

module.exports = router;