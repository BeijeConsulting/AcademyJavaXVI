const db = require('../db');

exports.login = (req, res) => {

    res.render("login", {test: null});


}


exports.loginResult = (req, res) => {
    const { email, password } = req.body;
  
    db.query('SELECT * FROM users WHERE email = ? AND password = ?', [email, password], (error, results) => {
        if (error) {
            console.error('Errore durante la verifica delle credenziali:', error);
            return res.status(500).send('Si è verificato un errore durante la verifica delle credenziali.');
        }

        if (results.length === 0) {
            return res.render('login', { test: 'Credenziali non valide. Riprova.' });
        }

        res.redirect('products');
    });
};

exports.signup = (req, res) => {
    res.render("signup");
}

exports.signupResult = (req, res) => {
    const { name, surname, birthDate, email, password } = req.body;
    
    db.query('INSERT INTO users (name, surname, birth_date, email, password) VALUES (?, ?, ?, ?, ?)', [name, surname, birthDate, email, password], (error, results) => {
        if (error) {
            console.error('Errore durante la registrazione:', error);
            return res.status(500).send('Si è verificato un errore durante la registrazione.');
        }

        res.redirect('/login');
    });
};