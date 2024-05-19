# ENUNCIADO
Na tarefa do exame da plataforma de distancia, podedes atopar un ficheiro comprimido “Programación - Exame 3ª Aval. (Unidades 7 e 8).zip”. Trátase dun pequeno proxecto Maven, implementado en Java, orientada ao rexistro das diferentes accións realizadas nun Zoo. A continuación describimos as características que ten o noso sistema:
#### Xestión de animais
O zoo conta con diferentes tipos de animais, que en función da súa clasificación, teñen unha serie de características.
  - Existe unha clase abstracta Animal, que define todas aquelas características aos diferentes tipos de implementación.
  - Cada tipo de animal, ten cualidades diferentes, e moitos soen compartir varias características que se agrupan en función de certas tipoloxías.

#### Xestión de empregados
O zoo conta con diferentes empregados, que en función da súa tipoloxía realizan unha serie de accións propias:
  - Gardas: Realizan funcións non relacionadas cos animais directamente.
  - Coidadores: Son os que tratan cos animais e hai varios tipos:
     ▪ Veterinario
     ▪ Auxiliar

#### Xestión de rexistros
Existe unha clase Rexistro cunha estrutura definida para ser compatible con JAXB a través das súas anotacións, e permite ler e gardar os datos dun documento XML equivalente á estrutura definida nesa clase.
  - Existe unha clase AppMain principal desde a que se inicia a execución da aplicación, nela defínense todos os métodos precisos para interactuar cos usuarios a través da consola.
  - A aplicación non se atopa totalmente finalizada, senón que se fixo unicamente un pequeno deseño Top-Down ao máis alto nivel, onde existen métodos e funcionalidades partes que non se atopan rematadas. 