<template>
<div id="app">
  <div class="topnav" id="myTopnav">
  <img src="./images/Hotel_Logo_reducido.png"/>
  <router-link to="/">Inicio</router-link>
  <router-link to="/listadoreservas">Ver Reservas</router-link>
  <!--Botón Acerca De-->
  <a v-on:click="enviar">Acerca de RoyalHotel App</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
<router-view></router-view>
 <!--Footer-->
<br><br><footer>
<p class = "pfooter">RoyalHotel App 1.0 - Aplicación desarrollada por Raúl Ordás Fernández<br>
<a href="https://github.com/raulordas/RoyalHotel-SPA-SpringBoot-OracleSQL-Vue.JS-Axios-REST">Wiki RoyalHotel App</a></p>
</footer>
  </div>
</template>

<script>
export default {

  methods: {
    enviar() {
	  alert('RoyalHotel App 1.0 - Aplicación desarrollada por Raúl Ordás: ordasraul@gmail.com');
	}
  }
}
</script>

<style>
@import 'css/estilos.css';

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
