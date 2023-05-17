const mysql = require('mysql')

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'beije',
  database: 'neumann'
})

//connection.connect()

connection.query('SELECT * FROM contatti', (err, rows, fields) => {
  if (err) throw err
  console.log('The solution is: ', rows)
})

//connection.end()