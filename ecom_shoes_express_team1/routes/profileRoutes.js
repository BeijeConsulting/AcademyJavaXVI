const express = require('express');
const router = express.Router();
const profileController = require('../Controllers/ProfileController');

router.get('/', profileController.profile);

module.exports = router;