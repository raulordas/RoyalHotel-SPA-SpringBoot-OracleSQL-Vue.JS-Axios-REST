import Vue from 'vue'
import Router from 'vue-router'
import HabitacionesDisponibles from '@/components/HabitacionesDisponibles'
import Inicio from '@/components/Inicio.vue'
import Reservas from '@/components/Reservas.vue'
import ListadoReservas from '@/components/ListadoReservas.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Inicio',
      component: Inicio
    },
	
	{
		path: '/habitacionesDisponibles',
		name: 'HabitacionesDisponibles',
		component: HabitacionesDisponibles,
		props: true
	},
	
	{
		path: '/reservar',
		name: 'Reservas',
		component: Reservas
	},
	
	{
		path: '/listadoreservas',
		name: 'ListadoReservas',
		component: ListadoReservas
	}
	
  ]
})
