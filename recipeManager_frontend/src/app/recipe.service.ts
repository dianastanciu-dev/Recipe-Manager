import { Recipe } from './recipe';

//This RecipeService class provides methods to interact with a backend API to perform CRUD
//(Create, Read, Update, Delete) operations on Recipe objects. 
//It uses Angular's HttpClient to send HTTP requests and handles the responses using Observables from RxJS.

@Injectable({

    providedIn: 'root' //The providedIn: 'root' syntax makes this service available application-wide, 
    //meaning it will be a singleton and can be injected anywhere in the app.
})

export class RecipeService{

    private apiServerUrl = ''; // private class attribute meant to hold the base URL of the API server. 
    //It is currently an empty string and should be set to the actual server URL

    constructor(private http: HttpClient){ } //This constructor injects the HttpClient service into the RecipeService class. 
    //The HttpClient is used to make HTTP requests to the API.

    public getRecipes(): Observable<Recipe[]> {   
//syntax:    Observable<T>, argument T specifies the type of data that the observable will emit 
//Observable<Recipe[]>: This indicates an observable that emits arrays of Recipe objects.

        return this.http.get<Recipe[]>('${this.apiServerUrl}/recipe/all');
         //Makes a GET request to the API to fetch all recipes.
         //Returns an Observable that emits an array of Recipe objects.
    }

    public addRecipes(recipe: Recipe): Observable<Recipe> {
        //The method "addRecipes" takes one parameter, recipe, which is of type Recipe.

        return this.http.post<Recipe>('${this.apiServerUrl}/recipe/add', recipe);
          //Makes a POST request to the API to add a new recipe.
          //Takes a Recipe object as a parameter.
          //Returns an Observable that emits the added Recipe object
          //`${this.apiServerUrl}/recipe/add` ----> This is the URL to which the POST request is sent. 
    }

    public updateRecipes(recipe: Recipe): Observable<Recipe> {

        return this.http.put<Recipe>('${this.apiServerUrl}/recipe/update', recipe);
        //Makes a PUT request to the API to update an existing recipe.
    }
 
    public deleteRecipes(recipeId: number): Observable<void> {

        return this.http.delete<void>('${this.apiServerUrl}/recipe/delete/${recipeId}');
        //Makes a DELETE request to the API to delete a recipe by its ID.
    }

}