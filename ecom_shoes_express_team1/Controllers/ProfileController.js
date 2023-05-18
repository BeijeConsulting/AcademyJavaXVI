const db = require('../db');

// Funzione per formattare la data dd/mm/yyyy
function formatDate(dateString) {
    const date = new Date(dateString);
    const day = date.getDate();
    const month = date.getMonth() + 1;
    const year = date.getFullYear();
  
    return `${day}/${month}/${year}`;
}

exports.profile = (req, res) => {
  const userId = req.session.userId;

  if (!userId) {
    return res.status(401).send('Utente non autenticato.');
  }

  db.query('SELECT * FROM users WHERE id = ?', [userId], (error, results) => {
    if (error) {
      console.error('Errore durante il recupero del profilo dell\'utente:', error);
      return res.status(500).send('Si è verificato un errore durante il recupero del profilo dell\'utente.');
    }

    if (results.length === 0) {
      return res.status(404).send('Utente non trovato.');
    }

    const user = results[0];
    user.birthDateFormatted = formatDate(user.birth_date);
    res.render('profile', { user });
  });
};

exports.logout = (req, res) => {
    req.session.destroy();
    res.redirect('/login');
};

exports.editProfile = (req, res) => {
    const userId = req.session.userId;
  
    if (!userId) {
      return res.status(401).send('Utente non autenticato.');
    }
  
    db.query('SELECT * FROM users WHERE id = ?', [userId], (error, results) => {
        if (error) {
            console.error('Errore durante il recupero del profilo dell\'utente:', error);
            return res.status(500).send('Si è verificato un errore durante il recupero del profilo dell\'utente.');
        }

        if (results.length === 0) {
            return res.status(404).send('Utente non trovato.');
        }

        const user = results[0];
        const birthDateFormatted = formatDate(user.birth_date);
        res.render('editProfile', { user, birthDateFormatted });
    });
};

exports.updateProfile = (req, res) => {
    const userId = req.session.userId;
    const { name, surname, birth_date, email, telephone } = req.body;
  
    if (!userId) {
      return res.status(401).send('Utente non autenticato.');
    }
  
    const [day, month, year] = birth_date.split('/');
    const birthDateFormatted = `${year}-${month}-${day}`;

  
    db.query('UPDATE users SET name = ?, surname = ?, birth_date = ?, email = ?, telephone = ? WHERE id = ?', [name, surname, birthDateFormatted, email, telephone, userId], (error, results) => {
        if (error) {
            console.error('Errore durante l\'aggiornamento del profilo dell\'utente:', error);
            return res.status(500).send('Si è verificato un errore durante l\'aggiornamento del profilo dell\'utente.');
        }

    // Reindirizza l'utente alla pagina del profilo dopo l'aggiornamento
        res.redirect('/profile');
    });
};