# Pokedex-test
  
    Esta app cuenta con 2 endpoints bases, el primero es:
        /pokemons/{set}, donde set representa la paginación de
        los pokemos que se desea traer. es un metodo get y se
        pasa el panametro por url de comenzando desde 0 y de 20
        en 20.

        el segundo end poitn es:
        /pokemon, el cual es un metodo post y recibe en su body
        la url que es traida en el metodo anterior, para asi mostrar
        con más detalle las caracteristicas de dicho pokemon.

# Swagger documentation
    
    Los endpoints anterior estan documentados con Swagger, lo cual nos 
    permite hacer un facil testeo de los 2 endpoints anteriores, para 
    acceder a esta se debe agregar despues del dominio en el cual la app
    este alojada /swagger-ui.html

# Deploy
    
    La app fue desplegada en Heroku, para esto solo se necesito:

    1) Crear una nueva app desde el dashboard de heroku.
    2) Asociar el git hub publico a heroku y dar permisos.
    3) Seleccionar el repositorio que se quiere desplegar.
    4) Seleccionar la rama que se desea desplegar

    Así la app estara desplegada para todo publico desde heroku con 
    un facil despliege.
    

        
