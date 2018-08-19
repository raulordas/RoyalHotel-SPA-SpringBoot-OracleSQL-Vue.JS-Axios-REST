<template>
<div>
<h3>En las fechas comprendidas entre {{$route.query.fechaEntrada}} y {{$route.query.fechaSalida}}</h3>
<h3>se han encontrado los siguiente resultados</h3>
<div v-for="item in habitacion" class="inline">
<img v-bind:src="tipofoto(item)" class="foto"/>
<h4>{{item.tipo}}</h4>
<h4>{{item.precio}} €/Dia</h4>
<input type="submit" class="btnform" value="RESERVAR" v-on:click="$router.push({path:'/reservar', query:{habitacion: item, fechaEntrada: $route.query.fechaEntrada, fechaSalida: $route.query.fechaSalida}})">
<br><br><br><br><br><br>
</div><br><br><br>
<input type="submit" class="btnform" value="REGRESAR AL INICIO" v-on:click="$router.push('/')">
</div>
</template>

<script>
import axios from 'axios'

	export default {
		data() {
			
			return {
			habitacion: [],
			habitacionesOcupadas: [],
			habitacionesDisponibles: [100, 101, 102]
			}
		},
		
		mounted() {
		
			axios.get('http://localhost:8085/listarHabitaciones', { params: {
					fechaEntrada:this.$route.query.fechaSalida,
					fechaSalida: this.$route.query.fechaSalida}})
			
			.then(response=> {
				
				this.habitacionesOcupadas = response.data

				for (var i = 0; i < this.habitacionesOcupadas.length; i++) {
					for (var j = 100; j <= 102; j++) {
						if (this.habitacionesOcupadas[i] === j) {
							this.habitacionesDisponibles.splice(this.habitacionesDisponibles.indexOf(j), 1);
						}
					}
				}
				
				
				var params = new URLSearchParams();
				for (var k = 0; k < this.habitacionesDisponibles.length; k++) {
				params.append("numeroHabitaciones", this.habitacionesDisponibles[k]);
			}
			
			axios.get('http://localhost:8085/listarHabitacionesDisponibles?' + params)
				
				.then (response=> {
					this.habitacion = response.data
				})
				
				.catch(error=> {
					alert('No se ha podido conectar al servidor');
				})
			})
			
			.catch(error=> {
				alert('No se ha podido conectar con el servidor');
			})
		},
		
		methods: {
			tipofoto(item) {
				if  (item.tipo == 'INDIVIDUAL') {
					return  "/static/INDIVIDUAL.jpg"
				} else if(item.tipo == 'DOBLE') {
					return '/static/DOBLE.jpg'
				} else {
					return '/static/SUITE.jpg'
				}
			}
		}
	}

</script>