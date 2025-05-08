Manual de instruções para rodar o projeto

O projeto está é o arquivo zipado chamado pessoa_crud.zip
O servidor está zipado em tar.gz descompactar ele pois usei linux mas serve no windowns basta dezipar com o descompactador correto irei deixar outro em zip para windowns.

O projeto irá rodar no seguinte link:

http://localhost:8080/pessoa_crud/

1- Servidor de aplicação WildFly (estou usando a versão 24+ já está incluso com biblioteca do postgresql + standalone.xml ja configurado)

obs: É importante usar o que eu disponibilizei em zip pois ele já está pronto para uso. Mas caso optar por não usar terá que criar pasta org > postgresql
 e jogar o driver mais recente mas isso custa tempo, então deixei o servidor já com as libs pronta para uso


2- Ide Eclipse 

obs: Em todo o desenvolvimento foi usado java na versão 11 na ide mais atual do eclipse. Para instalar basta seguir para o site
para baixar Eclipse IDE for Web Developers ou melhor Eclipse EE quanto a versão pode utilizar a mais atual.


link eclipse: https://www.eclipse.org/downloads/packages/installer

obs2: Utilize o Eclipse IDE pois outras ides como INTELLIJ COMUNITY não tem suporte para importar servidor externo então é importante esse passo.



3- Ter localmente o banco de dados postgresql

obs: Aqui é outro ponto importante deve ter em sua maquina configurado o postgresql quanto a versão utilize a mais recente sem problemas
outro ponto importante utilize o dbeaver para conectar use a senha root, usuario root deixarei script sql para gerar as tabelas e criar o banco também.


4- Configuração do projeto localmente

1- Importe o projeto indo ao lado do projetct explore do eclipse ee vá em import project va em general e ir até Existing project in Workspace

2- importe o projeto e após isso clique no projeto na aba do project explore clique com o botão direito do mouse e 

ir na opção build path > Project Facets > Marque as seguintes opções do checkbox

Dynamic Web Module
Java 17
Javascript
Java Server Faces
Jpa

Após isso clique em apply 



5 - Importar libs

obs: na mesma aba de build path > Configure Build Path > Add Jars importe os jars existente na pasta lib do projeto importante pois, elas carregam o primefaces
Junit etc importe todos existentes e confirme com apply 


obs2: você pode verificar a versão de compilação também na aba de Java Compiler sempre verifique se está com as versões que eu usei no projeto para não ocorrer
erros de lib.



6- Importar o servidor WildFly + Importar o projeto dentro do servidor de aplicação

Obs: Esse é o ultimo ponto de configuração devemos fazer os seguintes passos.


1- Importar o servidor que eu enviei dezipar ele e ir na sequinte aba pode encontrar a aba Servers indo no menu superior

Window > Show View > Servers


Após clicar ele vai redirecionar para o console a opção servers onde terá uma breve mensagem

Add Servers clique nele ao clicar irá abrir varias opçẽos de servidores ecolha a seguinte.


Red Hat JBOSS MiddeWare, Wildfly Server etc irá aparecer assim no caso a primeira vez.

obs: essa etapa vai demorar um pouco para baixar pois o eclipse vai baixar todos os plugins necessários.

Após concluir irá abrir a aba e selecionar WildFly 24+ e proxeguir. 


obs2: como já está tudo configurado não precisa mexer no arquivo standalone.xml



Agora iremos importar o nosso projeto web para dentro do servidor de aplicação 


Perceba que a aba irá mudar no caso perto do console irá aparecer o servidor WildFly porém vazio, agora o ponto importante
clique em cima do servidor irá aparecer da seguinte forma.

WildFly 24 + clique com o botão direito do mouse e vá em add and remove > e escolha o war pessoa_crud
agora basta executar e assim subimos o nosso projeto em wildFly.


Outras dicas utils aqui vai um video explicativo onde eu pesquisei bastante sobre como configurar o servidor onde
encontrar cada aba no eclipse vai aqui linkado o video que usei de consulta


part 1 :https://www.youtube.com/watch?v=55lYv9UrrWM&t=868s
part 2 : https://www.youtube.com/watch?v=jTX94bkyrUk&t=1316s


Irei enviar também fotos de como é o front end do projeto quando abrir. Irei anexar nos arquivos a serem enviados.
dezipar o arquivo.
