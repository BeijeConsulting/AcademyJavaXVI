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

exports.showUpdateForm = (req, res) => {
  const addressId = req.params.id;

  db.query('SELECT * FROM addresses WHERE id = ?', [addressId], (err, result) => {
      if (err) {
          console.error(err);
          res.status(500).send('Errore nel recupero dei dati dal database');
      } else {
          const address = result[0];
          res.render('editAddress', { address });
      }
  });
};

exports.updateAddress = (req, res) => {
  const addressId = req.params.id;
  const { label, name_surname, country, street_address, telephone, zipcode, instructions } = req.body;

  const updateData = {
      label,
      name_surname,
      country,
      street_address,
      telephone,
      zipcode,
      instructions
  };

  db.query('UPDATE addresses SET ? WHERE id = ?', [updateData, addressId], (err, result) => {
      if (err) {
          console.error(err);
          res.status(500).send('Errore durante l\'aggiornamento dell\'indirizzo.');
      } else {
          res.redirect('/address');
      }
  });
};