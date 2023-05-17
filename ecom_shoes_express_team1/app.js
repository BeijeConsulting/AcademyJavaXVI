const express = require('express')
const path = require('path');
const app = express()
const port = 3000
const db = require('./db');

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

app.get('/users', (req, res) => {
  db.query('SELECT * FROM users', (err, rows) => {
      if (err) throw err
      console.log('rows: ', rows)
      res.render('users', { users: rows })
  })
})
