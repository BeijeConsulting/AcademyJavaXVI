<template>
  <router-view/>
</template>

<style lang="scss">
@import 'bootstrap/dist/css/bootstrap.css';
@import './assets/variable.scss';
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-family: 'Roboto', sans-serif;
  box-sizing: border-box;
  height: 100%;
}
html{
  height: 100%;
}
body{
  height: 100%;
}
h2{
  color: white;
  margin: 40px 0 24px 0;
  font-family: 'Roboto', sans-serif;
}
.container-fluid{
  background-color: $primary-color;
}
</style>
