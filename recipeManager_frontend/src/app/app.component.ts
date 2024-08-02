import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RecipeService } from './recipe.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';  
import { HttpClientModule } from '@angular/common/http';  
import { Recipe } from './recipe'; //Recipe model

//This component fetches a list of recipes from a backend service when it initializes and 
//makes this data available for use in the component's template.


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,  CommonModule, HttpClientModule],
  templateUrl: './app.component.html', //Points to the HTML file that defines the view for this component
  styleUrls: ['./app.component.css'] //Points to the CSS file that styles this component.
})
export class AppComponent implements OnInit {
  //implements OnInit: Indicates that this component uses the OnInit lifecycle hook
  public recipes: Recipe[] = []; //Initialized with an empty array
  //public (will be used in html file) property "recipes" will hold an array of objects (Recipe) coming from the backend 

  constructor(private recipeService: RecipeService){ } 
  //private recipeService: A service injected into this component. 
  //This service will be used to fetch the recipes from the backend.

  ngOnInit(){
      this.getRecipes();
  } //ngOnInit: A lifecycle hook that is called once the component is initialized. 
  //It calls the getRecipes method to fetch the recipes when the component loads.

  public getRecipes(): void{

    this.recipeService.getRecipes().subscribe(  //Call the getRecipes method from the RecipeService, which returns an observable
      (response: Recipe[]) => {   // Success callback: executed when the observable emits data
        this.recipes = response; // Assign the received data (list of recipes) to the recipes property
      },
      (error: HttpErrorResponse) =>{ // Error callback: executed if an error occurs during the HTTP request
        alert(error.message);   // Display an alert with the error message
      }
    );
  }
   
}
