const express=require('express')
const router=express.Router()

router.get('/', (req, res) => {
  res.clearCookie('session').redirect('/login')
})

module.exports=router;
