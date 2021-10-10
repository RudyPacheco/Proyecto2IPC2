import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformacionRegistroComponent } from './componentes/informacion-registro/informacion-registro.component';
import { LoginComponent } from './componentes/login/login.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { TagConteinerComponent } from './componentes/tag-conteiner/tag-conteiner.component';
import { TagSelectorComponent } from './componentes/tag-selector/tag-selector.component';
import { FormEdicionComponent } from './editorComponent/form-edicion/form-edicion.component';
import { FormRevistaComponent } from './editorComponent/form-revista/form-revista.component';
import { InicioEditorComponent } from './editorComponent/inicio-editor/inicio-editor.component';
import { MiRevistaComponent } from './editorComponent/mi-revista/mi-revista.component';
import { LoginGuardian } from './services/login/login.guardian.service';
import { InicioSubComponent } from './suscriptorComponent/inicio-sub/inicio-sub.component';
import { MiSuscripcionComponent } from './suscriptorComponent/mi-suscripcion/mi-suscripcion.component';
import { RevistaPublicComponent } from './suscriptorComponent/revista-public/revista-public.component';



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
  {path:'TagSelector',component:TagConteinerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
