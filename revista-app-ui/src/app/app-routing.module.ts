import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeAdminComponent } from './adminComponent/home-admin/home-admin.component';
import { ReporteComentadasComponent } from './adminComponent/reporte-comentadas/reporte-comentadas.component';
import { ReporteGananciasAComponent } from './adminComponent/reporte-ganancias-a/reporte-ganancias-a.component';
import { ReportePopularesComponent } from './adminComponent/reporte-populares/reporte-populares.component';
import { ReportesAdminComponent } from './adminComponent/reportes-admin/reportes-admin.component';
import { RevistasPageComponent } from './adminComponent/revistas-page/revistas-page.component';
import { DetallesRevistaComponent } from './componentes/detalles-revista/detalles-revista.component';
import { InformacionRegistroComponent } from './componentes/informacion-registro/informacion-registro.component';
import { LoginComponent } from './componentes/login/login.component';
import { MiPerfilComponent } from './componentes/mi-perfil/mi-perfil.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { TagConteinerComponent } from './componentes/tag-conteiner/tag-conteiner.component';
import { TagSelectorComponent } from './componentes/tag-selector/tag-selector.component';
import { EdicionRevistaComponent } from './editorComponent/edicion-revista/edicion-revista.component';
import { FormEdicionComponent } from './editorComponent/form-edicion/form-edicion.component';
import { FormEditperfileComponent } from './editorComponent/form-editperfile/form-editperfile.component';
import { FormPermisosComponent } from './editorComponent/form-permisos/form-permisos.component';
import { FormRevistaComponent } from './editorComponent/form-revista/form-revista.component';
import { InicioEditorComponent } from './editorComponent/inicio-editor/inicio-editor.component';
import { MiRevistaComponent } from './editorComponent/mi-revista/mi-revista.component';
import { PerfilEditComponent } from './editorComponent/perfil-edit/perfil-edit.component';
import { ReporteComentarioComponent } from './editorComponent/reporte-comentario/reporte-comentario.component';
import { ReporteGananciaComponent } from './editorComponent/reporte-ganancia/reporte-ganancia.component';
import { ReporteMegustaComponent } from './editorComponent/reporte-megusta/reporte-megusta.component';
import { ReportePageComponent } from './editorComponent/reporte-page/reporte-page.component';
import { ReporteSuscripcionComponent } from './editorComponent/reporte-suscripcion/reporte-suscripcion.component';
import { LoginGuardian } from './services/login/login.guardian.service';
import { EdicionesRevistaComponent } from './suscriptorComponent/ediciones-revista/ediciones-revista.component';
import { FormEditperfilsubComponent } from './suscriptorComponent/form-editperfilsub/form-editperfilsub.component';
import { FormSuscripcionComponent } from './suscriptorComponent/form-suscripcion/form-suscripcion.component';
import { InicioSubComponent } from './suscriptorComponent/inicio-sub/inicio-sub.component';
import { MiSuscripcionComponent } from './suscriptorComponent/mi-suscripcion/mi-suscripcion.component';
import { PerfilSubComponent } from './suscriptorComponent/perfil-sub/perfil-sub.component';
import { RevistaPublicComponent } from './suscriptorComponent/revista-public/revista-public.component';
import { ViewEditperfilComponent } from './suscriptorComponent/view-editperfil/view-editperfil.component';



const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'', redirectTo:'login', pathMatch:'full' },
  {path:'registro', component:RegistroComponent},
  {path: 'informacion',component:InformacionRegistroComponent},
  {path: 'inicioSUB',component:InicioSubComponent},
  {path: 'Revistas', component:RevistaPublicComponent},
  {path: "Suscripciones", component:MiSuscripcionComponent},
  {path:'inicioED',component:InicioEditorComponent},
  {path:'Mis/Revistas',component:MiRevistaComponent},
  {path:'Nueva-Revista',component:FormRevistaComponent},
  {path:'Nueva-Edicion',component:FormEdicionComponent},
  {path:'TagSelector',component:TagConteinerComponent},
  {path:'Edicones',component:EdicionRevistaComponent},
  {path:'FormPago',component:FormSuscripcionComponent},
  {path:'Ediciones/Suscripciones',component:EdicionesRevistaComponent},
  {path:'PerfilEditor',component:ViewEditperfilComponent},
  {path:'MiPerfilS',component:PerfilSubComponent},
  {path:'MiPerfilE',component:PerfilEditComponent},
  {path:'EdicionPerfilS',component:FormEditperfilsubComponent},
  {path:'EdicionPerfilE',component:FormEditperfileComponent},
  {path:'DetallesRevista',component:DetallesRevistaComponent},
  {path:'ReportesEditor',component:ReportePageComponent},
  {path:'FormReporteComentarios',component:ReporteComentarioComponent},
  {path:'FormReporteSuscripcion',component:ReporteSuscripcionComponent},
  {path:'FormReporteMeGusta',component:ReporteMegustaComponent},
  {path:'FormReporteGananciasE',component:ReporteGananciaComponent},
  {path:'FormPermisos',component:FormPermisosComponent},
  {path:'InicioAdmin',component:HomeAdminComponent},
  {path:'ReportesAdmin',component:ReportesAdminComponent},
  {path:'FormReporteGananciasA',component:ReporteGananciasAComponent},
  {path:'FormReportePopulares',component:ReportePopularesComponent},
  {path:'FormReporteComentadas',component:ReporteComentadasComponent},
  {path:'RevistasGenerales',component:RevistasPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
