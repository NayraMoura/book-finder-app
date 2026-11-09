# Book Finder 📚

**Nome:** Nayra dos Santos Moura  
**Data de entrega:** 02/11/26  

---

## 💡 Justificativa da escolha do tema

O Book Finder nasceu da necessidade de solucionar um problema muito comum na era da informação: a sobrecarga de opções. Atualmente, com a facilidade de acesso a milhares de títulos digitais e físicos, muitos leitores sentem-se perdidos e enfrentam a "paralisia da escolha" na hora de decidir qual será a sua próxima leitura, ou têm dificuldade em encontrar obras que realmente se alinhem aos seus gostos pessoais.

Para solucionar esta dor, o aplicativo foi desenvolvido pensando em leitores ávidos, estudantes e entusiastas da literatura que buscam uma forma simples, centralizada e esteticamente agradável de descobrir novos livros.

---

## 🚀 Propósito e funcionalidades principais

### Propósito
O **Book Finder** é um aplicativo Android desenvolvido para auxiliar leitores a descobrirem novas leituras de forma rápida, intuitiva e personalizada.

### Funcionalidades principais
- **Autenticação e Registro de Leitores**: Tela de login intuitiva onde o usuário insere seu nome de usuário e senha.
- **Persistência Local do Usuário**: Armazena o histórico do último usuário logado no banco de dados local (Room) para recuperar e auto-preencher os dados em acessos futuros via `StateFlow`.
- **Guia Literário Personalizado**: Tela de recepção e direcionamento de busca literária personalizada com o nome do usuário.
- **Navegação Fluida**: Transição segura e reativa entre telas utilizando Jetpack Navigation Compose.
- **Interface Temática**: Design moderno e adaptável totalmente construído em Jetpack Compose com sistema de temas dinâmico (`BookFinderTheme`).

---

## 🛠️ Guias de uso e integração

### Requisitos do Sistema
- **Android Studio**: Ladybug / Jellyfish ou superior
- **JDK**: 11 ou superior
- **Compile SDK**: 36
- **Min SDK**: 24 (Android 7.0+)

### Guia de Uso
1. **Inicialização**: Ao abrir o aplicativo, o leitor é direcionado para a tela de **Login** (`LoginScreen`). Caso já tenha efetuado login anteriormente, seu nome de usuário será carregado automaticamente do banco de dados Room.
2. **Identificação**: Digite o nome de usuário e a senha e clique no botão **Entrar**.
3. **Redirecionamento**: O app persiste os dados do usuário e navega para a **Tela de Busca Literária** (`SearchScreen`), passando o nome do usuário como argumento de rota.
4. **Busca Literária**: Na `SearchScreen`, o usuário visualizará a saudação personalizada e poderá avançar no processo de escolha de livros.

---

## 📜 Definições de APIs e tipos de dados

### 1. Entidade de Banco de Dados (`UserEntity`)
Representa a tabela local `users` gerenciada pelo Room Database:

```kotlin
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
)
```

### 2. Interface de Acesso aos Dados (`UserDao`)
Contrato de persistência local:

```kotlin
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users ORDER BY id DESC LIMIT 1")
    suspend fun getLastLoggedUser(): UserEntity?
}
```

### 3. Rotas de Navegação (`AppRoutes`)
Contrato das rotas de navegação da aplicação:

```kotlin
object Routes {
    const val LOGIN = "login_screen"
    const val SEARCH = "search_screen/{username}"

    fun createSearchRoute(username: String) = "search_screen/$username"
}
```

---

## 🏛️ O histórico de arquitetura

O aplicativo foi estruturado seguindo os princípios de **Clean Architecture** e o padrão **MVVM (Model-View-ViewModel)** recomendado pelo Google para desenvolvimento Android moderno:

1. **Interface em Jetpack Compose**:
   - Construção de UI declarativa, modularizada em componentes reutilizáveis (`BookFinderTextField`, `PrimaryButton`).

2. **Arquitetura em Camadas (MVVM)**:
   - **Camada de UI (View)**: Responsável exclusivamente por renderizar elementos visuais (`LoginScreen`, `SearchScreen`).
   - **Camada de ViewModel**: `LoginViewModel` gerencia o estado da interface utilizando `StateFlow` e executa operações assíncronas via `Coroutines`.
   - **Camada de Repositório (Data)**: `UserRepository` abstrai a fonte de dados, permitindo fácil expansão futura (como integração de APIs REST de livros).
   - **Camada de Banco de Dados Local**: Room Database (`BookFinderDatabase`, `UserDao`, `UserEntity`).

3. **Persistência Reativa e Assíncrona**:
   - Utilização do **Room Database** integrado a `Kotlin Coroutines` (`suspend fun`), garantindo que consultas ao banco não bloqueiem a Main Thread da UI.

4. **Navegação com Navigation Compose**:
   - Desacoplamento entre as telas usando o `BookFinderNavHost`, garantindo transferência de parâmetros limpa e navegação segura.

---

## 📌 Escopo Atual e Futuras Implementações (Roadmap)

- **Login Social (Google)**: A opção visual do Google na tela de login é atualmente um elemento de interface (*placeholder UI*). A integração completa com a API do Google Sign-In / OAuth 2.0 está planejada para versões futuras.
- **Catálogo de Livros e APIs Externas**: Expansão do repositório para consumir APIs REST externas (como a Google Books API) para pesquisa de títulos e recomendações em tempo real.

---

## 🎨 Design e Prototipagem

A interface deste MVP foi planeada com foco na experiência do utilizador. O moodboard completo e as telas que serão desenvolvidas nas próximas versões do aplicativo, estão disponíveis para visualização através do protótipo interativo:

👉 **[Acessar Protótipo no Figma](https://www.figma.com/design/cdYEoJEFkGpZwzK6BlZE2U/Design-System?node-id=0-1&t=D7OnImJjWRHlxbNd-1)**
