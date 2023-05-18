const db = require('../db');

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