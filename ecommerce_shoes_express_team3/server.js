const express = require('express')
const mysql = require('mysql')

const app = express()
const port = 3000
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'beije',
  database: 'neumann'
})

app.set('view engine', 'ejs')

app.get('/contacts', (req, res) => {

    connection.connect()
    
    connection.query('SELECT * FROM contatti', (err, rows) => {
        if (err) throw err
        console.log('rows: ', rows)
        res.render('contacts', { contacts: rows })
    })

    console.log('end connection...')
    connection.end()
    
  })

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})