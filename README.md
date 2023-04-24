# CSTV

CSTV é um aplicativo online, o app exibe uma lista de partidas de CS:GO que estão acontecendo em tempo real e o horário das próximas partidas, 
trazendo informações como os nomes, escudos e jogadores das equipes que disputarão.

# Estrutura do projeto

O projeto possue dois modulos:

- app - Modulo com dependencias direta do framework do Android.
- core - Modulo sem dependências do framework Android.

O Projeto segue a arquitetura MVVM + CleanArctheture com as seguintes estruturas:

- Modulo App:

presentetaion -> Activitys, Fragments, ViewModels, Adapters
di -> Modulo de injecao de dependência 
network -> Camada de configuração de Apis, Responses, ApiClient, Interceptor
remote -> Camada com dependência do retrofit como lib de comunicação
repository -> Camada dedicada a gerenciar os dataSources, implementacao dos contratos dos repositorys do modulo core

- Modulo Core:

repository -> Contratos/Abstracoes de respostory
model -> Entidades/Objetos que representam os responses sem depedencias do retrofit
UseCases -> Casos de uso do app

Libs

- Dagger Hilt
- Paging3
- Glide
- Okhttp
- Retrofit
- GSON

