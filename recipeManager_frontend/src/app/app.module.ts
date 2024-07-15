import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from  '@angular/core';
//import {FormModule} from '@angular/forms';
import [HttpModule] from '@angular/http';

import {AppComponent} from './app.component';
import {RecipeService} from './recipe.service';

@NgModule({

    declarations: [
        AppComponent,
        RecipeService
    ],
    imports: [
        BrowserModule,
        //FormsModule,
        HttpModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule{   }