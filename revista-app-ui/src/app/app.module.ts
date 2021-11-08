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
import { FormSuscripcionComponent } from './suscriptorComponent/form-suscripcion/form-suscripcion.component';
import { TablaEdicionComponent } from './componentes/tabla-edicion/tabla-edicion.component';
import { EdicionesRevistaComponent } from './suscriptorComponent/ediciones-revista/ediciones-revista.component';
import { ViewEditperfilComponent } from './suscriptorComponent/view-editperfil/view-editperfil.component';
import { MiPerfilComponent } from './componentes/mi-perfil/mi-perfil.component';
import { PerfilSubComponent } from './suscriptorComponent/perfil-sub/perfil-sub.component';
import { PerfilEditComponent } from './editorComponent/perfil-edit/perfil-edit.component';
import { FormEditperfilComponent } from './componentes/form-editperfil/form-editperfil.component';
import { FormEditperfilsubComponent } from './suscriptorComponent/form-editperfilsub/form-editperfilsub.component';
import { FormEditperfileComponent } from './editorComponent/form-editperfile/form-editperfile.component';
import { DetallesRevistaComponent } from './componentes/detalles-revista/detalles-revista.component';
import { ReportePageComponent } from './editorComponent/reporte-page/reporte-page.component';
import { ReporteComentarioComponent } from './editorComponent/reporte-comentario/reporte-comentario.component';
import { ReporteSuscripcionComponent } from './editorComponent/reporte-suscripcion/reporte-suscripcion.component';
import { ReporteMegustaComponent } from './editorComponent/reporte-megusta/reporte-megusta.component';
import { ReporteGananciaComponent } from './editorComponent/reporte-ganancia/reporte-ganancia.component';
import { FormPermisosComponent } from './editorComponent/form-permisos/form-permisos.component';
import { HomeAdminComponent } from './adminComponent/home-admin/home-admin.component';
import { HeaderAdminComponent } from './adminComponent/header-admin/header-admin.component';
import { FooterAdminComponent } from './adminComponent/footer-admin/footer-admin.component';
import { ReportesAdminComponent } from './adminComponent/reportes-admin/reportes-admin.component';
import { ReporteGananciasAComponent } from './adminComponent/reporte-ganancias-a/reporte-ganancias-a.component';
import { ReportePopularesComponent } from './adminComponent/reporte-populares/reporte-populares.component';
import { ReporteComentadasComponent } from './adminComponent/reporte-comentadas/reporte-comentadas.component';
import { RevistasPageComponent } from './adminComponent/revistas-page/revistas-page.component';
import { AnunciosPageComponent } from './adminComponent/anuncios-page/anuncios-page.component';
import { FormAnunciosComponent } from './adminComponent/form-anuncios/form-anuncios.component';
import { FormAnuncioTextoComponent } from './adminComponent/form-anuncio-texto/form-anuncio-texto.component';
import { FormAnuncioImagenComponent } from './adminComponent/form-anuncio-imagen/form-anuncio-imagen.component';
import { FormAnuncioVideoComponent } from './adminComponent/form-anuncio-video/form-anuncio-video.component';
import { AnuncioViewComponent } from './adminComponent/anuncio-view/anuncio-view.component';
import { ReporteAnuncioComponent } from './adminComponent/reporte-anuncio/reporte-anuncio.component';




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
    FormSuscripcionComponent,
    TablaEdicionComponent,
    EdicionesRevistaComponent,
    ViewEditperfilComponent,
    MiPerfilComponent,
    PerfilSubComponent,
    PerfilEditComponent,
    FormEditperfilComponent,
    FormEditperfilsubComponent,
    FormEditperfileComponent,
    DetallesRevistaComponent,
    ReportePageComponent,
    ReporteComentarioComponent,
    ReporteSuscripcionComponent,
    ReporteMegustaComponent,
    ReporteGananciaComponent,
    FormPermisosComponent,
    HomeAdminComponent,
    HeaderAdminComponent,
    FooterAdminComponent,
    ReportesAdminComponent,
    ReporteGananciasAComponent,
    ReportePopularesComponent,
    ReporteComentadasComponent,
    RevistasPageComponent,
    AnunciosPageComponent,
    FormAnunciosComponent,
    FormAnuncioTextoComponent,
    FormAnuncioImagenComponent,
    FormAnuncioVideoComponent,
    AnuncioViewComponent,
    ReporteAnuncioComponent,

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
