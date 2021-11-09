import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './component/template/header/header.component';
import { FooterComponent } from './component/template/footer/footer.component';
import { NavComponent } from './component/template/nav/nav.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { HotelListComponent } from './component/view/hotel/hotel-list/hotel-list.component';
import { HomeComponent } from './component/view/home/home.component';
import { HotelFormComponent } from './component/view/hotel/hotel-form/hotel-form.component';
import { QuartoListComponent } from './component/view/quarto/quarto-list/quarto-list.component';
import { QuartoFormComponent } from './component/view/quarto/quarto-form/quarto-form.component';
import { HospedeListComponent } from './component/view/hospede/hospede-list/hospede-list.component';
import { HospedeFormComponent } from './component/view/hospede/hospede-form/hospede-form.component';
import { HospedagemListComponent } from './component/view/hospedagem/hospedagem-list/hospedagem-list.component';
import { HospedagemFormComponent } from './component/view/hospedagem/hospedagem-form/hospedagem-form.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HotelListComponent,
    HomeComponent,
    HotelFormComponent,
    QuartoListComponent,
    QuartoFormComponent,
    HospedeListComponent,
    HospedeFormComponent,
    HospedagemListComponent,
    HospedagemFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatCardModule,
    MatButtonModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
