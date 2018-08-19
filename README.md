# RoyalHotel APP 1.0
## Aplicación que permite verificar la disponibilidad de habitaciones en un hotel en un periodo de fechas determinado.
Permite realizar una reserva anotando los datos del cliente solicitados y los propios de la reserva.

### Desarrollado en Java utilizando el framework SpringBoot + Hibernate con motor SQL Oracle. Para el Frontend se ha utilizado el framework Vue.JS basado en Javascript y la librería axios para la comunicación REST-API con el backend.

Características básicas:
* Buscar Disponibilidad en fechas.
* Las Fechas se comprueban: La fecha de entrada no puede ser anterior al dia en que se realiza la reserva. La fecha de entrada no puede ser mayor que la fecha de salida, etc.
* La reserva calcula el importe total acorde a los dias elegidos.
* La reserva se almacena en la base de datos.
* Se pueden consultar las reservas realizadas en el hotel y eliminar la que que se considere oportuna.
![](https://user-images.githubusercontent.com/35290259/44307618-a05a3d80-a3a5-11e8-9943-6a828ab3b7e9.PNG)
![](https://user-images.githubusercontent.com/35290259/44307619-a0f2d400-a3a5-11e8-829c-6043fc073237.PNG)
![](https://user-images.githubusercontent.com/35290259/44307620-a0f2d400-a3a5-11e8-84d9-8d8335a65bdb.PNG)
![](https://user-images.githubusercontent.com/35290259/44307621-a0f2d400-a3a5-11e8-8122-cc662779f9a2.PNG)
