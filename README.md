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
