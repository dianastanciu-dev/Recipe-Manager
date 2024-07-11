HTTP Process

GET Requests: The client makes GET requests to the RecipeResource endpoints.

Controller (Resource Layer):

RecipeResource controller handles the incoming GET request. It is annotated with @RestController and request mapping annotations like @GetMapping.
The controller uses dependency injection to get an instance of the RecipeService --> delegates the fetching of data to the RecipeService.

Service Layer:

RecipeService service layer contains business logic and interacts with the repository layer to fetch data from the database.
Methods in the service layer (like findAllRecipes and findRecipeById) fetch data and return it as domain objects (e.g., List<Recipe> or Recipe).

Repository Layer:

The repository layer interacts with the database. 

JSON Domain Objects: The data fetched from the database is returned as domain objects (Recipe) and automatically converted to JSON by Spring before being sent to the client.
