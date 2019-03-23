import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatCardModule} from '@angular/material/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { MatSliderModule } from '@angular/material/slider';
import { MatButtonModule,MatFormFieldModule,MatInputModule, MatSelectModule} from '@angular/material';
import { EdicionComponent } from './edicion/edicion.component';
import { DetalleTweetComponent } from './detalle-tweet/detalle-tweet.component';
import { ListadoTweetsComponent } from './listado-tweets/listado-tweets.component';



@NgModule({
  declarations: [
    AppComponent,
    EdicionComponent,
    DetalleTweetComponent,
    ListadoTweetsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    MatSliderModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
