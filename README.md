# apache-fn
Ejemplos de Funciones

## Prerequisitos

Se debe tener instalado los siguientes elementos:

- [x] Docker


- [x] Apache Fn

```sh
curl -LSs https://raw.githubusercontent.com/fnproject/cli/master/install | sh
fn start
```

# Ejercicios

Se debe preparar el entorno:

Se define el repositorio de docker a utilizar. Se asume el servicio base de imagenes de contenedores en Docker Hub.

```sh
fn update context registry xnet
```

## Optimizador

```sh
fn init --runtime java optafn
```

|||
|-|-|
|schema_version|identifies the version of the schema for this function file|
|name|Name of your function and directory|
|version|the version of the function|
|runtime|the language used for this function|
|build_image|the image used to build your function’s image|
|run_image|the image your function runs in|
|cmd|the cmd property is set to the fully qualified name of the function class and the method that should be invoked when your javafn function is called|

Crear aplicacion donde desplegar la función:

```sh
fn create app optimizacion
```

Se genera y despliegue la funcion

```sh
fn --verbose deploy --app optimizacion --local
```

|||
|-|-|
|--verbose|genera de forma detallada los pasos del despliegue|
|--app|especifica donde colocar la función|
|--local|despliega localmente usando la imagen de contenedor local. No despliegue la imagen a repositorio remoto útil para despliegue en servidores Fn remotos (por ejemplo, Oracle Functions)|

Si se omite `--local` la imagen de contenedor generada se publica en repositorio de imagenes de contenedores configurado. Por ejemplo,

```sh
Using Container engine  docker  to push
Pushing xnet/optafn:0.0.5 to docker registry...The push refers to repository [docker.io/xnet/optafn]
aa3672c8e426: Pushed
5f70bf18a086: Mounted from xnet/airflow
fcff132253e8: Mounted from fnproject/fn-java-fdk
2eb68678988c: Mounted from fnproject/fn-java-fdk
b8e0b1645a07: Mounted from fnproject/fn-java-fdk
871dee1c7c0e: Mounted from fnproject/fn-java-fdk
b61c7bae62c7: Mounted from fnproject/fn-java-fdk
be8e6912969a: Mounted from fnproject/fn-java-fdk
249e116267fe: Mounted from fnproject/fn-java-fdk-build
0.0.5: digest: sha256:45a094b3f0b329e52d42750a1cd3b58acfb7f00dafa71a101f8522872b94a5c4 size: 2207
Updating function optafn using image xnet/optafn:0.0.5...
```

Se realiza la ejecución de la función de dos formas distintas como se indica a continuación:

## Ejecución local

```sh
fn invoke optimizacion optafn
```

Enviar parametros a la función

```sh
echo -n "{'problem':{}}" | fn invoke optimizacion optafn
```

## Ejecucion remota

```sh

```
