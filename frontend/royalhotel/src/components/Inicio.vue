<template>
<div>
<div id="logo">
<div class="slider">
<h1>Desarrollo<br> SpringBoot Java<br> + Vue.JS</h1>
</div><br><br>
</div>
<h3>Fecha de Entrada</h3><input type="date" class="boxinput" v-model="fechaEntrada"/><br>
<h3>Fecha de Salida</h3><input type="date" class="boxinput" v-model="fechaSalida"/><br><br><br>
<input type="submit" value="Consultar Disponibilidad" class="btnform" v-on:click="comprobarDisponibilidad"/>
</div>
</template>

<script>

export default {
  name: 'Inicio',
  
  data () {

    return {
	  fechaEntrada: '',
	  fechaSalida: '',
	  fecha: new Date()
    }
  },
  
  methods: {
	comprobarDisponibilidad: function() {
		var fechaHoy = this.fecha.getFullYear() + '-' + '0' + (this.fecha.getMonth() + 1) + '-' + this.fecha.getDate();
	
		if (this.fechaEntrada == '' || this.fechaSalida == ''){
			alert('Debe escoger fecha de entrada y de salida');
		} else if(this.fechaEntrada < fechaHoy) {
			alert('La Fecha de Entrada no puede haber ocurrido ya');
			
		} else if (this.fechaEntrada > this.fechaSalida) {
			alert('La fecha de entrada debe ser anterior a la fecha de salida');
		} else {
			this.$router.push({path: '/habitacionesDisponibles', query: {fechaEntrada: this.fechaEntrada, fechaSalida:this.fechaSalida}})
		}
	}
  }
}
</script>