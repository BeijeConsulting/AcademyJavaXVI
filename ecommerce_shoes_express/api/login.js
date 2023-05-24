const express=require('express')
const router=express.Router()
const mysql = require('mysql')

const connection = mysql.createConnection({
    host: 'skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com',
    user: 'admin',
    password: 'FJf7MWgOsW1M5AbKql9g',
    database: 'ecommerce_shoes_4'
  })

  router.use(express.urlencoded({
    extended: true
  }))




router.get('/login', (req, res) => {
  
    res.render('login',{message:''})
  });
  
  router.get('/register', (req, res) => {
    res.render('register')
  })
  
  router.post('/register', (req,res)=>{
    console.log("/register POST");
  
    const { name,surname,telephone,birthdate,email, password } = req.body;
    if (name === '' || surname === '' || telephone === '' || birthdate === '' || email === '' || password === '') {
      
      res.render('login', { message: 'Registrazione non avvenuta, campi obbligatori' });
      return
    } 
    const values = [name, surname, telephone, birthdate, email, password];
    connection.query(`INSERT INTO users (name, surname, telephone, birth_date, email, password)  VALUES (?, ?, ?, ?, ?, ?)`, values,(err, userInsert) =>{
      if (err){
        res.render('login', { message: 'Registrazione non avvenuta' });
        throw err
      } 
  
      connection.query(`INSERT INTO user_authority (user_id, authority_id) VALUES (?,1) `,[userInsert.insertId], (errSelect) =>{
        if (errSelect) throw errSelect
  
      })
      res.render('login', { message: 'Registrazione avvenuta con successo' });
   });
  
  })
  
  router.get("/logout", (req,res) =>{
    console.log("/logout GET");
    res.clearCookie('user')
    res.redirect('/');
  })

  router.post('/login', (req, res) => {
    const { email, password } = req.body;
    connection.query('SELECT * FROM users  where email = ? AND password = ?',[email, password], (err, user) => {
      if (user.length > 0) {
        res.cookie('user', user);
        res.json(user)
       // res.redirect('/');
      }else{
        res.status(401).send('Credenziali non valide');
      //  res.send('Credenziali errate');
      }
    })
  });

  module.exports=router;