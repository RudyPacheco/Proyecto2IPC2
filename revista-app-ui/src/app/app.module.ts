import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatChipsModule} from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { FlashMessagesModule } from 'flash-messages-angular';
import { ReactiveFormsModule } from '@angular/forms';
import { InformacionRegistroComponent } from './componentes/informacion-registro/informacion-registro.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginGuardian } from './services/login/login.guardian.service';
import { HeaderSubComponent } from './suscriptorComponent/header-sub/header-sub.component';
import { InicioSubComponent } from './suscriptorComponent/inicio-sub/inicio-sub.component';
import { FooterSubComponent } from './suscriptorComponent/footer-sub/footer-sub.component';
import { RevistaPublicComponent } from './suscriptorComponent/revista-public/revista-public.component';
import { MiSuscripcionComponent } from './suscriptorComponent/mi-suscripcion/mi-suscripcion.component';
import { HeaderEditorComponent } from './editorComponent/header-editor/header-editor.component';
import { FooterEditorComponent } from './editorComponent/footer-editor/footer-editor.component';
import { InicioEditorComponent } from './editorComponent/inicio-editor/inicio-editor.component';
import { MiRevistaComponent } from './editorComponent/mi-revista/mi-revista.component';
import { FormRevistaComponent } from './editorComponent/form-revista/form-revista.component';
import { FormEdicionComponent } from './editorComponent/form-edicion/form-edicion.component';
import { TagSelectorComponent } from './componentes/tag-selector/tag-selector.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TagConteinerComponent } from './componentes/tag-conteiner/tag-conteiner.component';
import { PreviRevistaComponent } from './componentes/previ-revista/previ-revista.component';
import { EdicionRevistaComponent } from './editorComponent/edicion-revista/edicion-revista.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistroComponent,
    InformacionRegistroComponent,
    HeaderSubComponent,
    InicioSubComponent,
    FooterSubComponent,
    RevistaPublicComponent,
    MiSuscripcionComponent,
    HeaderEditorComponent,
    FooterEditorComponent,
    InicioEditorComponent,
    MiRevistaComponent,
    FormRevistaComponent,
    FormEdicionComponent,
    TagSelectorComponent,
    TagConteinerComponent,
    PreviRevistaComponent,
    EdicionRevistaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatChipsModule,
    MatIconModule,
    MatToolbarModule,
    MatDividerModule,
    MatButtonModule,
    MatCheckboxModule,
    

  ],
  providers: [LoginGuardian],
  bootstrap: [AppComponent]
})
export class AppModule { }
