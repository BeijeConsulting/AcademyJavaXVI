const express = require('express');
const session = require('express-session');
const bodyParser = require('body-parser');
const productRoutes = require('./routes/productRoutes');
const authRoutes = require('./routes/authRoutes');
const signupRoutes = require('./routes/signupRoutes');
const cartRoutes = require('./routes/cartRoutes');
const profileRoutes = require('./routes/profileRoutes');
const addressRoutes = require('./routes/addressRoutes');

const app = express();
const port = process.env.PORT || 3000;

// Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Static files
app.use(express.static('public'));

// View engine setup
app.set('view engine', 'ejs');

// Session middleware
app.use(session({
    secret: 'root',
    resave: false,
    saveUninitialized: false
}));

// Routes
app.use('/products', productRoutes);
app.use('/login', authRoutes);
app.use('/signup', signupRoutes);
app.use('/cart', cartRoutes);
app.use('/profile', profileRoutes);
app.use('/address', addressRoutes);

// Home route
app.get('/', (req, res) => {
    res.render('index');
});

// Starting the server
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
