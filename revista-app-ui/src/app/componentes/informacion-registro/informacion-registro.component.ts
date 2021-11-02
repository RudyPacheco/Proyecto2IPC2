import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { registroServices } from 'src/app/services/registro/registro.service';
import { UsuarioNuevo } from 'src/models/register/newUsuario';
import { Categoria } from 'src/models/uni/categoria.model';
import { NgModule } from '@angular/core';
import { UsuarioInfo } from 'src/models/register/usuarioInformacion';
import { Router } from '@angular/router';
import { etiquetasService } from 'src/app/services/informacion/etiquetas.service';

@Component({
  selector: 'app-informacion-registro',
  templateUrl: './informacion-registro.component.html',
  styleUrls: ['./informacion-registro.component.css']
})


export class InformacionRegistroComponent implements OnInit {

  mensaje: string="";
  showError: boolean= false;
  infoFomr!:FormGroup;
  nuevoUsuario:UsuarioNuevo = this.registroService.getUsuario();
  usuarioInfo !: UsuarioInfo;
  options!:string[];
  tagsSelected:string[]=[];

  constructor(private registroService:registroServices,private formBulder:FormBuilder,private router: Router, private tagsService:etiquetasService) {
    this.infoFomr=this.formBulder.group({
       textarea:"",
       etiquetaS:""
    });
   }

   imprimir(){
     console.log(this.infoFomr.get("etiquetaS")?.value);
     var indice = this.tagsSelected.indexOf(this.infoFomr.get("etiquetaS")?.value);
     if (indice==-1) {
      this.tagsSelected.push(this.infoFomr.get("etiquetaS")?.value);
     }
  
     console.log(this.tagsSelected);
   
   }


  enviar(values :any){
   this.usuarioInfo= new UsuarioInfo(this.registroService.usuarioNuevo.usuario,this.infoFomr.get("textarea")?.value,this.tagsSelected);
    this.registroService.guardarInformacion(this.usuarioInfo).subscribe((create: UsuarioInfo)=>{

      console.log(create);

     // if (this.registroService.getUsuario().tipoCuenta==1) {
       // this.router.navigate(['TagSelector'])
      //}else if (this.registroService.getUsuario().tipoCuenta==2) {
        this.router.navigate(['login'])
      //}


      
      

    },
    (error: any)=>{
  
    });
   //console.log(this.a);
   // this.nuevoUsuario=this.registroService.getUsuario();
    //console.log(this.registroService.getUsuario().getNombre());
    //
    //console.log(this.nuevoUsuario);
    //console.log(this.registroService.getUsuario().nombre);
    console.log(this.usuarioInfo);
  }




  ngOnInit(): void {
    this.tagsService.getEtiquetas().subscribe((tags:string[])=>{
      //this.options=this.options.concat(tags);
      this.options=tags;
    });
  }

}
