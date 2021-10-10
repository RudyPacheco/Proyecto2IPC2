import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { registroServices } from 'src/app/services/registro/registro.service';
import { UsuarioNuevo } from 'src/models/register/newUsuario';
import { Categoria } from 'src/models/uni/categoria.model';
import { NgModule } from '@angular/core';

@Component({
  selector: 'app-informacion-registro',
  templateUrl: './informacion-registro.component.html',
  styleUrls: ['./informacion-registro.component.css']
})


export class InformacionRegistroComponent implements OnInit {


  infoFomr!:FormGroup;
  nuevoUsuario:UsuarioNuevo = this.registroService.getUsuario();
  a!: string;

  constructor(private registroService:registroServices,private formBulder:FormBuilder) { }

  enviar(){
   //console.log(this.a);
   // this.nuevoUsuario=this.registroService.getUsuario();
    //console.log(this.registroService.getUsuario().getNombre());
    //
    console.log(this.nuevoUsuario);
    console.log(this.nuevoUsuario.Nombre);

  }




  ngOnInit(): void {
  }

}
