import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { AppComponent } from './app.component';
import { RecipeService } from './recipe.service'; 

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule // Keep this for HTTP requests
  ],
  providers: [RecipeService], // Provide the service if needed in non-standalone components
  bootstrap: [AppComponent]
})
export class AppModule { }
