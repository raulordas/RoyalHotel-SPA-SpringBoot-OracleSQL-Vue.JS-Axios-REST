<template>
<div>
<h2>DATOS DE LA RESERVA</h2>
<h3>Nombre</h3>
<input type="text" class="boxinput" v-model="reserva.nombre">
<h3>DNI</h3>
<input type="text" class="boxinput" v-model="reserva.dni">
<br><br>
<h2>FECHA ENTRADA {{$route.query.fechaEntrada}} / FECHA SALIDA {{$route.query.fechaSalida}}</h2>
<h2>HABITACION {{$route.query.habitacion.tipo}}</h2>
<h2>NÚMERO HABITACION {{$route.query.habitacion.num_Hab}}</h2>
<h2>PRECIO HABITACION/DÍA {{$route.query.habitacion.precio}} €</h2>
<h2>DÍAS DE ESTANCIA: {{calcular(fechaEntrada, fechaSalida)}}</h2>
<br>
<h1>EL PRECIO TOTAL DE LA RESERVA ES {{$route.query.habitacion.precio * numDias}} € </h1>
<input type="submit" class="btnform" value="RESERVAR" v-on:click="reservar">
</div>
</template>

<script>
import axios from 'axios'

	export default {
		data() {
			
			return {
				fechaEntrada: this.$route.query.fechaEntrada,
				fechaSalida: this.$route.query.fechaSalida,
				numDias: '',
				reserva: {
					id_Reserva: '',
					dni: '',
					fecha_Entrada: this.$route.query.fechaEntrada,
					fecha_Salida: this.$route.query.fechaSalida,
					nombre: '',
					num_habitacion: this.$route.query.habitacion.num_Hab,
					precio: ''
				}
			}
		},
		
		mounted() {
		
		},
		
		methods: {
			
			calcular(fechaEntrada, fechaSalida) {
			
				axios.get('http://localhost:8085/duracion', {params: {fechaEntrada: this.fechaEntrada, fechaSalida: this.fechaSalida}})
				
				.then(response=>{
					this.numDias = response.data
					this.reserva.precio = this.$route.query.habitacion.precio * this.numDias
				})
				
				.catch(error=>{
					alert('Error');
				
				})
				return this.numDias;
			},
			
			reservar() {
				
				if (this.reserva.nombre == '' || this.reserva.dni == '') {
					alert('Debe rellenar todos los campos');
				
				} else {
					axios.post('http://localhost:8085/reservar', this.reserva)
				
					.then(response=> {
						response.data = this.reserva;
						alert('La Reserva se ha realizado con éxito');
						this.$router.push('/');
					})
				
					.catch(error=> {
					alert('No se ha podido realizar la reserva');
				
					})
				}
			}
		}
	}

</script>