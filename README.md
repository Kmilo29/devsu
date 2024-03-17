# Pasos para desplegar 

# 1. En la carpeta raiz del proyecto donde se encuentra el archivo docker-compose.yml ejecutar el comando

	docker-compose up

# 2. Ingresar a Rabbitmq despues de que el sistema despligue (si se despliega local use localhost)

	http://<host>:15672/
	
	**user**: guest
	**password** gest
	
# 3. Crear una cola llamada 	

	cola_devsu

# 4. Para probar el proyecto se adjunta el archivo "Devsu.postman_collection"

