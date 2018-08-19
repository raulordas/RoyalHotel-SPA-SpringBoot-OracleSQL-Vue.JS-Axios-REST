<template>
<div>
<h2>RESERVAS REALIZADAS</h2>

<table>
<tr>
<td>NUMERO RESERVA</td>
<td>NOMBRE</td>
<td>DNI</td>
<td>FECHA ENTRADA</td>
<td>FECHA SALIDA</td>
<td>NUMERO HABITACION</td>
<td>PRECIO TOTAL</td>
</tr>
<tr v-for="item in reserva">
<td>{{item.id_Reserva}}</td>
<td>{{item.nombre}}</td>
<td>{{item.dni}}</td>
<td>{{item.fecha_Entrada}}</td>
<td>{{item.fecha_Salida}}</td>
<td>{{item.num_habitacion}}</td>
<td>{{item.precio}}</td>
<td><input type="submit" class="btnform" value="ELIMINAR RESERVA" v-on:click="eliminar(item)"/></td>
</tr>
</table>
</div>
</template>

<script>
import axios from 'axios'

	export default {
		data() {
			
			return {
				reserva: ''
			}
		},
		
		mounted() {
			axios.get('http://localhost:8085/listadoreservas')
			
			.then(response=>{
				this.reserva = response.data
			})
			
			.catch(error=>{
				alert('No se han podido conectar con el servidor');
			})
		},
		
		methods: {
		
			eliminar(item) {
				var res = confirm ('Se dispone a eliminar la reserva de ' + item.nombre + ' ¿Está seguro de que desea continuar?');
			
				if (res == 1) {
					axios.post('http://localhost:8085/eliminar', item)
				
					.then(response=> {
						response.data = item
					})
				
					.catch(error=> {
						alert('No se ha podido eliminar la reserva');
					})
				}
				this.$router.go(this.$router.currentRoute);
			}
		}
	}

</script>