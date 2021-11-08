import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { etiquetasService } from 'src/app/services/informacion/etiquetas.service';
import { loginServices } from 'src/app/services/login/login.services';
import { edicionPerfilService } from 'src/app/services/registro/actualizarPerfil.service';
import { usuarioLoged } from 'src/models/auth/usuarioLoged';
import { permisosModel } from 'src/models/interacciones/permisos.model';
import { UsuarioNuevo } from 'src/models/register/newUsuario';
import { usaurioActualizacion } from 'src/models/register/usuarioActualizacion';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form-editperfil',
  templateUrl: './form-editperfil.component.html',
  styleUrls: ['./form-editperfil.component.css']
})
export class FormEditperfilComponent implements OnInit {

  usuarioR:usuarioLoged;
  options!:string[];
  tagsSelected:string[]=[];
  editPofileForm!:FormGroup;
  usaurioNuevo!:usaurioActualizacion;
  


  constructor(private loginService:loginServices,private tagsService:etiquetasService,private builder:FormBuilder,private actualizarUsuarioService:edicionPerfilService,private router:Router ) {
    this.usuarioR=this.loginService.usuario;
    this.tagsSelected=this.usuarioR.etiquetasInteres;

    this.tagsService.getEtiquetas().subscribe((tags:string[])=>{
      //this.options=this.options.concat(tags);
      this.options=tags;
    });
    
    this.editPofileForm=this.builder.group({
      nombre:[this.usuarioR.nombre,Validators.required],
      apellido:[this.usuarioR.apellido,Validators.required],
      contrasenia:[''],
      informacion:[this.usuarioR.informacion,Validators.required],
      etiquetaS:['',Validators.required],
    })



   }

   imprimir(){
    console.log(this.editPofileForm.get("etiquetaS")?.value);
    var indice = this.tagsSelected.indexOf(this.editPofileForm.get("etiquetaS")?.value);
    if (indice==-1) {
     this.tagsSelected.push(this.editPofileForm.get("etiquetaS")?.value);
    }
 
    console.log(this.tagsSelected);
  
   }

   limpiarTags(){
    while (this.tagsSelected.length>0) {
      this.tagsSelected.pop();
    }


   }

   guardarCambios(){
    this.usaurioNuevo=this.editPofileForm.value;
     this.usaurioNuevo.usuarioAntiguo=this.loginService.usuario;
     this.usaurioNuevo.etiquetasInteres=this.tagsSelected;

     console.log(this.usaurioNuevo);
    this.actualizarUsuarioService.actualizarDatos(this.usaurioNuevo).subscribe((date)=>{
      console.log("se envio al backend");
      if (this.loginService.usuario.tipoCuenta==1) {
        this.router.navigate(['MiPerfilS'])

      }else if (this.loginService.usuario.tipoCuenta==2) {
        this.router.navigate(['MiPerfilE'])
      }
      

      this.popAfirmation();
    })
   }



  ngOnInit(): void {
  }


  public popAfirmation(){
    Swal.fire(
      'Cambios guardados',
      '',
      'success'
    )
  }

  public popErro(){
    Swal.fire(
      'Error',
      'Ocurrio algun error',
      'error'
    )
  }

}
