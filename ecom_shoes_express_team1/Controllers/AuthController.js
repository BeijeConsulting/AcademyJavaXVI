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
  
      const user = results[0];
  
      req.session.userId = user.id; 
  
      res.redirect('/profile'); 
    });
};