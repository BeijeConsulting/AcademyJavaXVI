const mysql = require('mysql')

const connection = mysql.createConnection({
  host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
  user: 'admin',
  password: 'FJf7MWgOsW1M5AbKql9g',
  database: 'ecommerce_shoes_3' })

//connection.connect()

/*
connection.query('SELECT * FROM contatti', (err, rows, fields) => {
  if (err) throw err
  console.log('The solution is: ', rows)
})
*/

//connection.end()