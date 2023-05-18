const db = require('../db');

exports.address = (req, res) => {
    const userId = req.session.userId;
  
    db.query('SELECT * FROM addresses WHERE user_id = ?', [userId], (err, result) => {
        if (err) {
            console.error(err);
            res.status(500).send('Errore nel recupero dei dati dal database');
        } else {
            res.render('address', { addresses: result });
        }
    });
};

exports.deleteAddress = (req, res) => {
    const addressId = req.params.id;
  
    db.query('DELETE FROM addresses WHERE id = ?', [addressId], (err, result) => {
      if (err) {
        console.error(err);
        res.status(500).send('Errore durante l\'eliminazione dell\'indirizzo.');
      } else {
        res.redirect('/address');
      }
    });
};