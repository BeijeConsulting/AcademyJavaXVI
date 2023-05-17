const express = require('express')
const app = express()
const port = 3000
const db = require('./db');


app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

app.get('/test', (req, res) => {

  
  db.query('SELECT * FROM users', (err, rows) => {
      if (err) throw err
      console.log('rows: ', rows)
      res.render('users', { users: rows })
  })

  console.log('end connection...')
  
})